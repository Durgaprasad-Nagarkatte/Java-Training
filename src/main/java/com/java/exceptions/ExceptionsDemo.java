package com.java.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsDemo {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\nInside main ...");
        try {
            share();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("\nEnd of main ...");
    }

    private static void share() throws FileNotFoundException {
        System.out.println("\nInside share ...");

        try {
            String response = HttpConnect.send(3, "hello", "http://www.goodsnips.com");
            Integer responseCode = APIParser.parseSendResponseCode(response, "hello", "http://www.goodsnips.com");
            System.out.println(responseCode);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw e;
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Connecting to a different server");
        }  catch (APIFormatChangeException e){
            e.printStackTrace();
            System.out.println("Incorrect response sent");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Uncaught exception");
        } finally {
            System.out.println("Finally block was executed");
        }

        System.out.println("\nEnd of share ...");
    }

}
