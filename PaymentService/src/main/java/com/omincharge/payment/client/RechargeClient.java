package com.omincharge.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Map;

@FeignClient(name = "recharge-service")
public interface RechargeClient {

    @GetMapping("/api/v1/recharges/{id}")
    Map<String, Object> getRechargeById(@PathVariable Long id);

    @PostMapping("/api/v1/recharges/{id}/confirm")
    Map<String, Object> confirmRecharge(@PathVariable Long id);
}