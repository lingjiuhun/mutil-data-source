package com.cz.mutildatasource.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.code.base.util.utils.RestResponse;
import com.github.pagehelper.PageInfo;


import com.cz.mutildatasource.entity.Alarm;
import com.cz.mutildatasource.service.impl.AlarmServiceImpl;

/**
* @Author:
* @Description: 管理
* @date: 2018-10-26 11:40:43
*/
@Log4j2
@RestController
@RequestMapping("/api/v1/alarms")
@Api(description = "Alarm-API", tags = "Alarm-API")
public class AlarmController{
@Autowired
private AlarmServiceImpl alarmServiceImpl;

    /**
    * 分页查询
    *
    * @param page
    * @param pageSize
    * @Author:
    * @return: com.code.base.util.utils.RestResponse<com.github.pagehelper.PageInfo>
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @ApiOperation(value = "获取..列表", notes = "获取..列表")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestResponse<PageInfo> getList(
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        PageInfo<Alarm> pageInfo = null;
        try {
            pageInfo = alarmServiceImpl.selectByPage(null, page == null ? 1 : page, pageSize == null ?
            Integer.MAX_VALUE : pageSize);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
        }

        return new RestResponse().setSuccess(true).setMessage("success").setData(pageInfo);
    }


    /**
    * 新增
    *
    * @param alarm
    * @Author:
    * @return: com.code.base.util.utils.RestResponse
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @ApiOperation(value = "新增..", notes = "新增..")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public RestResponse doAdd(@RequestBody Alarm alarm) {
        RestResponse result = new RestResponse();
        try {
            Integer r = alarmServiceImpl.insert(alarm);
            if (r > 0) {
                result.setSuccess(true).setMessage("success");
            } else {
                result.setSuccess(false).setMessage("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            result.setSuccess(false).setMessage("fail");
        }
        return result;
    }


    /**
    * 根据主键删除
    *
    * @param id
    * @Author:
    * @return: com.code.base.util.utils.RestResponse
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @ApiOperation(value = "根据主键删除", notes = "根据主键删除")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RestResponse doDelete(@PathVariable Long id) {
        RestResponse result = new RestResponse();
        try {
            Integer r = alarmServiceImpl.deleteById(id);
            if (r > 0) {
                result.setSuccess(true).setMessage("success");
            } else {
                result.setSuccess(false).setMessage("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            result.setSuccess(false).setMessage("fail");
        }

        return result;
    }


    /**
    * 根据主键获取详情
    *
    * @param id
    * @Author:
    * @return: com.code.base.util.utils.RestResponse<com.cz.mutildatasource.entity.Alarm>
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @ApiOperation(value = "根据id获取权限信息", notes = "根据id获取权限信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RestResponse<Alarm> doGetDetail(@PathVariable Long id) {
        RestResponse result = new RestResponse();
        try {
            Alarm alarm = alarmServiceImpl.selectById(id);
            result.setSuccess(true).setMessage("success").setData(alarm);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            result.setSuccess(false).setMessage("fail");
        }

        return result;
    }


    /**
    * 根据主键更新
    *
    * @param id
    * @param alarm
    * @Author:
    * @return: com.hollysys.haier.robot.bean.RestResponse
    * @exception:
    * @date: 2018-10-26 11:40:43
    */
    @ApiOperation(value = "根据主键更新", notes = "根据主键更新")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RestResponse doUpdate(@PathVariable Long id,
    @RequestBody Alarm alarm) {
        RestResponse result = new RestResponse();
        try {
            Integer r = alarmServiceImpl.updateById(alarm);
            if (r > 0) {
                result.setSuccess(true).setMessage("success");
            } else {
                result.setSuccess(false).setMessage("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            result.setSuccess(false).setMessage("fail");
        }

        return result;
    }


}