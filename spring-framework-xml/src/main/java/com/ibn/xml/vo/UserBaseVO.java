package com.ibn.xml.vo;

import lombok.Data;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-learn
 * @see: com.ibn.vo
 * @author： RenBin
 * @createTime：2020/6/12 9:28
 */
@Data
public class UserBaseVO {
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
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020/6/12 9:31
     */
    private Long createTime;
}
