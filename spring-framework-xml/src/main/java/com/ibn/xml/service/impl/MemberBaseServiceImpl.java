package com.ibn.xml.service.impl;

import com.ibn.xml.dao.MemberBaseDao;
import com.ibn.domain.MemberBaseDTO;
import com.ibn.service.MemberBaseService;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-learn
 * @see: com.ibn.service.impl
 * @author： RenBin
 * @createTime：2020/6/12 9:11
 */
public class MemberBaseServiceImpl implements MemberBaseService {
    private MemberBaseDao memberBaseDao;

    public MemberBaseServiceImpl(MemberBaseDao memberBaseDao) {
        this.memberBaseDao = memberBaseDao;
    }

    @Override
    public int save(MemberBaseDTO memberBaseDTO) {
        return 0;
    }

}
