package com.bp.gulimall.coupon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bp.gulimall.coupon.entity.CouponEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 *
 * @author daiyu
 * @email jiangyufeng@gmail.com
 * @date 2020-04-22 10:38:06
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {

}
