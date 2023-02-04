package com.test.DTO;

import com.test.bean.ChooseCourse;
import lombok.Data;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 16:44 2023/2/4
 * @Classname ChooseCourseDTO
 */
@Data
public class ChooseCourseDTO extends ChooseCourse {
    //学生姓名
    private String studName;
    //课程名
    private String courseName;
}
