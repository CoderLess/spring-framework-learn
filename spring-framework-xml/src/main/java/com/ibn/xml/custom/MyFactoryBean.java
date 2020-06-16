package com.ibn.xml.custom;

import com.ibn.domain.UserBaseDTO;
import org.springframework.beans.factory.FactoryBean;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-learn
 * @see: com.ibn.custom
 * @author： RenBin
 * @createTime：2020/6/12 14:58
 */
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new UserBaseDTO();
    }

    @Override
    public Class<?> getObjectType() {
        return UserBaseDTO.class;
    }
}
