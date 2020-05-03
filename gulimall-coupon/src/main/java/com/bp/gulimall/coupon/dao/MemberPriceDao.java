package com.bp.gulimall.coupon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bp.gulimall.coupon.entity.MemberPriceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 *
 * @author daiyu
 * @email jiangyufeng@gmail.com
 * @date 2020-04-22 10:38:06
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {

}
