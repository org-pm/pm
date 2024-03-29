package com.practice.management.controller;

import com.practice.management.bean.dto.AddStudentDto;
import com.practice.management.bean.dto.UpdSrStudentDto;
import com.practice.management.bean.dto.UpdStudentDto;
import com.practice.management.bean.entity.Account;
import com.practice.management.bean.entity.Student;
import com.practice.management.bean.model.ResultModel;
import com.practice.management.controller.common.BaseController;
import com.practice.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 用户：包含三个角色的个人信息的CURD操作
 */
@RestController
@RequestMapping("/stu")
public class StudentController extends BaseController {

    @Autowired
    private StudentService studentService;

    /**
     * 添加学生
     * 角色：学校老师
     *
     * @param dto 学生信息对象
     * @return 添加是否成功
     */
    @PostMapping("/add")
    public ResultModel<Account> addStudent(@Valid @RequestBody AddStudentDto dto) {
        Student student = studentService.addStudent(dto);
        return success("添加成功", student);
    }

    /**
     * 学生更新个人信息
     * 角色：学生
     *
     * @param dto 学生更新的信息dto
     * @return 更新之后的学生信息对象
     */
    @PutMapping("/upd")
    public ResultModel<Student> updStudent(@Valid @RequestBody UpdStudentDto dto) {
        Student student = studentService.updStudent(dto);
        return success("修改成功", student);
    }

    /**
     * 学校老师根据指定的学生id删除学生
     * 角色：学校负责人
     *
     * @param srId  学校负责人id
     * @param stuId 学生id
     * @return 删除的学校老师信息
     */
    @DeleteMapping("/del/{srId:\\d+}/{stId:\\d+}")
    public ResultModel<Student> deleteSR(
            @Valid @NotNull(message = "学校老师id不能为空") @PathVariable("srId") Long srId,
            @Valid @NotNull(message = "学生id不能为空") @PathVariable("stId") Long stuId) {
        Student student = studentService.deleteById(srId, stuId);
        return success("删除成功", student);
    }

    /**
     * 学校老师更新学生信息
     * 角色：学校负责人/学校老师
     *
     * @param dto 学生更新的信息dto
     * @return 更新之后的学生信息对象
     */
    @PutMapping("/sr/upd")
    public ResultModel<Student> updStudentBySr(@Valid @RequestBody UpdSrStudentDto dto) {
        Student student = studentService.updStudentBySr(dto);
        return success("修改成功", student);
    }

    /**
     * 根据学校id和学生账号查询学生信息
     *
     * @param scId  学校id
     * @param account 学生账号
     * @return 学生信息
     */
    @GetMapping("/self/{scId:\\d+}/{account:\\S+}")
    public ResultModel<Student> getStudentSelf(@PathVariable("scId") Long scId,
                                               @PathVariable("account") String account) {

        Student student = studentService.findByScIdAndAccount(scId, account);
        return success(student);
    }
}
