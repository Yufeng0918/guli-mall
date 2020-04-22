package com.bp.gulimall.member.dao;

import com.bp.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author daiyu
 * @email jiangyufeng@gmail.com
 * @date 2020-04-22 11:32:54
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
