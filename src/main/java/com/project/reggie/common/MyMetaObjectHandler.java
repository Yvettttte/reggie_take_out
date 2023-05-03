package com.project.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        long id = BaseContext.getCurrentId();
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("createUser",id);
        metaObject.setValue("updateUser",id);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        long id = BaseContext.getCurrentId();
        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("updateUser",id);

    }
}
