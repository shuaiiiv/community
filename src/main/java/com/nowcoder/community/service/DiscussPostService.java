package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    //这个功能很简单，但仍然应该采用分层的架构，以便后期业务的扩展

    @Autowired
    private DiscussPostMapper discussPostMapper;

    //返回查询的评论
    //查询的结果中userid是一串数字，实际使用中肯定需要的是名字，所以查询获得其
    public List<DiscussPost> findDiscussPosts(int userid,int offset,int limit)
    {
        return discussPostMapper.selectDiscussPosts(userid, offset, limit);
    }

    //返回总行数
    public int findDiscussPostsNum(int userid)
    {
        return discussPostMapper.selectDiscussPostRows(userid);
    }
}
