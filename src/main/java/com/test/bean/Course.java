package com.test.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 18:15 2023/2/3
 * @Classname Course 课程实体
 */
@Data
public class Course implements Serializable {
    //课程id
    @TableId(type = IdType.AUTO)
    private Integer id;
    //课程姓名
    private String courseName;
    //课程学分
    private Float credit;
}
