package com.bp.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bp.common.utils.PageUtils;
import com.bp.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author daiyu
 * @email jiangyufeng@gmail.com
 * @date 2020-04-22 08:36:01
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);

    Long[] findCatelogPath(Long catelogId);

    void updateCascade(CategoryEntity category);
}

