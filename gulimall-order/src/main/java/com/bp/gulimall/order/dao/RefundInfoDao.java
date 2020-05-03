package com.bp.gulimall.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bp.gulimall.order.entity.RefundInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退款信息
 *
 * @author daiyu
 * @email jiangyufeng@gmail.com
 * @date 2020-04-22 11:47:47
 */
@Mapper
public interface RefundInfoDao extends BaseMapper<RefundInfoEntity> {

}
