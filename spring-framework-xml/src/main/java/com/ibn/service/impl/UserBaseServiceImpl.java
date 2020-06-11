package com.ibn.service.impl;

import com.ibn.dao.UserBaseDao;
import com.ibn.domain.UserBaseDTO;
import com.ibn.entity.UserBaseDO;
import com.ibn.service.UserBaseService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-demo
 * @see: com.ibn.service.impl
 * @author： RenBin
 * @createTime：2020/6/2 8:25
 */
@Getter
@Setter
public class UserBaseServiceImpl implements UserBaseService {
    private UserBaseDao userBaseDao;
    @Override
    public int save(UserBaseDTO userBaseDTO) {
        if (null == userBaseDTO) {
            return -1;
        }
        UserBaseDO userBaseDO = new UserBaseDO();
        BeanUtils.copyProperties(userBaseDTO, userBaseDO);
        userBaseDao.save(userBaseDO);
        return 0;
    }
}
