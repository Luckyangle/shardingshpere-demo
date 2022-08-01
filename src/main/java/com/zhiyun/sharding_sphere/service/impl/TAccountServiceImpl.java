package com.zhiyun.sharding_sphere.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiyun.sharding_sphere.entity.TAccount;
import com.zhiyun.sharding_sphere.mapper.TAccountMapper;
import com.zhiyun.sharding_sphere.service.ITAccountService;
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
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements ITAccountService {

}
