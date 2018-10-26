CREATE TABLE `device` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '设备Id',
   `sn` varchar(100) DEFAULT NULL COMMENT '设备序列号',
   `device_no` varchar(32) DEFAULT NULL COMMENT '设备编号',
   `tid` varchar(36) DEFAULT NULL COMMENT '设备型号id',
   `device_name` varchar(100) DEFAULT NULL COMMENT '设备名称',
   `enable_time` bigint(20) NOT NULL COMMENT '验收启动时间',
   `main_period` int(11) DEFAULT NULL COMMENT '保修期 单位（月）',
   `pl_id` varchar(100) DEFAULT NULL COMMENT '所属产线id',
   `position_num` int(11) DEFAULT NULL COMMENT '位置序号',
   `gateway_sn` varchar(32) DEFAULT NULL COMMENT '网关序列号',
   `device_num` varchar(50) DEFAULT NULL COMMENT '设备在网关上的序号',
   `photo` varchar(100) DEFAULT NULL COMMENT '图片 url',
   `deleted` int(1) DEFAULT NULL COMMENT '是否删除',
   `manufacture` varchar(50) DEFAULT NULL COMMENT '生产厂商',
   PRIMARY KEY (`id`) USING BTREE
 ) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='设备表';