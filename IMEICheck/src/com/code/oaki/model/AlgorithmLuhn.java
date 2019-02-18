/*
 * 
 */
package com.code.oaki.model;

/**
 *
 * @author Oaki Code
 */
public class AlgorithmLuhn {
    //
    
    public static boolean validateIMEI(String imei) {
        //
        boolean result = false;
        int sum = 0;
        int len = 0;
        int value_i = 0;
        int value = 0;
        len = imei.length();
        
        // System.out.print("Length: " + len);
        // System.out.println(" IMEI: " + imei);
        if(len != 15)
            return false;
        try{
        for(int i = 0; i < len; i++) {
            //value_i = Integer.parseInt(String.valueOf(imei.charAt(i))); 
            // value = calculateDigit(
            //    Integer.parseInt(String.valueOf(imei.charAt(i))),
            //        (i + 1) % 2 == 0);
            //sum += value;
            sum += calculateDigit(
                Integer.parseInt(String.valueOf(imei.charAt(i))),
                    (i + 1) % 2 == 0);
            // System.out.print("CharAt[" + i + "]: " + value_i);
            // System.out.print(" value: " + value);
            // System.out.println(" - Sum: " + sum);
        }
        // System.out.println("Sum: " + sum);
        
        if(sum % 10 == 0)
            result = true;
        } catch(Exception e) {
            //e.printStackTrace();
            return false;
        }
        
        return result;
    }
    
    /**
     * 
     * @param number
     * @param indexKey
     * @return 
     */
    public static int calculateDigit(int number, boolean  flagIndex) {
        //
        int num = 0;
        if(flagIndex) {
            num = number * 2;
            //
            while(num > 9) {
                num = Integer.parseInt(String.valueOf(
                        String.valueOf(num).charAt(0))) +
                        Integer.parseInt(String.valueOf(
                        String.valueOf(num).charAt(1)));
            }
            return num;
        } else {
            return number;
        }
    }
}
