package com.zhiyun.sharding_sphere;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhiyun.sharding_sphere.entity.TOrder;
import com.zhiyun.sharding_sphere.entity.TOrderItem;
import com.zhiyun.sharding_sphere.mapper.TOrderItemMapper;
import com.zhiyun.sharding_sphere.mapper.TOrderMapper;
import com.zhiyun.sharding_sphere.service.ITOrderItemService;
import com.zhiyun.sharding_sphere.service.ITOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ShardingSphereApplicationTests {

    @Autowired
    private ITOrderService itOrderService;

    @Autowired
    private ITOrderItemService itOrderItemService;

    @Autowired
    private TOrderMapper orderMapper;

    @Autowired
    private TOrderItemMapper orderItemMapper;

    @Test
    void databaseTableSharding() {
        for(int x = 0; x < 100; x ++){
            TOrder order = new TOrder();
            order.setPrice(23d);
            if (x % 2 == 1) {
                order.setUserId(1L);
            }else{
                order.setUserId(2L);
            }
            itOrderService.save(order);
        }
    }

    @Test
    void orderItemSharding(){

        for (int x = 0; x < 100; x ++){
            TOrderItem orderItem = new TOrderItem();
            if (x % 2 == 1) {
                orderItem.setUserId(1L);
                orderItem.setOrderId(1L);
            }else{
                orderItem.setUserId(2L);
                orderItem.setOrderId(2L);
            }
            itOrderItemService.save(orderItem);
        }
    }

    @Test
    void databaseTableBinding() {
        for(int x = 0; x < 100; x ++){
            TOrder order = new TOrder();
            order.setPrice(23d);
            if (x % 2 == 1) {
                order.setUserId(1L);
            }else{
                order.setUserId(2L);
            }
            itOrderService.save(order);

            TOrderItem orderItem = new TOrderItem();
            orderItem.setOrderId(order.getOrderId());
            orderItem.setUserId(order.getUserId());
            itOrderItemService.save(orderItem);
        }
    }

    @Test
    void readWriteSplitting(){
        for(int x = 0; x < 100; x ++){
            TOrder order = new TOrder();
            order.setPrice(23d);
            order.setUserId(3L);
            itOrderService.save(order);
        }
    }

    @Test
    void selectOrderAndOrderItem(){

        List<TOrder> tOrders = orderMapper.selectList(Wrappers.lambdaQuery());
        List<TOrderItem> tOrderItems = orderItemMapper.selectList(Wrappers.lambdaQuery());
        System.out.println(tOrders);
        System.out.println(tOrderItems);
        System.out.println("here");
    }
}

