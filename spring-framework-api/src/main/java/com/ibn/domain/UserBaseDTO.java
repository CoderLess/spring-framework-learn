package com.ibn.domain;

import lombok.Data;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-demo
 * @see: com.ibn.domain
 * @author： RenBin
 * @createTime：2020/6/2 8:23
 */
@Data
public class UserBaseDTO {
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
