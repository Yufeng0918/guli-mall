package com.bp.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bp.common.utils.PageUtils;
import com.bp.gulimall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author daiyu
 * @email jiangyufeng@gmail.com
 * @date 2020-04-22 08:36:01
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);
}

