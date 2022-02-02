package com.example.geektrust.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Flat {

    private int corporationWaterRatio;
    private int boreWellWaterRatio;
    private int flatType;
    private int totalFamilyMembers;
    private int totalGuests;

}
