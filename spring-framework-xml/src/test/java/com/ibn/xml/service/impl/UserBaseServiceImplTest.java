package com.ibn.xml.service.impl;

import com.ibn.xml.ao.AbstractUserBaseAO;
import com.ibn.xml.dao.UserBaseDao;
import com.ibn.domain.UserBaseDTO;
import com.ibn.entity.UserBaseDO;
import com.ibn.service.UserBaseService;
import com.ibn.xml.vo.UserBaseVO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserBaseServiceImplTest {

    private static ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("services.xml", "daos" +
            ".xml", "aos.xml","customers.xml");

    /**
     * @description: 获取bean
     * @author：RenBin
     * @createTime：2020/6/11 11:48
     */
    @Test
    public void save() {
        UserBaseService userBaseService = (UserBaseService) applicationContext.getBean("userBaseService");
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        userBaseDTO.setId(1L);
        userBaseDTO.setUsername("zhangsan");
        userBaseDTO.setPassword("zhangassss");
        userBaseService.save(userBaseDTO);
    }

    /**
     * @description: DefaultListableBeanFactory的registerSingleton(..) and registerBeanDefinition(..)注册bean到ioc中
     * @author：RenBin
     * @createTime：2020/6/11 11:36
     */
    @Test
    public void createBean() {
        BeanFactory beanFactory = applicationContext.getBeanFactory();
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
        MutablePropertyValues values = new MutablePropertyValues();
        values.add("username", "my dog haha ");
        BeanDefinition beanDefinition = new RootBeanDefinition(UserBaseDTO.class, null, values);
        // 注册bean
        defaultListableBeanFactory.registerBeanDefinition("userBaseDTO", beanDefinition);
        // 注册bean
        UserBaseDO userBaseDO = new UserBaseDO();
        userBaseDO.setId(1L);
        userBaseDO.setUsername("zhangsan");
        userBaseDO.setPassword("123");
        defaultListableBeanFactory.registerSingleton("userBaseDO", userBaseDO);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        UserBaseDTO userBaseDTO = (UserBaseDTO) applicationContext.getBean("userBaseDTO");
        userBaseDO = (UserBaseDO) applicationContext.getBean("userBaseDO");
        System.out.println(userBaseDO);
        Assert.assertNotEquals(null, userBaseDTO);
        Assert.assertNotEquals(null, userBaseDTO);
    }

    /**
     * @description: 给bean指定别名
     * @author：RenBin
     * @createTime：2020/6/11 11:49
     */
    @Test
    public void beanNameTest() {
        UserBaseDao userBaseDao = (UserBaseDao) applicationContext.getBean("userBaseDao1");
        Assert.assertNotEquals(null, userBaseDao);
        userBaseDao = (UserBaseDao) applicationContext.getBean("userBaseDao2");
        Assert.assertNotEquals(null, userBaseDao);
        userBaseDao = (UserBaseDao) applicationContext.getBean("userBaseDao3");
        Assert.assertNotEquals(null, userBaseDao);
        userBaseDao = (UserBaseDao) applicationContext.getBean("userBaseDao4");
        Assert.assertNotEquals(null, userBaseDao);
    }

    /**
     * @description: 输出一下所有的bean
     * @author：RenBin
     * @createTime：2020/6/11 13:52
     */
    @Test
    public void printBeanName() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     * @description: 方法查找
     * @author：RenBin
     * @createTime：2020/6/12 9:53
     */
    @Test
    public void methodLookUp() {
        AbstractUserBaseAO abstractUserBaseAO = (AbstractUserBaseAO) applicationContext.getBean("userBaseAO");
        UserBaseVO userBaseVO = new UserBaseVO();
        userBaseVO.setId(1L);
        userBaseVO.setUsername("zhangsan");
        userBaseVO.setPassword("123");
        UserBaseVO userBaseVO1 = abstractUserBaseAO.saveUserBaseVO(userBaseVO);
        System.out.println(userBaseVO1.toString());
    }

    /**
     * @description: 生命周期函数测试
     * @author：RenBin
     * @createTime：2020/6/12 10:39
     */
    @Test
    public void lifecycleCallBacks() {
        TimeServiceImpl timeService = (TimeServiceImpl) applicationContext.getBean("timeService");
        timeService.start();
        System.out.println(timeService.createCurrentTime());
//        applicationContext.close();
        applicationContext.registerShutdownHook();
    }

}