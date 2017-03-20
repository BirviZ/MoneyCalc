package com.ilanta.moneyCalc.savings;

public class Save extends FileIO {

    public static void write(int[] values) {
        for(int i: values)
        System.out.print(i + ",");
    }

    public static int[] read() {
        int[] v = new int[9];

        for(int i = 0; i < 9; i++) {
            v[i] = (int)(Math.random()*100);
        }

        return v;
    }

    public static void delete() {

    }
}
