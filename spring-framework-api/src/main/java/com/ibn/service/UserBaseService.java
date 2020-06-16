package com.ibn.service;

import com.ibn.domain.UserBaseDTO;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-demo
 * @see: com.ibn.service
 * @author： RenBin
 * @createTime：2020/6/2 8:24
 */
public interface UserBaseService {
    /**
     * @description: 保存用户
     * @author：RenBin
     * @createTime：2020/6/2 8:24
     */
    int save(UserBaseDTO userBaseDTO);
    /**
     * @description: 更新用户信息
     * @author：RenBin
     * @createTime：2020/6/12 17:34
     */
    int update(UserBaseDTO userBaseDTO);
}
