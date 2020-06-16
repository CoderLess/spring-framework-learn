package com.ibn.annotation.dao;

import com.ibn.domain.UserBaseDTO;
import com.ibn.entity.UserBaseDO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-learn
 * @see: com.ibn.dao
 * @author： RenBin
 * @createTime：2020/6/10 16:11
 */
@Data
public class UserBaseDao {
    @Autowired
    private UserBaseDO userBaseDO;
    @Autowired
    @Qualifier("main")
    private UserBaseDTO userBaseDTO;
    public void save(UserBaseDO userBaseDO) {
        System.out.println(userBaseDO.toString());
    }

    public void printDO() {
        System.out.println(userBaseDO.toString());
    }
    public void printDTO() {
        System.out.println(userBaseDTO.toString());
    }
}
