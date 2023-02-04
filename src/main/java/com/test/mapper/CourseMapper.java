package com.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.bean.Course;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 22:40 2023/2/3
 * @Classname CourseMapper
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
