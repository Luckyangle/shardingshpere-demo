package com.zhiyun.sharding_sphere.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiyun.sharding_sphere.entity.TOrder;
import com.zhiyun.sharding_sphere.mapper.TOrderMapper;
import com.zhiyun.sharding_sphere.service.ITOrderService;
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
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

}
