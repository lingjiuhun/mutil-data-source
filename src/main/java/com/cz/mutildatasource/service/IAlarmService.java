package com.cz.mutildatasource.service;

import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;

import com.cz.mutildatasource.entity.Alarm;
import com.cz.mutildatasource.entity.AlarmQuery;

/**
* @Author:
* @Description: 服务接口
* @date: 2018-10-26 11:40:43
*/
public interface IAlarmService {

    /**
    * 根据参数分页查询
    *
    * @param param
    * @param page
    * @param pageSize
    * @Author:
    * @return: com.github.pagehelper.PageInfo<com.cz.mutildatasource.entity.Alarm>
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    PageInfo<Alarm> selectByPage(AlarmQuery param, Integer page, Integer pageSize) throws Exception;


    /**
    * 新增
    *
    * @param alarm
    * @Author:
    * @return: java.lang.Integer
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    Integer insert(Alarm alarm) throws Exception;


    /**
    * 根据主键更新
    *
    * @param alarm
    * @Author:
    * @return: java.lang.Integer
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    Integer updateById(Alarm alarm) throws Exception;

    /**
    * 根据主键删除
    *
    * @param id
    * @Author:
    * @return: int
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    int deleteById(Long id) throws Exception;

    /**
    * 根据主键批量删除
    *
    * @param ids
    * @Author:
    * @return: int
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    Integer deleteBatchByIds(List ids) throws Exception;


    /**
    * 根据主键查询
    *
    * @param id
    * @Author:
    * @return: com.cz.mutildatasource.entity.Alarm
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    Alarm selectById(Long id) throws Exception;


}