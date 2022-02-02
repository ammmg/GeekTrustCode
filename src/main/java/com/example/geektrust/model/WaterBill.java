package com.example.geektrust.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WaterBill {

    private int totalWaterConsumed;
    private int totalAmount;
}
