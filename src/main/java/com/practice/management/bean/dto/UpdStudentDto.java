package com.practice.management.bean.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UpdStudentDto {

    @NotNull(message = "学生id不能为空")
    private Long stuId;

    @NotBlank(message = "学生姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Range(min = 18, max = 80, message = "年龄不正确(18-80)")
    private int age;

    @NotBlank(message = "性别不能为空")
    private String gender;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$",
            message = "手机号格式不正确")
    private String phone;

    @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",
            message = "邮箱格式不正确")
    private String email;

    @NotNull(message = "备注不能为空")
    private String remarks;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
