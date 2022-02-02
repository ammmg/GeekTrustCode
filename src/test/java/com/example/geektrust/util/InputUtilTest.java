package com.example.geektrust.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputUtilTest {

    InputUtil inputUtil = new InputUtil();

    @Test
    public void testGetFlatType(){
        Assertions.assertEquals(2,inputUtil.getFlatTypeFromInput("ALLOT_WATER 2 3:7"));
    }

    @Test
    public void testGetCorporationWaterRatio(){
        Assertions.assertEquals(3,inputUtil.getCorporationWaterRatio("ALLOT_WATER 2 3:7"));
    }

    @Test
    public void testGetBoreWellWaterRatio(){
        Assertions.assertEquals(7,inputUtil.getBoreWellWaterRatio("ALLOT_WATER 2 3:7"));
    }

    @Test
    public void testValidateFlatDetailsInput(){
        Assertions.assertTrue(inputUtil.validateFlatDetailsInput("ALLOT_WATER 2 3:7"));
    }

    @Test
    public void testValidateFlatDetailsInvalidInput(){
        Assertions.assertFalse(inputUtil.validateFlatDetailsInput("ALLOT_WATER 2 37"));
    }
}
