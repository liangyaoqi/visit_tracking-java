package com.zkt.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zkt.entity.Announce;
import com.zkt.service.AnnounceService;
import com.zkt.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/announce")
public class AnnounceController {
    private AnnounceService announceService;

    @Autowired
    public AnnounceController(AnnounceService announceService) {
        this.announceService = announceService;
    }

    @PostMapping("/add")
    public ApiResponse addAnnounce(@RequestBody Announce announce) {
        boolean b = announceService.saveOrUpdate(announce, new LambdaQueryWrapper<Announce>().eq(Announce::getOpratorid, announce.getOpratorid()));
        if (b)
            return ApiResponse.success("添加成功");
        else
            return ApiResponse.error("添加失败");
    }

    @GetMapping
    public ApiResponse<Announce> announce(){
        return ApiResponse.success(announceService.getOne(new LambdaQueryWrapper<Announce>()),"查询成功");
    }
}
