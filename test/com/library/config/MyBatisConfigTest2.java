package com.library.config;

import java.io.InputStream;
import java.util.List;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.library.dao.SysFuncDao;
import com.library.entity.SysFunc;

public class MyBatisConfigTest2 extends TestCase {
	
	public void testConfig(){
		//mybatis的配置文件
        String resource = "mybatis/MyBatis-config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MyBatisConfigTest2.class.getClassLoader().getResourceAsStream(resource);
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
        String statement = "com.library.dao.SysFuncDao.getSysFuncWithRole";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
//        user = session.selectOne(statement, user);
        SysFuncDao managerDao=session.getMapper(SysFuncDao.class);
        List<SysFunc> resList=managerDao.getSysFuncWithRole(1);
        System.out.println(resList+"-------------->");

	}

}
