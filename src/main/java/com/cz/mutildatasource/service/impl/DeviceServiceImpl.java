package com.cz.mutildatasource.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Objects;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cz.mutildatasource.entity.Device;
import com.cz.mutildatasource.entity.DeviceQuery;
import com.cz.mutildatasource.dao.mapper.db1.DeviceMapper;
import com.cz.mutildatasource.service.IDeviceService;

/**
* @Author:
* @Description: 服务实现
* @date:
*/
@Log4j2
@Service
public class DeviceServiceImpl implements IDeviceService {
@Autowired
private DeviceMapper deviceMapper;


    /**
    * 根据参数分页查询
    *
    * @param param
    * @param page
    * @param pageSize
    * @Author:
    * @return: com.github.pagehelper.PageInfo<com.cz.mutildatasource.entity.Device>
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @Override
    public PageInfo<Device> selectByPage(DeviceQuery param, Integer page, Integer pageSize) throws Exception {
        int limit = pageSize != null ? pageSize : 10;
        int offset = (page != null ? page : 1);
        PageHelper.startPage(offset, limit);

        List<Device> datas = deviceMapper.selectByPropertyByPage(param);

        PageInfo<Device> pageInfo = new PageInfo<>(datas);
        return pageInfo;
    }


    /**
    * 新增
    *
    * @param device
    * @Author:
    * @return: java.lang.Integer
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @Override
    public Integer insert(Device device) throws Exception {
        Integer r = 0;
        //数据非空判断
        if (Objects.isNull(device)) {
            return r = -1;
        }

        //默认数据处理

        //数据入库
        r = deviceMapper.insertSelective(device);

        return r;
    }


    /**
    * 根据主键更新
    *
    * @param device
    * @Author:
    * @return: java.lang.Integer
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @Override
    public Integer updateById(Device device) throws Exception {
        Integer r = 0;
        //主键存在判断
        if (device == null || device.getId() == null) {
            return r = -1;
        }
        //唯一性判断

        //数据更新
        r = deviceMapper.updateByPrimaryKeySelective(device);

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
        r = deviceMapper.deleteByPrimaryKey(id);

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
        result = deviceMapper.deleteBatchByPrimaryKey(ids);

        return result;
    }


    /**
    * 根据主键查询
    *
    * @param id
    * @Author:
    * @return: com.cz.mutildatasource.entity.Device
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @Override
    public Device selectById(Long id) throws Exception {
        Device device = null;
        //id非空判断
        if (id != null  || id > 0 ) {
            device = deviceMapper.selectByPrimaryKey(id);
        }
        return device;
    }


}