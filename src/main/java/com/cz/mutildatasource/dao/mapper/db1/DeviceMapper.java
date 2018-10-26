package com.cz.mutildatasource.dao.mapper.db1;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

import com.cz.mutildatasource.entity.Device;
import com.cz.mutildatasource.entity.DeviceQuery;

/**
* @Author:
* @Description: mapper接口
* @date: 2018-10-26 11:40:43
*/
@Component
@Mapper
public interface DeviceMapper {


    /**
    * 根据主键查询
    *
    * @param id
    * @Author:
    * @return: com.cz.mutildatasource.entity.Device
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    Device selectByPrimaryKey(Long id);

    /**
    * 根据主键删除
    *
    * @param id
    * @Author:
    * @return: int
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    int deleteByPrimaryKey(Long id);

    /**
    * 根据主键批量删除
    *
    * @param list
    * @Author:
    * @return: int
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    int deleteBatchByPrimaryKey(List<String> list);


    /**
    * 新增
    *
    * @param record
    * @Author:
    * @return: int
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    int insertSelective(Device record);

    /**
    * 根据属性分页查询
    *
    * @param map
    * @Author:
    * @return: java.util.List<com.cz.mutildatasource.entity.Device>
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    List<Device> selectByPropertyByPage(DeviceQuery query);

    /**
    * 根据属性查询记录数
    *
    * @param map
    * @Author:
    * @return: int
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    int selectCountByProperty(Map map);

    /**
    * 根据主键更新记录
    *
    * @param record
    * @Author:
    * @return: int
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    int updateByPrimaryKeySelective(Device record);

    }