package com.module.seed.mapper;

import com.module.seed.model.School;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SchoolMapper {
    @Delete({
        "delete from school",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into school (id, name, ",
        "province_name, province_code)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{provinceName,jdbcType=VARCHAR}, #{provinceCode,jdbcType=VARCHAR})"
    })
    int insert(School record);

    int insertSelective(School record);

    @Select({
        "select",
        "id, name, province_name, province_code",
        "from school",
        "where id = #{id,jdbcType=BIGINT}"
    })
//    @ResultMap("SchoolMapper.BaseResultMap")
    School selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(School record);

    @Update({
        "update school",
        "set name = #{name,jdbcType=VARCHAR},",
          "province_name = #{provinceName,jdbcType=VARCHAR},",
          "province_code = #{provinceCode,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(School record);
}