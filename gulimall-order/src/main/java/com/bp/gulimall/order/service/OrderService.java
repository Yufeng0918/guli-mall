package com.bp.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bp.common.utils.PageUtils;
import com.bp.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author daiyu
 * @email jiangyufeng@gmail.com
 * @date 2020-04-22 11:47:47
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

