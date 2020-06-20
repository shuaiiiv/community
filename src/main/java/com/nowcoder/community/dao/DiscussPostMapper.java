package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@Repository
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userid,int offset,int limit);//个人帖子查询

    //@Param注解用于给参数取别名
    //如果只有一个参数，并且在<if>中使用，则必须添加别名
    int selectDiscussPostRows(@Param("userid") int userid);
}
