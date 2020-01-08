package com.xd.demo.common.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xd.demo.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController <T>{

    @Autowired
    IService<T> service;

    @GetMapping("/list")
    public List<T> list(){
        return service.list();
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PostMapping
    public Result add(@RequestBody T o){
        boolean flag = service.save(o);
        if (flag){
            return Result.success("新增成功");
        }else{
            return Result.error("新增失败");
        }
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id){
        boolean flag = service.removeById(id);
        if (flag){
            return "success";
        }else{
            return "fail";
        }
    }

    @DeleteMapping("/ids")
    public String deleteByIds(@RequestBody List<Integer> ids){
        boolean flag = service.removeByIds(ids);
        if (flag){
            return "success";
        }else{
            return "fail";
        }
    }

    @PutMapping
    public Result updateById(@RequestBody T o){
        boolean flag = service.updateById(o);
        if (flag){
            return Result.success("更新成功");
        }else{
            return Result.success("更新失败");
        }
    }
}
