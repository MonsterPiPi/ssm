package com.example.service;

import com.example.pojo.User; /**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/2
 * Time : 8:26
 * Talk is cheap. Show me the code.
 */
public interface UserService {
    boolean save(User user);


    boolean findByEmailAndPassword(String email, String password);
}
