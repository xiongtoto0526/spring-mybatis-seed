package com.module.seed.mapper;

import com.module.seed.model.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentMapper {

    @Delete("delete from department where id=#{id}")
    void deleteById(int id);

    @Select("select * from department")
    List<Department> findAll();

    @Select("select * from department where id=#{id}")
    Department findById(long id);

    @Update("update department set name=#{param2} where id=#{param1}")
    void updateNameById(long id,String name);

    @Select("select * from department where name=#{name}")
    Department findByName(String name);

    @Insert("insert into department(id,name,assistant_id,city,description,active_flag,create_time,update_time) values (#{id},#{name}, #{assistantId}, #{city}, #{description}, #{activeFlag}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Department department);
}
