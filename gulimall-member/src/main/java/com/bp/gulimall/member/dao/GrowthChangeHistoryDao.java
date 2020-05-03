package com.bp.gulimall.member.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bp.gulimall.member.entity.GrowthChangeHistoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 成长值变化历史记录
 *
 * @author daiyu
 * @email jiangyufeng@gmail.com
 * @date 2020-04-22 11:32:54
 */
@Mapper
public interface GrowthChangeHistoryDao extends BaseMapper<GrowthChangeHistoryEntity> {

}
