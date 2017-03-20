package com.ilanta.moneyCalc.savings;

import java.io.File;

class FileIO {
    private static final String fileName = ".money";

    protected boolean isExists(){
        return new File(fileName).exists();
    }
}
