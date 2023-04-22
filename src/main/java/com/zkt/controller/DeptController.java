package com.zkt.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zkt.entity.Dept;
import com.zkt.service.DeptService;
import com.zkt.util.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @PostMapping("/add")
    public ApiResponse addDept(@RequestBody Dept dept) {
        boolean b = deptService.saveOrUpdate(dept, new LambdaQueryWrapper<Dept>().eq(Dept::getDeptId, dept.getDeptId()));
        if (b)
            return ApiResponse.success("添加成功");
        else
            return ApiResponse.error("添加失败");
    }

    @GetMapping("/list")
    public ApiResponse<List<Dept>> deptList() {
        return ApiResponse.success(deptService.list(), "查询成功");
    }

    @DeleteMapping("/delete/{deptid}")
    public ApiResponse deleteDept(@PathVariable("deptid") String deptid) {
        boolean b = deptService.remove(new LambdaQueryWrapper<Dept>().eq(Dept::getDeptId, deptid));
        if (b)
            return ApiResponse.success("删除成功");
        else
            return ApiResponse.error("删除失败");
    }
}
