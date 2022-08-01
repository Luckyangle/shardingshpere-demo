package com.zhiyun.sharding_sphere.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiyun.sharding_sphere.entity.User;
import com.zhiyun.sharding_sphere.mapper.UserMapper;
import com.zhiyun.sharding_sphere.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2022-07-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
