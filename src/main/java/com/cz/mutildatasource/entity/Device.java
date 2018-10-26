package com.cz.mutildatasource.entity;

public class Device {
    /**
     * 设备Id
     */
    private Long id;

    /**
     * 设备序列号
     */
    private String sn;

    /**
     * 设备编号
     */
    private String deviceNo;

    /**
     * 设备型号id
     */
    private String tid;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 验收启动时间
     */
    private Long enableTime;

    /**
     * 保修期 单位（月）
     */
    private Integer mainPeriod;

    /**
     * 所属产线id
     */
    private String plId;

    /**
     * 位置序号
     */
    private Integer positionNum;

    /**
     * 网关序列号
     */
    private String gatewaySn;

    /**
     * 设备在网关上的序号
     */
    private String deviceNum;

    /**
     * 图片 url
     */
    private String photo;

    /**
     * 是否删除
     */
    private Integer deleted;

    /**
     * 生产厂商
     */
    private String manufacture;

    /**
     * 设备Id
     *
     * @return id 设备Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设备Id
     *
     * @param id 设备Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设备序列号
     *
     * @return sn 设备序列号
     */
    public String getSn() {
        return sn;
    }

    /**
     * 设备序列号
     *
     * @param sn 设备序列号
     */
    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    /**
     * 设备编号
     *
     * @return device_no 设备编号
     */
    public String getDeviceNo() {
        return deviceNo;
    }

    /**
     * 设备编号
     *
     * @param deviceNo 设备编号
     */
    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo == null ? null : deviceNo.trim();
    }

    /**
     * 设备型号id
     *
     * @return tid 设备型号id
     */
    public String getTid() {
        return tid;
    }

    /**
     * 设备型号id
     *
     * @param tid 设备型号id
     */
    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    /**
     * 设备名称
     *
     * @return device_name 设备名称
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * 设备名称
     *
     * @param deviceName 设备名称
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    /**
     * 验收启动时间
     *
     * @return enable_time 验收启动时间
     */
    public Long getEnableTime() {
        return enableTime;
    }

    /**
     * 验收启动时间
     *
     * @param enableTime 验收启动时间
     */
    public void setEnableTime(Long enableTime) {
        this.enableTime = enableTime;
    }

    /**
     * 保修期 单位（月）
     *
     * @return main_period 保修期 单位（月）
     */
    public Integer getMainPeriod() {
        return mainPeriod;
    }

    /**
     * 保修期 单位（月）
     *
     * @param mainPeriod 保修期 单位（月）
     */
    public void setMainPeriod(Integer mainPeriod) {
        this.mainPeriod = mainPeriod;
    }

    /**
     * 所属产线id
     *
     * @return pl_id 所属产线id
     */
    public String getPlId() {
        return plId;
    }

    /**
     * 所属产线id
     *
     * @param plId 所属产线id
     */
    public void setPlId(String plId) {
        this.plId = plId == null ? null : plId.trim();
    }

    /**
     * 位置序号
     *
     * @return position_num 位置序号
     */
    public Integer getPositionNum() {
        return positionNum;
    }

    /**
     * 位置序号
     *
     * @param positionNum 位置序号
     */
    public void setPositionNum(Integer positionNum) {
        this.positionNum = positionNum;
    }

    /**
     * 网关序列号
     *
     * @return gateway_sn 网关序列号
     */
    public String getGatewaySn() {
        return gatewaySn;
    }

    /**
     * 网关序列号
     *
     * @param gatewaySn 网关序列号
     */
    public void setGatewaySn(String gatewaySn) {
        this.gatewaySn = gatewaySn == null ? null : gatewaySn.trim();
    }

    /**
     * 设备在网关上的序号
     *
     * @return device_num 设备在网关上的序号
     */
    public String getDeviceNum() {
        return deviceNum;
    }

    /**
     * 设备在网关上的序号
     *
     * @param deviceNum 设备在网关上的序号
     */
    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum == null ? null : deviceNum.trim();
    }

    /**
     * 图片 url
     *
     * @return photo 图片 url
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 图片 url
     *
     * @param photo 图片 url
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 是否删除
     *
     * @return deleted 是否删除
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 是否删除
     *
     * @param deleted 是否删除
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 生产厂商
     *
     * @return manufacture 生产厂商
     */
    public String getManufacture() {
        return manufacture;
    }

    /**
     * 生产厂商
     *
     * @param manufacture 生产厂商
     */
    public void setManufacture(String manufacture) {
        this.manufacture = manufacture == null ? null : manufacture.trim();
    }
}
