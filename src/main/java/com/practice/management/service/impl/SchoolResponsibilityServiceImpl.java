package com.practice.management.service.impl;

import com.practice.management.bean.dto.*;
import com.practice.management.bean.entity.School;
import com.practice.management.bean.entity.SchoolResponsibility;
import com.practice.management.bean.model.SrQueryModel;
import com.practice.management.mapper.SchoolResponsibilityMapper;
import com.practice.management.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchoolResponsibilityServiceImpl implements SchoolResponsibilityService {

    @Autowired
    private SchoolResponsibilityMapper srMapper;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private AuthService authService;

    @Autowired
    private RoleService roleService;

    @Transactional
    @Override
    public School updSchool(UpdSchoolDto dto) {
        Long srId = dto.getSrId();
        SchoolResponsibility sr = findById(srId);

        Long schoolId = sr.getSchoolId();
        UpdSchoolParamDto school = dto.getSchool();
        if (!schoolId.equals(school.getId()))
            throw new RuntimeException("学校负责人:" + sr.getName() + "不属于学校:" + school.getName());

        // 验证学校的负责人
        School temp = schoolService.findById(schoolId);
        if (!temp.getAccount().equals(sr.getAccount()))
            throw new RuntimeException("学校:" + temp.getName() + "的负责人不是:" + sr.getName());

        return schoolService.updateById(school);
    }

    @Override
    public SchoolResponsibility findById(Long srId) {
        SchoolResponsibility sr = srMapper.findById(srId);
        if (sr == null)
            throw new RuntimeException("学校负责人id:" + srId + "不存在！");
        return sr;
    }

    @Transactional
    @Override
    public void addSchoolTeacher(AddSchoolTeacherDto dto) {
        Long srId = dto.getSrId();
        SchoolResponsibility sr = findById(srId);
        dto.setSchoolId(sr.getSchoolId());

        SchoolResponsibility srTemp = srMapper.findByScIdAndAccount(sr.getSchoolId(), dto.getAccount());
        if (srTemp != null)
            throw new RuntimeException("学校id为:" + sr.getSchoolId() + "的老师账号:" + dto.getAccount() + "已存在");

        // 验证角色：学校老师的权限不可比学校负责人的权限高
        if (dto.getRoleId() != null)
            roleService.authorityValidate(sr.getRoleId(), dto.getRoleId());
        else dto.setRoleId(2L);

        authService.register(dto);
    }

    @Transactional
    @Override
    public SchoolResponsibility updateSr(UpdSrDto dto) {
        findById(dto.getSrId());
        srMapper.updateSrById(dto);

        return findById(dto.getSrId());
    }

    @Transactional
    @Override
    public SchoolResponsibility updSrTeacher(UpdSchoolTeacherDto dto) {
        validateSrAndSt(dto.getSrId(), dto.getStId());

        // 验证角色：学校老师的权限不可比学校负责人的权限高
        if (dto.getRoleId() != null)
            roleService.authorityValidate(findById(dto.getSrId()).getRoleId(), dto.getRoleId());
        else dto.setRoleId(2L);

        srMapper.updateSrTeacherById(dto);
        return findById(dto.getStId());
    }

    /**
     * 验证企业负责人和企业老师是否同属于同一个企业
     *
     * @param srId 企业负责人id
     * @param stId 企业老师id
     * @return 企业老师信息
     */
    private SchoolResponsibility validateSrAndSt(Long srId, Long stId) {
        SchoolResponsibility sr = findById(srId);
        if (sr == null)
            throw new RuntimeException("学校负责人id:" + srId + "不存在");

        SchoolResponsibility st = findById(stId);
        if (st == null)
            throw new RuntimeException("学校老师id:" + stId + "不存在");

        if (!sr.getSchoolId().equals(st.getSchoolId()))
            throw new RuntimeException(
                    "学校负责人:" + sr.getName() + "和企业老师:" + st.getName() + "不在同一个学校！");

        return st;
    }

    @Transactional
    @Override
    public SchoolResponsibility deleteById(Long srId, Long stId) {
        SchoolResponsibility st = validateSrAndSt(srId, stId);
        srMapper.deleteById(stId);

        return st;
    }

    @Override
    public List<SchoolResponsibility> queryByCondition(SrQueryModel queryCondition) {
        SchoolResponsibility sr = findById(queryCondition.getSrId());
        School school = schoolService.findById(queryCondition.getSchoolId());

        if (!sr.getSchoolId().equals(school.getId()))
            throw new RuntimeException("学校负责人:" + sr.getName() + "不属于学校:" + school.getName());

        return srMapper.queryByCondition(queryCondition);
    }

    @Override
    public SchoolResponsibility validateSrAuthority(Long srId) {
        SchoolResponsibility sr = findById(srId);
        School school = schoolService.findById(sr.getSchoolId());

        if (!school.getAccount().equals(sr.getAccount()))
            throw new RuntimeException("学校:" + school.getName() + "的负责人不是:" + sr.getName());

        return sr;
    }

    @Override
    public SchoolResponsibility findByScIdAndAccount(Long scId, String account) {
        schoolService.findById(scId);

        SchoolResponsibility sr = srMapper.findByScIdAndAccount(scId, account);
        if (sr == null)
            throw new RuntimeException("学校老师信息不存在");

        return sr;
    }

}
