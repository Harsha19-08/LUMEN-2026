package com.lumen.subscription.controllers;

import com.lumen.subscription.entity.Subscription;
import com.lumen.subscription.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    // Subscribe
    @PostMapping("/new")
    public ResponseEntity<Subscription> subscribe(@RequestParam Long userId,
                                                  @RequestParam Long planId,
                                                  @RequestParam(defaultValue = "true") boolean autoRenew,
                                                  @RequestParam(defaultValue = "false") boolean trial) {
        int daysValid = trial ? 7 : 30; // trial = 7 days, normal = 30 days
//        Long plan = Long.parseLong(planId);
        return ResponseEntity.ok(subscriptionService.subscribe(userId, planId, autoRenew, trial, daysValid));
    }

    // Upgrade/Downgrade/Cancel/Renew
    @PatchMapping("/{id}")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable Long id,
                                                           @RequestParam(required = false) String planId,
                                                           @RequestParam(defaultValue = "true") boolean autoRenew,
                                                           @RequestParam(defaultValue = "false") boolean cancel) {
        return ResponseEntity.ok(subscriptionService.updateSubscription(id, planId, autoRenew, cancel));
    }

    // Get user subscriptions (status/history)
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Subscription>> getUserSubscriptions(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getUserSubscriptions(userId));
    }
}
