package com.itheima.reggie.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.SetmealDish;

import java.util.List;

public interface SetmealDishService extends IService<SetmealDish> {

    public void removeByIds(List<Long> ids);

}
