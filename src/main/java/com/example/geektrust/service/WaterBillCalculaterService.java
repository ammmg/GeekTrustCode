package com.example.geektrust.service;

import com.example.geektrust.model.Flat;
import com.example.geektrust.model.WaterBill;

public interface WaterBillCalculaterService {

    public WaterBill calculateWaterTotalBillAndTotalWaterConsumed(Flat flatDetails);

    public int calculateBasicBillOnRatio(Flat flatDetails);

    public int calculateTankerWaterBill(int litres);
}
