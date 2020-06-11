package com.ibn.dao;

import com.ibn.entity.MemberBaseDO;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-learn
 * @see: com.ibn.dao
 * @author： RenBin
 * @createTime：2020/6/11 13:48
 */
public class MemberBaseDao {
    public void save(MemberBaseDO memberBaseDO) {
        System.out.println(memberBaseDO.toString());
    }
}
