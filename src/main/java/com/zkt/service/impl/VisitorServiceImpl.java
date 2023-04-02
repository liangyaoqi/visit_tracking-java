package com.zkt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkt.entity.Visitor;
import com.zkt.service.VisitorService;
import com.zkt.mapper.VisitorMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Leon
* @description 针对表【Visitor】的数据库操作Service实现
* @createDate 2023-04-02 09:43:25
*/
@Service
public class VisitorServiceImpl extends ServiceImpl<VisitorMapper, Visitor>
    implements VisitorService{


    @Resource
    private VisitorMapper visitorMapper;

    @Override
    public List<Visitor> listByCustom(Visitor visitor) {
//        visitorMapper.selectMaps()
        return null;
    }
}




