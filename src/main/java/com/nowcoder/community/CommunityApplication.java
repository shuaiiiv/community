package com.nowcoder.community;

import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//表示这是一个配置文件
public class CommunityApplication {
	//这个类做了哪些事情，自动的创建了spring容器，自动扫描某些包下的类
	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

}
