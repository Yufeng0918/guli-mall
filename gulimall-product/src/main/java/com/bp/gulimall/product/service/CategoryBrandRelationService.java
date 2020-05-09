package com.bp.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bp.common.utils.PageUtils;
import com.bp.gulimall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author daiyu
 * @email jiangyufeng@gmail.com
 * @date 2020-04-22 08:36:01
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveDetails(CategoryBrandRelationEntity categoryBrandRelation);

    void updateBrand(Long brandId, String name);

    void updateCategory(Long catId, String name);
}

