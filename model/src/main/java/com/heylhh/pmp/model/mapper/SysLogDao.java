package com.heylhh.pmp.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heylhh.pmp.model.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

//系统日志
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {

    void truncate();

}