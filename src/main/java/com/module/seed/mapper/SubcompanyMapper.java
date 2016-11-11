package com.module.seed.mapper;

import com.module.seed.model.Subcompany;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SubcompanyMapper {
    @Delete({
        "delete from subcompany",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into subcompany (id, name, ",
        "code, city)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR})"
    })
    int insert(Subcompany record);

    int insertSelective(Subcompany record);

    @Select({
        "select",
        "id, name, code, city",
        "from subcompany",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.module.seed.mapper.SubcompanyMapper.BaseResultMap")
    Subcompany selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Subcompany record);

    @Update({
        "update subcompany",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Subcompany record);
}