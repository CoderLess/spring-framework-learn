package com.ibn.annotation.service.impl;

import com.ibn.annotation.dao.UserBaseDao;
import com.ibn.domain.UserBaseDTO;
import com.ibn.entity.UserBaseDO;
import com.ibn.service.UserBaseService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserBaseServiceImplTest {
    private static ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    @Test
    public void save() {
        UserBaseService userBaseService = (UserBaseService) applicationContext.getBean("userBaseService");
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        userBaseDTO.setId(1L);
        userBaseDTO.setUsername("zhangsan");
        userBaseDTO.setPassword("123");
        userBaseService.save(userBaseDTO);
    }
    /**
     * @description: 测试@Autowired
     * @author：RenBin
     * @createTime：2020/6/15 8:28
     */
    @Test
    public void printDO() {
        UserBaseDao userBaseDao = (UserBaseDao) applicationContext.getBean("userBaseDao");
        userBaseDao.printDO();
    }
    @Test
    public void printDTO() {
        UserBaseDao userBaseDao = (UserBaseDao) applicationContext.getBean("userBaseDao");
        userBaseDao.printDTO();
    }
    @Test
    public void testValue() {
        UserBaseDO userBaseDO = (UserBaseDO) applicationContext.getBean("initUserBaseDO");
        System.out.println(userBaseDO.toString());
    }
}