package com.zkt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkt.entity.Dept;
import com.zkt.service.DeptService;
import com.zkt.mapper.DeptMapper;
import org.springframework.stereotype.Service;

/**
* @author Leon
* @description 针对表【Dept】的数据库操作Service实现
* @createDate 2023-04-22 15:19:27
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{

}




