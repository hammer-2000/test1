package com.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.bean.Student;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 18:44 2023/2/3
 * @Classname StudentService
 */
public interface StudentService extends IService<Student> {
    boolean delete(Integer id);
}
