package com.zkt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkt.entity.Vehicle;
import com.zkt.service.VehicleService;
import com.zkt.mapper.VehicleMapper;
import org.springframework.stereotype.Service;

/**
* @author 梁耀其
* @description 针对表【Vehicle】的数据库操作Service实现
* @createDate 2023-03-29 13:38:12
*/
@Service
public class VehicleServiceImpl extends ServiceImpl<VehicleMapper, Vehicle>
    implements VehicleService{

}




