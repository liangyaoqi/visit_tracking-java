package com.zkt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkt.entity.Announce;
import com.zkt.service.AnnounceService;
import com.zkt.mapper.AnnounceMapper;
import org.springframework.stereotype.Service;

/**
* @author Leon
* @description 针对表【announce】的数据库操作Service实现
* @createDate 2023-04-05 13:55:40
*/
@Service
public class AnnounceServiceImpl extends ServiceImpl<AnnounceMapper, Announce>
    implements AnnounceService{

}




