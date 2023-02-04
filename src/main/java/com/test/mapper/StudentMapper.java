package com.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.bean.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 18:43 2023/2/3
 * @Classname StudentMapper
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
