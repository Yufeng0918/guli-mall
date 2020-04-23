package com.bp.gulimall.member.feign;

import com.bp.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: daiyu
 * @Date: 22/4/20 15:32
 * @Description:
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();

}
