package com.test.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.DTO.ChooseCourseDTO;
import com.test.DTO.StudentDTO;
import com.test.bean.ChooseCourse;
import com.test.bean.Student;
import com.test.common.R;
import com.test.service.ChooseCourseService;
import com.test.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 18:47 2023/2/3
 * @Classname StudentController
 */

@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ChooseCourseService chooseCourseService;

    /**
     * 根据id查找学生,并返回选课信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getStudentById(@PathVariable Integer id){
        Student student = studentService.getById(id);
        List<ChooseCourseDTO> chooseCourseList= chooseCourseService.getBYStudentId(id);
        StudentDTO studentDTO = new StudentDTO();
        BeanUtil.copyProperties(student,studentDTO);
        studentDTO.setChooseCourseDTOList(chooseCourseList);
        return R.success(studentDTO);
    }

    /**
     * 新增学生
     * @param student
     * @return
     */
    @PostMapping("/insert")
    public R insertStudent(@RequestBody Student student){
        boolean save = studentService.save(student);
        if (save){
            return R.success("添加成功");
        }else
            return R.error("添加失败");
    }
    @PutMapping("/update")
    public R updateStudent(@RequestBody Student student){
        boolean b = studentService.updateById(student);
        if (b){
            return R.success("修改成功！");
        }else
            return R.error("修改失败");
    }
    @DeleteMapping("/delete/{id}")
    public R deleteStudent(@PathVariable Integer id){
        boolean delete = studentService.delete(id);//删除学生并删除关联的课程
        if (delete)
            return R.success("删除成功!");
        else
            return R.error("删除失败！");
    }

    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name,Integer sex,Integer grade){
        Page<Student> pageInfo = new Page<>(page,pageSize);//设置分页信息
        LambdaQueryWrapper<Student> studentLambdaQueryWrapper = new LambdaQueryWrapper<>();
        studentLambdaQueryWrapper.like(name!=null,Student::getStudName,name);//模糊查找姓名条件
        studentLambdaQueryWrapper.eq(sex!=null,Student::getSex,sex);//判断性别是否为空，然后比较
        studentLambdaQueryWrapper.eq(grade!=null,Student::getGrade,grade);//判断年级是否为空，然后比较
        studentService.page(pageInfo,studentLambdaQueryWrapper);//得到查询出的数据

        return R.success(pageInfo);
    }

    /**
     * 学生选课
     * @param
     * @return
     */
    @PostMapping("/chooseCourse")
    public R chooseCourse(@RequestBody ChooseCourse chooseCourse){
        //判断学生是否已经选了
        LambdaQueryWrapper<ChooseCourse> chooseCourseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        Integer courseId = chooseCourse.getCourseId();
        Integer studentId = chooseCourse.getStudentId();
        chooseCourseLambdaQueryWrapper.eq(courseId!=null,ChooseCourse::getCourseId,courseId);
        chooseCourseLambdaQueryWrapper.eq(studentId!=null,ChooseCourse::getStudentId,studentId);
        ChooseCourse one = chooseCourseService.getOne(chooseCourseLambdaQueryWrapper);
        if (one!=null){//学生已经选课了
            return R.error("学生已选课！");
        }
        boolean save = chooseCourseService.save(chooseCourse);
        if (save){
            return R.success("选课成功!");
        }else
            return R.error("学生或课程不存在！");

    }


}
