package com.cz.mutildatasource.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Objects;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cz.mutildatasource.entity.Alarm;
import com.cz.mutildatasource.entity.AlarmQuery;
import com.cz.mutildatasource.dao.mapper.db2.AlarmMapper;
import com.cz.mutildatasource.service.IAlarmService;

/**
* @Author:
* @Description: 服务实现
* @date:
*/
@Log4j2
@Service
public class AlarmServiceImpl implements IAlarmService {
@Autowired
private AlarmMapper alarmMapper;


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
    @Override
    public PageInfo<Alarm> selectByPage(AlarmQuery param, Integer page, Integer pageSize) throws Exception {
        int limit = pageSize != null ? pageSize : 10;
        int offset = (page != null ? page : 1);
        PageHelper.startPage(offset, limit);

        List<Alarm> datas = alarmMapper.selectByPropertyByPage(param);

        PageInfo<Alarm> pageInfo = new PageInfo<>(datas);
        return pageInfo;
    }


    /**
    * 新增
    *
    * @param alarm
    * @Author:
    * @return: java.lang.Integer
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @Override
    public Integer insert(Alarm alarm) throws Exception {
        Integer r = 0;
        //数据非空判断
        if (Objects.isNull(alarm)) {
            return r = -1;
        }

        //默认数据处理

        //数据入库
        r = alarmMapper.insertSelective(alarm);

        return r;
    }


    /**
    * 根据主键更新
    *
    * @param alarm
    * @Author:
    * @return: java.lang.Integer
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @Override
    public Integer updateById(Alarm alarm) throws Exception {
        Integer r = 0;
        //主键存在判断
        if (alarm == null || alarm.getId() == null) {
            return r = -1;
        }
        //唯一性判断

        //数据更新
        r = alarmMapper.updateByPrimaryKeySelective(alarm);

        return r;
    }


    /**
    * 根据主键删除
    *
    * @param id
    * @Author:
    * @return: int
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @Override
    public int deleteById(Long id) throws Exception {
        int r = 0;
        //id非空判断
        if (id == null  || id == 0 ) {
            return -1;
        }
        //数据删除
        r = alarmMapper.deleteByPrimaryKey(id);

        return r;
    }


    /**
    * 根据主键批量删除
    *
    * @param ids
    * @Author:
    * @return: int
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @Override
    public Integer deleteBatchByIds(List ids) throws Exception{
        int result = -1;

        //ids非空判断
        if (ids == null || ids.size() <= 0) {
            return -1;
        }
        result = alarmMapper.deleteBatchByPrimaryKey(ids);

        return result;
    }


    /**
    * 根据主键查询
    *
    * @param id
    * @Author:
    * @return: com.cz.mutildatasource.entity.Alarm
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @Override
    public Alarm selectById(Long id) throws Exception {
        Alarm alarm = null;
        //id非空判断
        if (id != null  || id > 0 ) {
            alarm = alarmMapper.selectByPrimaryKey(id);
        }
        return alarm;
    }


}