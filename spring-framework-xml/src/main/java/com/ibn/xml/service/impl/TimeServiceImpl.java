package com.ibn.xml.service.impl;

import com.ibn.service.TimeService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.Lifecycle;

/**
 * @version 1.0
 * @description:
 * @projectName：spring-framework-learn
 * @see: com.ibn.service.impl
 * @author： RenBin
 * @createTime：2020/6/12 9:43
 */
public class TimeServiceImpl implements TimeService, BeanPostProcessor, Lifecycle {
    @Override
    public Long createCurrentTime() {
        return System.currentTimeMillis();
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " BeforeInitialization =========");
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " AfterInitialization =========");
        return bean;
    }

    @Override
    public void start() {
        System.out.println("TimeServiceImpl start");
    }

    @Override
    public void stop() {
        System.out.println("TimeServiceImpl end");
    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
