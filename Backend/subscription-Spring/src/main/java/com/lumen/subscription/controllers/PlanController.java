package com.lumen.subscription.controllers;
import com.lumen.subscription.entity.Plan;
import com.lumen.subscription.service.PlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping("/create-plan")
    public ResponseEntity<Plan> createPlan(@RequestBody Plan plan) {
        return ResponseEntity.ok(planService.createPlan(plan));
    }

    @GetMapping("/get-all-plans")
    public ResponseEntity<List<Plan>> getAllPlans() {
        return ResponseEntity.ok(planService.getAllPlans());
    }

    @GetMapping("/get-plan/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(planService.getPlanById(id));
    }

    @PutMapping("/update-plan/{id}")
    public ResponseEntity<Plan> updatePlan(@PathVariable Long id, @RequestBody Plan updatedPlan) {
        return ResponseEntity.ok(planService.updatePlan(id, updatedPlan));
    }

    @DeleteMapping("/delete-plan/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}
