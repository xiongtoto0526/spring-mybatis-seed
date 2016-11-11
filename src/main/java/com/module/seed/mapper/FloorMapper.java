package com.module.seed.mapper;

import com.module.seed.model.Floor;
import org.apache.ibatis.annotations.*;

public interface FloorMapper {
    @Delete({
        "delete from floor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Delete({
            "delete from floor",
            "where id = #{name}"
    })
    int deleteByName(String name);

    @Insert({
        "insert into floor (id, name, ",
        "city, assistant_id)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{assistantId,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Floor record);

    int insertSelective(Floor record);

    @Select({
        "select",
        "id, name, city, assistant_id",
        "from floor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    Floor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Floor record);

    @Update({
        "update floor",
        "set name = #{name,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "assistant_id = #{assistantId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Floor record);
}