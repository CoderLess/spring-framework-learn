package com.ibn.annotation.service.impl;

import com.ibn.annotation.dao.UserBaseDao;
import com.ibn.domain.UserBaseDTO;
import com.ibn.entity.UserBaseDO;
import com.ibn.service.UserBaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-learn
 * @see: com.ibn.annotation.service.impl
 * @author： RenBin
 * @createTime：2020/6/12 16:14
 */
public class UserBaseServiceImpl implements UserBaseService {
    //    @Inject
    //    @Resource
    @Autowired
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

    @Autowired
    @Override
    public int update(@Nullable UserBaseDTO userBaseDTO) {
        return 0;
    }

    public void setUserBaseDao(UserBaseDao userBaseDao) {
        this.userBaseDao = userBaseDao;
    }

}
