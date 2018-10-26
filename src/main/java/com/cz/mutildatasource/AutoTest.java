package com.cz.mutildatasource;

import com.code.base.util.model.MybatisUtil;
import com.code.base.util.server.ServerCode;

public class AutoTest {
    public static void main(String[] args){
        String urlDbName1 = "172.21.46.11:3306/hiaerrobot_device";
        String dbUser ="root";
        String dbPassWord = "Www#1234";
        String beanPackage = "main.java.com.cz.mutildatasource.entity";


        String urlDbName2 = "172.21.46.11:3306/haierrobot_alarm";

        //生成bean对象
//        MybatisUtil.autoMakeBean(urlDbName1, dbUser, dbPassWord,beanPackage, "Device", "device");
//
//        MybatisUtil.autoMakeBean(urlDbName2, dbUser, dbPassWord,beanPackage, "Alarm", "t_alarm");

        //第二部，执行以下方法
        ServerCode.generalAll(new com.cz.mutildatasource.entity.Device(), "id", "id", 1, "device");
        ServerCode.generalAll(new com.cz.mutildatasource.entity.Alarm(), "id", "id", 1, "t_alarm");


    }
}
