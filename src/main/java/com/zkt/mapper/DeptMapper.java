package com.zkt.mapper;

import com.zkt.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Leon
* @description 针对表【Dept】的数据库操作Mapper
* @createDate 2023-04-22 15:19:27
* @Entity com.zkt.entity.Dept
*/
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

}




