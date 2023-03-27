package com.zkt.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zkt.entity.Operator;
import com.zkt.service.OperatorService;
import com.zkt.util.ApiResponse;
import com.zkt.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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


}
