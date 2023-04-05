package com.zkt.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.protobuf.Api;
import com.zkt.entity.Blacklist;
import com.zkt.entity.Visitor;
import com.zkt.service.BlacklistService;
import com.zkt.service.VisitorService;
import com.zkt.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blacklist")
@Slf4j
public class BlacklistController {

    private BlacklistService blacklistService;

    private VisitorService visitorService;


    @GetMapping
    public ApiResponse<List<Blacklist>> list() {
        return ApiResponse.success(blacklistService.list());
    }

    @Autowired
    public BlacklistController(BlacklistService blacklistService, VisitorService visitorService) {
        this.blacklistService = blacklistService;
        this.visitorService = visitorService;
    }

    @PostMapping("/add")
    public ApiResponse add(@RequestBody Blacklist blacklist) {
        boolean save = blacklistService.save(blacklist);
        if (save) {
            return ApiResponse.success("添加成功");
        }
        return ApiResponse.error("添加失败");
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable("id") String id) {
        boolean remove = blacklistService.removeById(id);
        if (remove) {
            return ApiResponse.success("删除成功");
        }
        return ApiResponse.error("删除失败");
    }

    @GetMapping("/findByName")
    public ApiResponse<Blacklist> findByName(@RequestParam("idcar") String idcar) {
        Blacklist blacklist = blacklistService.getOne(new LambdaQueryWrapper<Blacklist>().eq(Blacklist::getIdcar, idcar));
        if (blacklist == null) {
            return ApiResponse.error("没有该黑名单");
        }
        return ApiResponse.success(blacklist);
    }

    @GetMapping("/search")
    public ApiResponse<Blacklist> search(@RequestParam("idCar") String idCar) {
        Blacklist blacklist = blacklistService.getOne(new LambdaQueryWrapper<Blacklist>().eq(Blacklist::getIdcar, idCar));
        if (blacklist == null) {
            return ApiResponse.error("没有该黑名单");
        }
        return ApiResponse.success(blacklist);
    }
}
