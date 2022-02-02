package com.example.geektrust.service.impl;

import com.example.geektrust.model.Flat;
import com.example.geektrust.model.WaterBill;
import com.example.geektrust.service.WaterBillCalculaterService;

public class WaterBillCalculaterServiceImpl implements WaterBillCalculaterService {

    final int twoBHKFlat=2;
    final int threeBHKFlat=3;
    final static int monthlyBasicWaterConsumedPeMember=300;

    public WaterBill calculateWaterTotalBillAndTotalWaterConsumed(Flat flatDetails){
        int totalBill =0;
        totalBill=calculateBasicBillOnRatio(flatDetails);
        totalBill=totalBill+calculateTankerWaterBill(calculateWaterConsumedByGuests(flatDetails.getTotalGuests()));
        return WaterBill.builder().totalAmount(totalBill)
                .totalWaterConsumed(calculateTotalWaterConsumed(flatDetails))
                .build();
    }

    @Override
    public int calculateBasicBillOnRatio(Flat flatDetails) {
        final double boreWaterRatePerLire=1.5;
        int totalLitres = monthlyBasicWaterConsumedPeMember*flatDetails.getTotalFamilyMembers();
        double ratioTotal=flatDetails.getCorporationWaterRatio()+flatDetails.getBoreWellWaterRatio();
        double total=0;
        total = (totalLitres*(flatDetails.getCorporationWaterRatio()/ratioTotal))+
                (int)(boreWaterRatePerLire*(totalLitres*(flatDetails.getBoreWellWaterRatio()/ratioTotal)));
        return (int)Math.ceil(total);
    }

    @Override
    public int calculateTankerWaterBill(int litres) {
        int total=0;
        if(litres>=0&&litres<=500){
            total=litres*2;
        }
        else if(litres>=501&&litres<=1500){
            total=1000+((litres-500)*3);
        }
        else if(litres>=1501&&litres<=3000){
            total=1000+3000+((litres-1500)*5);
        }
        else if(litres>=3001){
            total=1000+3000+7500+((litres-3000)*8);
        }
        return total;
    }


    private static int calculateTotalWaterConsumed(Flat flatDetails){
        int totalWaterConsumed=flatDetails.getTotalFamilyMembers()*monthlyBasicWaterConsumedPeMember;
        totalWaterConsumed=totalWaterConsumed+calculateWaterConsumedByGuests(flatDetails.getTotalGuests());
        return totalWaterConsumed;
    }

    private static int calculateWaterConsumedByGuests(int totalGuests){
        return totalGuests*10*30;
    }
}
