package com.tothenew.sharda.springsecurity1.Controller;


import com.tothenew.sharda.springsecurity1.CouponRepo.CouponRepository;
import com.tothenew.sharda.springsecurity1.Entity.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
    @Autowired
    CouponRepository couponRepository;

    @PostMapping("/coupons")
    public Coupon create(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupons(@PathVariable("code") String code){
        return couponRepository.findByCode(code);
    }

}
