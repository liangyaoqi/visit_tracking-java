package com.zkt.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkt.entity.Operator;
import com.zkt.service.OperatorService;
import com.zkt.util.ApiResponse;
import com.zkt.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/operator")
public class OperatorController {

    private OperatorService operatorService;

    @Autowired
    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @PostMapping("/login")
    public SaResult login(@RequestBody Operator operator) {
        Operator one = operatorService.getOne(new LambdaQueryWrapper<Operator>()
                .eq(Operator::getUsername, operator.getUsername())
        );
        if (one == null) {
            return SaResult.error("用户不存在，请检查用户名是否则正确");
        }
        if (!operator.getPassword().equals(one.getPassword())) {
            return SaResult.error("密码错误");
        }
        StpUtil.login(one.getOperatorid());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        // 设置用户信息到session中
        SaSession session = StpUtil.getSession();
        session.set(Constant.SESSION_USER_KEY, one);
        return SaResult.ok().setData(tokenInfo.getTokenValue());
    }

    @GetMapping("/getOperatorById/{id}")
    public ApiResponse<Operator> getOperatorById(@PathVariable("id") Integer id) {
        Operator operator = operatorService.getById(id);
        return ApiResponse.success(operator);
    }

    @PostMapping("/registry")
    @Transactional(rollbackFor = Exception.class)
    public ApiResponse registry(@RequestBody Operator operator) {
        Operator one = operatorService.getOne(new LambdaQueryWrapper<Operator>()
                .eq(Operator::getUsername, operator.getUsername()));
        if (one != null) {
            return ApiResponse.error("用户已存在");
        }
        boolean save = operatorService.save(operator);

        if (!save) {
            return ApiResponse.error("注册失败");
        }
        return ApiResponse.success("注册成功");
    }

    @GetMapping("/getOperatorInfo")
    public ApiResponse<Operator> getOperatorInfo() {
        Operator operator = (Operator) StpUtil.getSession().get(Constant.SESSION_USER_KEY);
        return ApiResponse.success(operator);
    }

    @GetMapping("/list")
    public ApiResponse<List<Operator>> list() {
        List<Operator> list = operatorService.list();
        return ApiResponse.success(list);
    }

    @PostMapping("/update")
    public ApiResponse update(@RequestBody Operator operator) {
        boolean update = operatorService.updateById(operator);
        if (update) {
            return ApiResponse.success("修改成功");
        }
        return ApiResponse.error("修改失败");
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable("id") Integer id) {
        boolean remove = operatorService.removeById(id);
        if (remove) {
            return ApiResponse.success("删除成功");
        }
        return ApiResponse.error("删除失败");
    }

    @GetMapping("/{id}")
    public ApiResponse<Operator> get(@PathVariable("id") Integer id) {
        Operator operator = operatorService.getById(id);
        if (operator == null) {
            return ApiResponse.error("没有该用户");
        }
        return ApiResponse.success(operator);
    }

}
