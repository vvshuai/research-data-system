
CREATE TABLE `research_data`.`student_info` (
  `student_id` int(15) NOT NULL COMMENT '学号作为主键',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  `password` varchar(100) NOT NULL COMMENT '密码,初始密码123456',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生数据表';

CREATE TABLE `research_data`.`teacher_info` (
  `teacher_id` int(15) NOT NULL COMMENT '教师号作为主键',
  `teacher_name` varchar(20) NOT NULL COMMENT '教师姓名',
  `password` varchar(100) NOT NULL COMMENT '密码,初始密码123456',
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师数据表';