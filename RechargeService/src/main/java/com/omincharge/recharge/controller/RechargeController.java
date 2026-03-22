package com.omincharge.recharge.controller;

import com.omincharge.recharge.dto.*;
import com.omincharge.recharge.service.RechargeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recharges")
public class RechargeController {

    private final RechargeService rechargeService;

    public RechargeController(RechargeService rechargeService) {
        this.rechargeService = rechargeService;
    }

    @PostMapping("/initiate")
    public ResponseEntity<RechargeResponse> initiateRecharge(
            @Valid @RequestBody RechargeInitiateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rechargeService.initiateRecharge(request));
    }

    @PostMapping("/{id}/confirm")
    public ResponseEntity<RechargeResponse> confirmRecharge(
            @PathVariable Long id) {
        return ResponseEntity.ok(rechargeService.confirmRecharge(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RechargeResponse> getRechargeById(
            @PathVariable Long id) {
        return ResponseEntity.ok(rechargeService.getRechargeById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RechargeResponse>> getRechargesByUser(
            @PathVariable Long userId) {
        return ResponseEntity.ok(rechargeService.getRechargesByUser(userId));
    }
}