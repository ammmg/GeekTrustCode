package com.example.geektrust;
import com.example.geektrust.model.Flat;
import com.example.geektrust.model.WaterBill;
import com.example.geektrust.service.WaterBillCalculaterService;
import com.example.geektrust.service.impl.WaterBillCalculaterServiceImpl;
import com.example.geektrust.util.InputUtil;

import java.io.BufferedReader;
import java.io.IOException;
public class Main {

    final static String ALLOT_WATER = "ALLOT_WATER";
    final static String ADD_GUESTS = "ADD_GUESTS";
    final static String BILL="BILL";
    final static String EMPTY=" ";

    static InputUtil inputUtil = new InputUtil();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = inputUtil.bufferFileFromStringInputPath(args[0]);
        String currentLine= reader.readLine();
        WaterBillCalculaterService waterBillCalculaterService = new WaterBillCalculaterServiceImpl();
        Flat flatDetails=null;
        while(currentLine!=null&&!currentLine.isEmpty()){
            if(currentLine.contains(ALLOT_WATER)){
                if(inputUtil.validateFlatDetailsInput(currentLine)){
                    flatDetails=inputUtil.mapFlatDetails(currentLine);
                }
            }
            else if(currentLine.contains(ADD_GUESTS)){
                flatDetails.setTotalGuests(flatDetails.getTotalGuests()+Integer.parseInt(currentLine.split( EMPTY)[1]));
            }
            else if(currentLine.equals(BILL)){
                WaterBill waterBill = waterBillCalculaterService.calculateWaterTotalBillAndTotalWaterConsumed(flatDetails);
                System.out.println(waterBill.getTotalWaterConsumed()+" "+waterBill.getTotalAmount());
                reader.close();
                break;
            }
            currentLine= reader.readLine();
        }
        reader.close();
	}


}