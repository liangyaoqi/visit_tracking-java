package com.zkt.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.protobuf.Api;
import com.zkt.entity.Visitor;
import com.zkt.service.VisitorService;
import com.zkt.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/visitor")
@Slf4j
public class VisitorController {

    private VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping
    public ApiResponse<List<Visitor>> getVisitorByName(@RequestBody Visitor visitor) {
        List<Visitor> visitors = visitorService.listByCustom(visitor);
        if (visitors.size() == 0)
            return ApiResponse.error("没有该访客");
        else
            return ApiResponse.success(visitors, "查询成功");
    }

    @PostMapping("/add")
    public ApiResponse add(@RequestBody Visitor visitor) {
        visitor.setVisittime(DateUtil.now());
        boolean save = visitorService.save(visitor);
        if (save) {
            return ApiResponse.success("添加成功");
        }
        return ApiResponse.error("添加失败");
    }

    @PostMapping("/visitors")
    public ApiResponse<List<Visitor>> getVisitors(@RequestBody Visitor visitor) {
        List<Visitor> visitors = visitorService.listByCustom(visitor);
        if (visitors.size() == 0)
            return ApiResponse.error("没有该访客");
        else
            return ApiResponse.success(visitors, "查询成功");
    }

    @GetMapping("/total")
    public ApiResponse total() {
        int total = (int) visitorService.count(new LambdaQueryWrapper<Visitor>().likeRight(Visitor::getVisittime, DateUtil.today()));
        return ApiResponse.success(total, "查询成功");
    }

    @GetMapping("/echars")
    public int[] echars() {
        int[] echars = new int[24];
        for (int i = 0; i < 24; i++) {
            int count = (int) visitorService.count(new LambdaQueryWrapper<Visitor>().likeRight(Visitor::getVisittime, DateUtil.today()).between(Visitor::getVisittime, DateUtil.offsetHour(DateUtil.beginOfDay(DateUtil.date()), i).toString(), DateUtil.offsetHour(DateUtil.beginOfDay(DateUtil.date()), i + 1).toString()));
            echars[i] = count;
        }
        return echars;
    }
}
