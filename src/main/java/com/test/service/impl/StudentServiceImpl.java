package com.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.bean.ChooseCourse;
import com.test.bean.Student;
import com.test.mapper.ChooseCourseMapper;
import com.test.mapper.StudentMapper;
import com.test.service.ChooseCourseService;
import com.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 18:45 2023/2/3
 * @Classname StudentServiceImpl
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    private ChooseCourseService chooseCourseService;

    @Override
    @Transactional//事务，要保持数据的一致性
    public boolean delete(Integer id) {
        //删除选课表中该学生的选课信息
        LambdaQueryWrapper<ChooseCourse> chooseCourseQueryWrapper = new LambdaQueryWrapper<>();
        chooseCourseQueryWrapper.eq(ChooseCourse::getStudentId, id);
        chooseCourseService.remove(chooseCourseQueryWrapper);
        //删除学生信息
        return this.removeById(id);
    }
}
