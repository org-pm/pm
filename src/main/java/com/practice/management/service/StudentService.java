package com.practice.management.service;

import com.practice.management.bean.dto.AddStudentDto;
import com.practice.management.bean.dto.UpdSrStudentDto;
import com.practice.management.bean.dto.UpdStudentDto;
import com.practice.management.bean.entity.Student;

public interface StudentService {
    /**
     * 根据学校添加学生信息
     *
     * @param dto 学生信息对象
     * @param schoolId 学校id
     * @return 添加之后的结果
     */
    Student addStudent(AddStudentDto dto, Long schoolId);

    Student findById(Long stuId);

    /**
     * 学生更新个人信息
     * 角色：学生
     *
     * @param dto 学生更新的信息dto
     * @return 更新之后的学生信息对象
     */
    Student updStudent(UpdStudentDto dto);

    /**
     * 学校老师更新学生信息
     * 角色：学校负责人/学校老师
     *
     * @param dto 学生更新的信息dto
     * @return 更新之后的学生信息对象
     */
    Student updStudentBySr(UpdSrStudentDto dto);
}
