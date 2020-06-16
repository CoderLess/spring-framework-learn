package com.ibn.service;

import com.ibn.domain.MemberBaseDTO;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-learn
 * @see: com.ibn.service
 * @author： RenBin
 * @createTime：2020/6/12 9:11
 */
public interface MemberBaseService {
    /**
     * @description: 会员信息保存
     * @author：RenBin
     * @createTime：2020/6/12 9:18
     */
    int save(MemberBaseDTO memberBaseDTO);
}
