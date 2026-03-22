package com.omincharge.operator.controller;

import com.omincharge.operator.dto.*;
import com.omincharge.operator.service.OperatorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operators")
public class OperatorController {

    private final OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    // ── Operator Endpoints ────────────────────────────

    @GetMapping
    public ResponseEntity<List<OperatorResponse>> getAllOperators() {
        return ResponseEntity.ok(operatorService.getAllOperators());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperatorResponse> getOperatorById(
            @PathVariable Long id) {
        return ResponseEntity.ok(operatorService.getOperatorById(id));
    }

    @PostMapping
    public ResponseEntity<OperatorResponse> createOperator(
            @Valid @RequestBody OperatorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(operatorService.createOperator(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OperatorResponse> updateOperator(
            @PathVariable Long id,
            @Valid @RequestBody OperatorRequest request) {
        return ResponseEntity.ok(operatorService.updateOperator(id, request));
    }

    // ── Plan Endpoints ────────────────────────────────

    @GetMapping("/{id}/plans")
    public ResponseEntity<List<PlanResponse>> getPlansByOperator(
            @PathVariable Long id) {
        return ResponseEntity.ok(operatorService.getPlansByOperator(id));
    }

    @GetMapping("/plans/{planId}")
    public ResponseEntity<PlanResponse> getPlanById(
            @PathVariable Long planId) {
        return ResponseEntity.ok(operatorService.getPlanById(planId));
    }

    @PostMapping("/{id}/plans")
    public ResponseEntity<PlanResponse> createPlan(
            @PathVariable Long id,
            @Valid @RequestBody PlanRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(operatorService.createPlan(id, request));
    }
}