package com.bp.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bp.common.utils.PageUtils;
import com.bp.gulimall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author daiyu
 * @email jiangyufeng@gmail.com
 * @date 2020-04-22 08:36:01
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

