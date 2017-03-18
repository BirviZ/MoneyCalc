package com.ilanta.moneyCalc.savings;

public class Save {
    private static final String fileName = ".money";

    public static void write(int[] values) {

    }

    public static int[] read() {
        int[] v = new int[9];

        for(int i = 0; i < 9; i++) {
            v[i] = 10;
        }

        return v;
    }
}
