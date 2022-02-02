package com.example.geektrust;

import com.example.geektrust.util.InputUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainTest {

    @Mock
    InputUtil inputUtil = new InputUtil();


    Main main = new Main();

    @Test
    public void IntegrationTest() throws IOException {
//        InputUtil mock = Mockito.mock(InputUtil.class);
//        Mockito.when(mock.bufferFileFromStringInputPath(Mockito.anyString())).thenReturn(new BufferedReader(new InputStreamReader(System.in)));
        String path = new java.io.File(".").getCanonicalPath();
//        System.out.println(path);
        String [] arr = {path+"/sample_input/input1.txt"};
        Assertions.assertDoesNotThrow(()->main.main(arr));
    }

}