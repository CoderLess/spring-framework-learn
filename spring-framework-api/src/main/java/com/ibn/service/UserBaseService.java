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
}
