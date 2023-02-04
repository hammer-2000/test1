package com.test.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 18:11 2023/2/3
 * @Classname Student 学生实体
 */
@Data
public class Student implements Serializable {
    //学生主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //学生姓名
    private String studName;
    //学生性别，1为男，2为女
    private Integer sex;
    //学生年级,1代表一年级，2代表二年级，一次类推
    private Integer grade;
}
