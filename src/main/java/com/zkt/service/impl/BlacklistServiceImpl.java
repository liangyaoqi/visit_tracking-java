package com.zkt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkt.entity.Blacklist;
import com.zkt.service.BlacklistService;
import com.zkt.mapper.BlacklistMapper;
import org.springframework.stereotype.Service;

/**
* @author Leon
* @description 针对表【BlackList】的数据库操作Service实现
* @createDate 2023-04-22 16:03:52
*/
@Service
public class BlacklistServiceImpl extends ServiceImpl<BlacklistMapper, Blacklist>
    implements BlacklistService{

}




