package com.leyou.item.service;

import com.leyou.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @ClassName ItemService
 * @Description TODO
 * @Author wq
 * @Date 2018/10/30 10:32
 * @Version 1.0.0
 */
@Service
public class ItemService {

    public User insert(User user){
        user.setAge(new Random().nextInt(100));
        user.setName("jack");
        return user;
    }
}
