package com.zkt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkt.entity.VisitRecord;
import com.zkt.service.VisitRecordService;
import com.zkt.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitor_record")
@Slf4j
public class VisitRecordController {
    private VisitRecordService visitRecordService;

    @Autowired
    public VisitRecordController(VisitRecordService visitRecordService) {
        this.visitRecordService = visitRecordService;
    }

    @GetMapping("/list/{page}/{size}")
    public ApiResponse<List<VisitRecord>> list(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<VisitRecord> visitRecordPage = new Page<>(page, size);
        visitRecordPage = visitRecordService.page(visitRecordPage);
        return ApiResponse.success(visitRecordPage.getRecords());
    }

    @PostMapping("/add")
    public ApiResponse add(@RequestBody VisitRecord visitRecord) {
        boolean save = visitRecordService.save(visitRecord);
        if (save) {
            return ApiResponse.success("添加成功");
        }
        return ApiResponse.error("添加失败");
    }
}
