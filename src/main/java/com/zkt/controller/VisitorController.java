package com.zkt.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
         List<Visitor> visitors =  visitorService.listByCustom(visitor);
        if (visitors.size() == 0)
            return ApiResponse.error("没有该访客");
        else
            return ApiResponse.success(visitors, "查询成功");
    }

    @PostMapping("/add")
    public ApiResponse add(@RequestBody Visitor visitor) {
        visitor.setVisittime(new Date());
        boolean save = visitorService.save(visitor);
        if (save) {
            return ApiResponse.success("添加成功");
        }
        return ApiResponse.error("添加失败");
    }
}
