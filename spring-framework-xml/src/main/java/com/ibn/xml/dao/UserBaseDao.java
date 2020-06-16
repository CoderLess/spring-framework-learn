package com.ibn.xml.dao;

import com.ibn.entity.UserBaseDO;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-learn
 * @see: com.ibn.dao
 * @author： RenBin
 * @createTime：2020/6/10 16:11
 */
public class UserBaseDao {
    public void save(UserBaseDO userBaseDO) {
        System.out.println(userBaseDO.toString());
    }
}
