package com.halbert.dao;

import com.halbert.model.TreatLog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatMapper {
    @Insert("INSERT INTO treat_log(plan_id,shot_id,start_time,end_time) VALUES(#{planId}, #{shotId}, #{startTime}, #{endTime})")
    public void insert(TreatLog log);

    @Update("UPDATE treat_log SET start_time=#{startTime},end_time=#{endTime} WHERE id =#{id}")
    public void update(TreatLog log);

    @Select("SELECT * FROM treat_log where plan_id=#{planId}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "planId",  column = "plan_id"),
            @Result(property = "shotId", column = "shot_id"),
            @Result(property = "startTime",  column = "start_time"),
            @Result(property = "endTime", column = "end_time")
    })
    public List<TreatLog> list(long planId);

}
