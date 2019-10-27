package com.heylhh.pmp.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.heylhh.pmp.model.entity.AttendRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author heylhh
 * @PackageName: PermissonManagementPlatform
 * @ClassName: AttendRecordDao
 * @Description:
 * @data：2019/10/26 17:40
 */
@Mapper
public interface AttendRecordDao extends BaseMapper<AttendRecordEntity> {

    List<AttendRecordEntity> queryPage(IPage<AttendRecordEntity> page, @Param("paramMap") Map<String, Object> paramMap);

    List<AttendRecordEntity> selectExportData(Map<String, Object> params);

    List<AttendRecordEntity> queryPageSqlServer(Map<String, Object> params);


    //List<AttendRecordEntity> selectAllMysql(Map<String,Object> params);
}

