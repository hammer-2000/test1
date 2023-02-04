package com.test.DTO;

import com.test.bean.ChooseCourse;
import com.test.bean.Student;
import lombok.Data;

import java.util.List;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 16:26 2023/2/4
 * @Classname StudentDTO
 */
@Data
public class StudentDTO extends Student {
    private List<ChooseCourseDTO> chooseCourseDTOList;
}
