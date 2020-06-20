package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.dao.AlphaDaoHiberateImpl;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
//希望使用配置类
@ContextConfiguration(classes = CommunityApplication.class)
public class CommunityApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;//spring容器

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}


	@Test
	public void contextLoads() {
		System.out.println(applicationContext);
		AlphaDao alphoDao=applicationContext.getBean(AlphaDao.class);
		System.out.println(alphoDao.select());

		alphoDao=applicationContext.getBean("alphaHib",AlphaDao.class);
		System.out.println(alphoDao.select());
	}

	@Test
	public void testBeanMangement()
	{
		AlphaService alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);

		alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}

	@Test
	public void testBeanConfig()
	{
		SimpleDateFormat simpleDateFormat=applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	//上面获取对象仍然是通过主动的获取，并没有实现相互的解耦
	//依赖注入(三种方式属性、构造器、set方法)
	@Autowired
	@Qualifier("alphaHib")
	private AlphaDao alphaDao;


	@Autowired
	private AlphaService alphaService;

	@Test
	public void testAutoWired()
	{
		System.out.println(alphaDao);
		System.out.println(alphaService);
	}
}
