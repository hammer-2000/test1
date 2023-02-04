package com.test.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 18:18 2023/2/3
 * @Classname ChooseCourse 学生选课表
 */
@Data
public class ChooseCourse implements Serializable {
    //选课id
    @TableId(type = IdType.AUTO)
    private Integer id;
    //学生id
    private Integer StudentId;
    //课程id
    private Integer CourseId;

}
