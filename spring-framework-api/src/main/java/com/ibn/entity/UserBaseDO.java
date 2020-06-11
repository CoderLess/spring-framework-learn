package com.ibn.entity;

import lombok.Data;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-demo
 * @see: com.ibn.entity
 * @author： RenBin
 * @createTime：2020/6/1 17:12
 */
@Data
public class UserBaseDO {
    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020/6/2 8:23
     */
    private Long id;
    /**
     * @description: 用户名
     * @author：RenBin
     * @createTime：2020/6/2 8:23
     */
    private String username;
    /**
     * @description: 密码
     * @author：RenBin
     * @createTime：2020/6/2 8:23
     */
    private String password;
}
