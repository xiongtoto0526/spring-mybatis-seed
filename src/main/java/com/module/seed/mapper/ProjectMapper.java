package com.module.seed.mapper;

import com.module.seed.model.Project;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProjectMapper {
    @Delete({
        "delete from project",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into project (id, name, ",
        "short_name, en_short_name, ",
        "status, servie_line, ",
        "description, contact_name, ",
        "active_flag, hr_list, ",
        "city, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{shortName,jdbcType=VARCHAR}, #{enShortName,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{servieLine,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{contactName,jdbcType=VARCHAR}, ",
        "#{activeFlag,jdbcType=BIT}, #{hrList,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Project record);

    int insertSelective(Project record);

    @Select({
        "select",
        "id, name, short_name, en_short_name, status, servie_line, description, contact_name, ",
        "active_flag, hr_list, city, create_time, update_time",
        "from project",
        "where id = #{id,jdbcType=BIGINT}"
    })
    Project selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Project record);

    @Update({
        "update project",
        "set name = #{name,jdbcType=VARCHAR},",
          "short_name = #{shortName,jdbcType=VARCHAR},",
          "en_short_name = #{enShortName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "servie_line = #{servieLine,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "contact_name = #{contactName,jdbcType=VARCHAR},",
          "active_flag = #{activeFlag,jdbcType=BIT},",
          "hr_list = #{hrList,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Project record);
}