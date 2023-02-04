package com.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.DTO.ChooseCourseDTO;
import com.test.bean.ChooseCourse;

import java.util.List;

/**
 * @Author 摆子选手阿栋
 * @Version 1.0.0
 * @Date 20:56 2023/2/3
 * @Classname ChooseClassService
 */
public interface ChooseCourseService extends IService<ChooseCourse> {
    List<ChooseCourse> getByCourseId(Integer id);

    boolean save(ChooseCourse entity);


    List<ChooseCourseDTO> getBYStudentId(Integer id);
}
