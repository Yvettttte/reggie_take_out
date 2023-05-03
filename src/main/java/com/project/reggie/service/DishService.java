package com.project.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.reggie.dto.DishDto;
import com.project.reggie.entity.Dish;

public interface DishService extends IService<Dish> {

    //新增菜品，同时插入口味数据
    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);
}
