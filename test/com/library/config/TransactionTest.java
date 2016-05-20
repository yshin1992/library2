package com.library.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.domain.Manager;
import com.library.service.impl.ManagerServiceImpl;

public class TransactionTest
{

    public static void main(String[] args)
    {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        ManagerServiceImpl managerService=ctx.getBean("managerService",ManagerServiceImpl.class);
        managerService.checkTransaction();
//        new TransactionTest().execute();
    }

    public void execute(){
        Manager user=new Manager();
        user.setManagerID("test02");
        user.setPassword("yshin1992");
//        user = session.selectOne(statement, user);
//        ManagerDao managerDao=session.getMapper(ManagerDao.class);
//        user=(Manager) managerDao.query(user);
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        ManagerServiceImpl managerService=ctx.getBean("managerService",ManagerServiceImpl.class);
        managerService.delete(user);
        user.setManagerID("test02");
        managerService.insert(user);
        System.out.println(user+"-------------->");
    }
}
