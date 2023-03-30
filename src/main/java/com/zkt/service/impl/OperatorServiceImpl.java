package com.zkt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkt.entity.Operator;
import com.zkt.service.OperatorService;
import com.zkt.mapper.OperatorMapper;
import org.springframework.stereotype.Service;

/**
* @author Leon
* @description 针对表【Operator】的数据库操作Service实现
* @createDate 2023-03-25 23:06:41
*/
@Service
public class OperatorServiceImpl extends ServiceImpl<OperatorMapper, Operator>
    implements OperatorService{

}




