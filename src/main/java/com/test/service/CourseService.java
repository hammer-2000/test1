package com.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.bean.Course;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 22:41 2023/2/3
 * @Classname CourseService
 */
public interface CourseService extends IService<Course> {
    Boolean delete(Integer id);
}
