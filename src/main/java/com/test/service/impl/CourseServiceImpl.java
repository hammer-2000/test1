package com.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.bean.ChooseCourse;
import com.test.bean.Course;
import com.test.common.R;
import com.test.mapper.CourseMapper;
import com.test.service.ChooseCourseService;
import com.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 22:41 2023/2/3
 * @Classname CourseServiceImpl
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
   @Autowired
   private ChooseCourseService chooseCourseService;

    /**
     * 删除课程
     * @param id
     * @return
     */
    @Override
    public Boolean delete(Integer id) {
        //判断课程是否已经被选
        List<ChooseCourse> list = chooseCourseService.getByCourseId(id);
        if (list.size()>0){//课程已经有学生选了，不能删除
            return false;
        }
        //删除课程
        return this.removeById(id);

    }
}
