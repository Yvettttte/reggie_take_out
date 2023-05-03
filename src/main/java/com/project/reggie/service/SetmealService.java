package com.project.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.reggie.dto.SetmealDto;
import com.project.reggie.entity.Setmeal;
import com.project.reggie.entity.SetmealDish;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);

    public void deleteWithDish(List<Long> ids);
}
