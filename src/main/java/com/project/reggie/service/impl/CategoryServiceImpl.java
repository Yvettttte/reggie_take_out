package com.project.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.reggie.common.CustomException;
import com.project.reggie.entity.Category;
import com.project.reggie.entity.Dish;
import com.project.reggie.entity.Setmeal;
import com.project.reggie.mapper.CategoryMapper;
import com.project.reggie.service.CategoryService;
import com.project.reggie.service.DishService;
import com.project.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<Dish>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count = dishService.count(dishLambdaQueryWrapper);

        if(count > 0) {
            throw new CustomException("当前分类关联菜品，无法删除");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count1 = setmealService.count(setmealLambdaQueryWrapper);
        if (count1 > 0){
            throw new CustomException("当前分类关联套餐，无法删除");
        }

        super.removeById(id);
    }
}
