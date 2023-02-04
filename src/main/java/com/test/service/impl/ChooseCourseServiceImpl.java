package com.test.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.extra.cglib.CglibUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.DTO.ChooseCourseDTO;
import com.test.bean.ChooseCourse;
import com.test.bean.Course;
import com.test.bean.Student;
import com.test.mapper.ChooseCourseMapper;
import com.test.service.ChooseCourseService;
import com.test.service.CourseService;
import com.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 20:57 2023/2/3
 * @Classname ChooseCourseServiceImpl
 */
@Controller
public class ChooseCourseServiceImpl extends ServiceImpl<ChooseCourseMapper, ChooseCourse> implements ChooseCourseService {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    /**
     * 根据课程id获取学生已选课程
     * @param id
     * @return
     */
    @Override
    public List<ChooseCourse> getByCourseId(Integer id) {
        LambdaQueryWrapper<ChooseCourse> chooseCourseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        chooseCourseLambdaQueryWrapper.eq(ChooseCourse::getCourseId,id);//查询条件
        return this.list(chooseCourseLambdaQueryWrapper);
    }

    @Override
    public boolean save(ChooseCourse entity) {
        //判断学生和课程是否存在
        Integer courseId = entity.getCourseId();
        Integer studentId = entity.getStudentId();
        Student student = studentService.getById(studentId);
        Course course = courseService.getById(courseId);
        if (student!=null&&course!=null){//都存在，保存
            return super.save(entity);
        }else
            return false;
    }

    @Override
    public List<ChooseCourseDTO> getBYStudentId(Integer studentId) {
        LambdaQueryWrapper<ChooseCourse> chooseCourseQueryWrapper = new LambdaQueryWrapper<>();
        chooseCourseQueryWrapper.eq(ChooseCourse::getStudentId,studentId);
        List<ChooseCourse> list = super.list(chooseCourseQueryWrapper);
        List<ChooseCourseDTO> chooseCourseDTOS = new ArrayList<>();
        //集合拷贝并扩展值
        for (ChooseCourse chooseCourse : list) {
            ChooseCourseDTO chooseCourseDTO = new ChooseCourseDTO();
            BeanUtil.copyProperties(chooseCourse,chooseCourseDTO);
            Integer courseId = chooseCourse.getCourseId();
            Course course = courseService.getById(courseId);
            Student student = studentService.getById(studentId);
            chooseCourseDTO.setCourseName(course.getCourseName());
            chooseCourseDTO.setStudName(student.getStudName());
            chooseCourseDTOS.add(chooseCourseDTO);
        }
        return chooseCourseDTOS;
    }
}
