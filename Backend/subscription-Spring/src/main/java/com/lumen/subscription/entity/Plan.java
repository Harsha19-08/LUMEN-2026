package com.lumen.subscription.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Document(collection = "plans")
@Data
@AllArgsConstructor
public class Plan {

    @Id
    private Long id; // MongoDB uses String/ObjectId

    private String name;
    private BigDecimal price;
    private Integer quotas;
    private boolean autoRenew;
    private boolean active;

    // Constructors
    public Plan() {}
    public Plan(String name, BigDecimal price, Integer quotas, boolean autoRenew, boolean active) {
        this.name = name;
        this.price = price;
        this.quotas = quotas;
        this.autoRenew = autoRenew;
        this.active = active;
    }

    // Getters and Setters
    // ...
}

