package com.ibn.xml.ao;

import com.ibn.service.TimeService;
import com.ibn.xml.vo.UserBaseVO;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-learn
 * @see: com.ibn.ao
 * @author： RenBin
 * @createTime：2020/6/12 9:25
 */
public abstract class AbstractUserBaseAO {
    /**
     * @description: 保存用户信息
     * @author：RenBin
     * @createTime：2020/6/12 9:34
     */
    public UserBaseVO saveUserBaseVO(UserBaseVO userBaseVO) {
        TimeService currentTime = createCurrentTime();
        Long currTime=currentTime.createCurrentTime();
        userBaseVO.setCreateTime(currTime);
        return userBaseVO;
    }
    /**
     * @description: 获取一下当前时间
     * @author：RenBin
     * @createTime：2020/6/12 9:36
     */
    protected abstract TimeService createCurrentTime();
}
