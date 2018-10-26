CREATE TABLE `t_alarm` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录id',
   `warn_num` varchar(20) DEFAULT NULL COMMENT '报警编号',
   `device_num` varchar(50) DEFAULT NULL COMMENT '设备编号',
   `fault_code` varchar(50) DEFAULT NULL COMMENT '故障代码',
   `warn_detail` varchar(100) DEFAULT NULL COMMENT '报警详情',
   `warn_time` bigint(20) DEFAULT NULL COMMENT '发生时间(s)',
   `warn_type` int(11) DEFAULT NULL COMMENT '报警类型',
   `warn_comment` varchar(200) DEFAULT NULL COMMENT '备注',
   `solve_type` int(11) DEFAULT NULL COMMENT '处理类型(1确认，2保修)',
   `solve_person` varchar(100) DEFAULT NULL COMMENT '处理人',
   `solve_time` bigint(20) DEFAULT NULL COMMENT '处理时间(s)',
   `solve_status` int(11) DEFAULT '0' COMMENT '处理状态(0未处理，1处理中，2处理完成)',
   `solve_person_id` varchar(50) DEFAULT NULL COMMENT '处理人id',
   PRIMARY KEY (`id`) USING BTREE
 ) ENGINE=InnoDB AUTO_INCREMENT=384 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='报警表';