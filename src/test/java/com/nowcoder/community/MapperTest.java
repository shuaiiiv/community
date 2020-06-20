package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//希望使用配置类
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper mapper1;

    @Autowired
    private DiscussPostMapper  discussPostMapper;

    @Test
    public void getUserByid()
    {
        User user=mapper1.selectByid(101);
        System.out.println(user);
    }

    @Test
    public void getDiscussPost()
    {
        List<DiscussPost> discussPosts=discussPostMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost post :discussPosts)
        {
            System.out.println(post.toString());
        }

        System.out.println(discussPostMapper.selectDiscussPostRows(149));
    }

}
