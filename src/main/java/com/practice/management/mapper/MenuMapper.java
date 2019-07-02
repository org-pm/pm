package com.practice.management.mapper;

import com.practice.management.bean.entity.Menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Select("select * from menu where id in (" +
            "select menu_id from menurole where role_id=#{roleId})")
    List<Menu> findByRoleId(@Param("roleId") int roleId);

    @Insert("add into menu(sequence, logo, menu_name, menu_url, menu_parent, menu_level) " +
            "values(#{sequence}, #{logo}, #{menuName}, #{menuUrl}, #{menuParent}, #{menuLevel})")
    void add(Menu menu);
}