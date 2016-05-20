package com.library.config;

import java.io.InputStream;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.dao.ManagerDao;
import com.library.domain.Manager;
import com.library.service.impl.ManagerServiceImpl;

public class MyBatisConfigTest extends TestCase {
	
	public void testConfig(){
		//mybatis的配置文件
        String resource = "mybatis/MyBatis-config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MyBatisConfigTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.library.domain.ManagerMapper.getManager";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        Manager user=new Manager();
        user.setManagerID("101");
        user.setPassword("yshin1992");
//        user = session.selectOne(statement, user);
//        ManagerDao managerDao=session.getMapper(ManagerDao.class);
//        user=(Manager) managerDao.query(user);
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        ManagerServiceImpl managerService=ctx.getBean("managerService",ManagerServiceImpl.class);
        user=managerService.query(user);
        System.out.println(user+"-------------->");

	}

}
