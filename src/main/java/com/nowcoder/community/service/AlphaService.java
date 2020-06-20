package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("prototype")
public class AlphaService {

    //希望在service中调用dao获取数据库的数据，所以需要注入dao中的实例
    @Autowired
    private AlphaDao alphaDao;
    public String find()
    {
        return alphaDao.select();
    }



    public AlphaService()
    {
        System.out.println("实例化AlphaService");
    }

    @PostConstruct//初始化后立刻调用
    public void init()
    {
        System.out.println("初始化AlphaService");
    }

    @PreDestroy//销毁后
    public void destory()
    {
        System.out.println("销毁AlphaService");
    }
}
