package com.java.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpConnect {
    /**
     *
     * @param destination
     * @param data
     * @param partner
     * @throws IllegalArgumentException when destination < 0 && destination > 2
     */

    public static String send(int destination, String data, String partner) throws Exception {
        System.out.println("\nInside send ...");
        String response = "success";

        if(destination < 0 || destination > 4){
            throw new IllegalArgumentException("Invalid destination id passed");
        }
        if (destination == 0){
            throw new FileNotFoundException("File not found");
        } else if(destination == 1){
            throw new IOException("Not able to connect to the partner server");
        } else if (destination == 2) {
            throw new Exception("Uncaught exception");
        } else if (destination == 3){
            response = "<result><code>success</code></result>";
            System.out.println("Program executed successfully");
        }
        System.out.println("\nEnd of send ...");
        return response;
    }
}
