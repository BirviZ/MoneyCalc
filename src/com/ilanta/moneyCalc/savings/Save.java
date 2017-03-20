package com.ilanta.moneyCalc.savings;

import java.io.FileNotFoundException;

public class Save extends FileIO {

    public static void write(int[] values) {
        for(int i: values)
        System.out.print(i + ",");
    }

    public static int[] read() {
        if(isExists()) {
        	String str;
        	try {
				str = readFile();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return zero();
			}
        	
        	String[] array = str.split(",");
        	int[] result = new int[array.length];
        	for(int i = 0; i < array.length; i++) {
        		try {
        			result[i] = Integer.valueOf(array[i]);
        		} catch (NumberFormatException e) {
					result[i] = 0;
				}
        	}
        	return result;
        } else {
        	return zero();
        }
    }

    public static void delete() {

    }
    
    private static int[] zero() {
    	int[] v = new int[9];

        for(int i = 0; i < 9; i++) {
            v[i] = 0;
        }

        return v;
    }
}
