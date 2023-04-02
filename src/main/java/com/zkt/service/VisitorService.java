package com.zkt.service;

import com.zkt.entity.Visitor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Leon
* @description 针对表【Visitor】的数据库操作Service
* @createDate 2023-04-02 09:43:25
*/
public interface VisitorService extends IService<Visitor> {


    List<Visitor> listByCustom(Visitor visitor);
}
