package com.bp.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bp.gulimall.product.entity.BrandEntity;
import com.bp.gulimall.product.service.BrandService;
import com.bp.gulimall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class GulimallProductApplicationTests {

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @Test
    void contextLoads() {
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setDescript("");
//        brandEntity.setName("APPLE");
//        brandService.save(brandEntity);
//        System.out.println("save success");

        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        list.forEach(item -> System.out.println(item));
    }


    @Test
    public void testFindPath() {
        Long[] catelogPath = categoryService.findCatelogPath(225L);
        log.info("full path size is " + catelogPath);
    }

}
