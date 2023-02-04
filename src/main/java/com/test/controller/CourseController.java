package com.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.bean.Course;
import com.test.common.R;
import com.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 22:42 2023/2/3
 * @Classname CourseController
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    //得到所有的课程信息
    @GetMapping()
    public R getAllCourse(){
        List<Course> list = courseService.list();
        return R.success(list);
    }
    @PostMapping("/insert")
    public R insertCourse(@RequestBody Course course){
        boolean save = courseService.save(course);
        if (save)
            return R.success("添加成功");
        else
            return R.error("添加失败");
    }

    /**
     * 按照id删除课程
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public R deleteCourse(@PathVariable Integer id){
        //判断id是否存在
        Course course = courseService.getById(id);
        if (course==null){
            return R.error("课程不存在！");
        }
        Boolean flag =  courseService.delete(id);
        if (flag){//删除成功
            return R.success("删除成功！");
        }else
            return R.error("已有学生选中，删除失败！");

    }

    @PutMapping("/update")
    public R updateCourse(@RequestBody Course course){
        boolean save = courseService.saveOrUpdate(course);
        if (save)
            return R.success("修改成功！");
        else
            return R.error("修改失败");
    }
    @GetMapping("/page")
    public R page(int page,int pageSize,String name){
        Page<Course> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Course> courseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        courseLambdaQueryWrapper.like(name!=null,Course::getCourseName,name);//模糊查询
        courseService.page(pageInfo,courseLambdaQueryWrapper);
        return R.success(pageInfo);
    }

}
