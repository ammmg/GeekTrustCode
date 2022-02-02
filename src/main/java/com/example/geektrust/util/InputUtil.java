package com.example.geektrust.util;

import com.example.geektrust.model.Flat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class InputUtil {

    private final String RATIO=":";
    private final String EMPTY=" ";
    private final int twoBHK = 2;
    private final int threeBHK = 3;

    public int getFlatTypeFromInput(String inputString){
        return Integer.parseInt(inputString.charAt(12)+"");
    }

    public int getCorporationWaterRatio(String inputString){
        return Integer.parseInt( inputString.split(EMPTY)[2]
                .split(RATIO)[0]);
    }

    public int getBoreWellWaterRatio(String inputString) {
        return Integer.parseInt( inputString.split(EMPTY)[2]
                .split(RATIO)[1]);
    }

    public int getTotalFamilyMembersFromFlatType(int flatType){
        if(flatType==twoBHK){
            return 3;
        }
        else if(flatType==threeBHK){
            return 5;
        }
        return 0;
    }

    public BufferedReader bufferFileFromStringInputPath(final String filePath) throws FileNotFoundException {
       return new BufferedReader(new FileReader(filePath));
    }

    public Flat mapFlatDetails(String inputString){
        int flatType=getFlatTypeFromInput(inputString);
        return Flat.builder()
                .flatType(flatType)
                .corporationWaterRatio(getCorporationWaterRatio(inputString))
                .totalFamilyMembers(getTotalFamilyMembersFromFlatType(flatType))
                .boreWellWaterRatio(getBoreWellWaterRatio(inputString))
                .build();

    }

    public boolean validateFlatDetailsInput(String inputLine){
        String[] inputArr=inputLine.split(EMPTY);
        final int ratioPosition=2;
        final int standardInputParts=3;
        if(inputArr.length==standardInputParts&&inputArr[ratioPosition].contains(RATIO)){
            return true;
        }
        return false;
    }



}
