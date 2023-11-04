CREATE TABLE `t_user` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
    `job` varchar(50) DEFAULT NULL COMMENT '工作',
    `company` varchar(255) DEFAULT NULL,
    `create_time` datetime DEFAULT NULL COMMENT '新建时间',
    `create_by` varchar(100) DEFAULT NULL COMMENT '新建人',
    `modify_time` datetime DEFAULT NULL COMMENT '更新时间',
    `modify_by` varchar(100) DEFAULT NULL COMMENT '更新人',
    `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除字段 1：删除，0：未删除',
    PRIMARY KEY (`id`)
) ;