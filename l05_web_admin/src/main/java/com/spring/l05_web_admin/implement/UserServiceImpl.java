package com.spring.l05_web_admin.implement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.l05_web_admin.mapper.UserMapper;
import com.spring.l05_web_admin.model.User;
import com.spring.l05_web_admin.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {}
