package com.example.geektrust.service.impl;


import com.example.geektrust.model.Flat;
import com.example.geektrust.model.WaterBill;
import com.example.geektrust.service.WaterBillCalculaterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WaterBillCalculaterServiceImplTest {

    WaterBillCalculaterService waterBillCalculaterService = new WaterBillCalculaterServiceImpl();

    @Test
    public void testCalculateBasicBillOnRatioWrongFlatType(){

        Assertions.assertEquals(0,waterBillCalculaterService.calculateBasicBillOnRatio(
                Flat.builder().flatType(10).corporationWaterRatio(1).boreWellWaterRatio(1).build()));
    }

    @Test
    public void testCalculateBasicBillOnRatioOn2BHK(){
        Assertions.assertEquals(1125,waterBillCalculaterService.calculateBasicBillOnRatio(
                Flat.builder().flatType(2).totalFamilyMembers(3).corporationWaterRatio(1).boreWellWaterRatio(1).build()));
    }

    @Test
    public void testCalculateBasicBillOnRatioOn3BHK(){
        Assertions.assertEquals(1875,waterBillCalculaterService.calculateBasicBillOnRatio(
                Flat.builder().flatType(3).totalFamilyMembers(5).corporationWaterRatio(1).boreWellWaterRatio(1).build()));
    }

    @Test
    public void calculateTankerWaterBillUnder500Ltrs(){
        Assertions.assertEquals(800,waterBillCalculaterService.calculateTankerWaterBill(400));
    }

    @Test
    public void calculateTankerWaterBillOn500Ltrs(){
        Assertions.assertEquals(1000,waterBillCalculaterService.calculateTankerWaterBill(500));
    }

    @Test
    public void calculateTankerWaterBillOn1500Ltrs(){
        Assertions.assertEquals(4000,waterBillCalculaterService.calculateTankerWaterBill(1500));
    }

    @Test
    public void calculateTankerWaterBillUnder3000Ltrs(){
        Assertions.assertEquals(4005,waterBillCalculaterService.calculateTankerWaterBill(1501));
    }

    @Test
    public void calculateTankerWaterBillOver3000Ltrs(){
        Assertions.assertEquals(11508,waterBillCalculaterService.calculateTankerWaterBill(3001));
    }

    @Test
    public void integrationTest(){
        WaterBill waterBill = waterBillCalculaterService.calculateWaterTotalBillAndTotalWaterConsumed(Flat.builder().flatType(2)
                .corporationWaterRatio(1).boreWellWaterRatio(2).totalFamilyMembers(3).build());
        Assertions.assertEquals(900,waterBill.getTotalWaterConsumed());
        Assertions.assertEquals(1200,waterBill.getTotalAmount());
    }
}
