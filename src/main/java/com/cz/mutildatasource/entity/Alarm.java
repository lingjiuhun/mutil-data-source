package com.cz.mutildatasource.entity;

public class Alarm {
    /**
     * 记录id
     */
    private Long id;

    /**
     * 报警编号
     */
    private String warnNum;

    /**
     * 设备编号
     */
    private String deviceNum;

    /**
     * 故障代码
     */
    private String faultCode;

    /**
     * 报警详情
     */
    private String warnDetail;

    /**
     * 发生时间(s)
     */
    private Long warnTime;

    /**
     * 报警类型
     */
    private Integer warnType;

    /**
     * 备注
     */
    private String warnComment;

    /**
     * 处理类型(1确认，2保修)
     */
    private Integer solveType;

    /**
     * 处理人
     */
    private String solvePerson;

    /**
     * 处理时间(s)
     */
    private Long solveTime;

    /**
     * 处理状态(0未处理，1处理中，2处理完成)
     */
    private Integer solveStatus;

    /**
     * 处理人id
     */
    private String solvePersonId;

    /**
     * 记录id
     *
     * @return id 记录id
     */
    public Long getId() {
        return id;
    }

    /**
     * 记录id
     *
     * @param id 记录id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 报警编号
     *
     * @return warn_num 报警编号
     */
    public String getWarnNum() {
        return warnNum;
    }

    /**
     * 报警编号
     *
     * @param warnNum 报警编号
     */
    public void setWarnNum(String warnNum) {
        this.warnNum = warnNum == null ? null : warnNum.trim();
    }

    /**
     * 设备编号
     *
     * @return device_num 设备编号
     */
    public String getDeviceNum() {
        return deviceNum;
    }

    /**
     * 设备编号
     *
     * @param deviceNum 设备编号
     */
    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum == null ? null : deviceNum.trim();
    }

    /**
     * 故障代码
     *
     * @return fault_code 故障代码
     */
    public String getFaultCode() {
        return faultCode;
    }

    /**
     * 故障代码
     *
     * @param faultCode 故障代码
     */
    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode == null ? null : faultCode.trim();
    }

    /**
     * 报警详情
     *
     * @return warn_detail 报警详情
     */
    public String getWarnDetail() {
        return warnDetail;
    }

    /**
     * 报警详情
     *
     * @param warnDetail 报警详情
     */
    public void setWarnDetail(String warnDetail) {
        this.warnDetail = warnDetail == null ? null : warnDetail.trim();
    }

    /**
     * 发生时间(s)
     *
     * @return warn_time 发生时间(s)
     */
    public Long getWarnTime() {
        return warnTime;
    }

    /**
     * 发生时间(s)
     *
     * @param warnTime 发生时间(s)
     */
    public void setWarnTime(Long warnTime) {
        this.warnTime = warnTime;
    }

    /**
     * 报警类型
     *
     * @return warn_type 报警类型
     */
    public Integer getWarnType() {
        return warnType;
    }

    /**
     * 报警类型
     *
     * @param warnType 报警类型
     */
    public void setWarnType(Integer warnType) {
        this.warnType = warnType;
    }

    /**
     * 备注
     *
     * @return warn_comment 备注
     */
    public String getWarnComment() {
        return warnComment;
    }

    /**
     * 备注
     *
     * @param warnComment 备注
     */
    public void setWarnComment(String warnComment) {
        this.warnComment = warnComment == null ? null : warnComment.trim();
    }

    /**
     * 处理类型(1确认，2保修)
     *
     * @return solve_type 处理类型(1确认，2保修)
     */
    public Integer getSolveType() {
        return solveType;
    }

    /**
     * 处理类型(1确认，2保修)
     *
     * @param solveType 处理类型(1确认，2保修)
     */
    public void setSolveType(Integer solveType) {
        this.solveType = solveType;
    }

    /**
     * 处理人
     *
     * @return solve_person 处理人
     */
    public String getSolvePerson() {
        return solvePerson;
    }

    /**
     * 处理人
     *
     * @param solvePerson 处理人
     */
    public void setSolvePerson(String solvePerson) {
        this.solvePerson = solvePerson == null ? null : solvePerson.trim();
    }

    /**
     * 处理时间(s)
     *
     * @return solve_time 处理时间(s)
     */
    public Long getSolveTime() {
        return solveTime;
    }

    /**
     * 处理时间(s)
     *
     * @param solveTime 处理时间(s)
     */
    public void setSolveTime(Long solveTime) {
        this.solveTime = solveTime;
    }

    /**
     * 处理状态(0未处理，1处理中，2处理完成)
     *
     * @return solve_status 处理状态(0未处理，1处理中，2处理完成)
     */
    public Integer getSolveStatus() {
        return solveStatus;
    }

    /**
     * 处理状态(0未处理，1处理中，2处理完成)
     *
     * @param solveStatus 处理状态(0未处理，1处理中，2处理完成)
     */
    public void setSolveStatus(Integer solveStatus) {
        this.solveStatus = solveStatus;
    }

    /**
     * 处理人id
     *
     * @return solve_person_id 处理人id
     */
    public String getSolvePersonId() {
        return solvePersonId;
    }

    /**
     * 处理人id
     *
     * @param solvePersonId 处理人id
     */
    public void setSolvePersonId(String solvePersonId) {
        this.solvePersonId = solvePersonId == null ? null : solvePersonId.trim();
    }
}
