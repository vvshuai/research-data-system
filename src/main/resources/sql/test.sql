CREATE TABLE IF NOT EXISTS `research_data`.`user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) NOT NULL COMMENT '用户号作为主键',
  `user_name` varchar(20) NOT NULL COMMENT '用户姓名',
  `password` varchar(100) NOT NULL COMMENT '密码,初始密码123456',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户数据表';

CREATE TABLE IF NOT EXISTS `research_data`.`code` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `code_name` varchar(100) NOT NULL COMMENT '代码名称',
    `code_description` varchar(500) NOT NULL COMMENT '代码简介',
    `code_label` varchar(300) NOT NULL COMMENT '代码标签，以逗号分隔，形如1,2,3',
    `code_file` varchar(200) NOT NULL COMMENT '代码地址',
    `code_readme` varchar(200) NOT NULL COMMENT 'readme文件地址',
    `create_time` timestamp NOT NULL COMMENT '上传时间',
    primary key(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代码数据表';

CREATE TABLE IF NOT EXISTS `research_data`.`other_file` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `file_name` varchar(100) NOT NULL COMMENT '文件名',
    `file_description` varchar(500) NOT NULL COMMENT '文件描述',
    `file_address` varchar(200) NOT NULL COMMENT '文件地址',
    `user_name` varchar(20) NOT NULL COMMENT '用户姓名',
    `create_time` timestamp NOT NULL COMMENT '创建时间',
    primary KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='其他文档表';

CREATE TABLE IF NOT EXISTS `research_data`.`study_file` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `file_name` varchar(100) NOT NULL COMMENT '文件名',
    `file_type` varchar(100) NOT NULL COMMENT '文件类型',
    `file_address` varchar(200) NOT NULL COMMENT '文件地址',
    `user_name` varchar(20) NOT NULL COMMENT '用户姓名',
    `create_time` timestamp NOT NULL COMMENT '上传时间',
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学习数据数表';

CREATE TABLE IF NOT EXISTS `research_data`.`paper_info` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `paper_name` varchar(100) NOT NULL COMMENT '论文题目',
    `paper_year` varchar(20) NOT NULL COMMENT '论文年份',
    `paper_meeting` varchar(100) NOT NULL COMMENT '会议名',
    `paper_writer` varchar(100) NOT NULL COMMENT '作者或讲述者',
    `create_time` timestamp NOT NULL COMMENT '上传时间',
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='论文信息表';