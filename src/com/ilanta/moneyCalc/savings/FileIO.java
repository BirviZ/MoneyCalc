package com.ilanta.moneyCalc.savings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileIO {
    private static final String fileName = ".money";

    protected static boolean isExists(){
        return new File(fileName).exists();
    }
    
    protected static String readFile() throws FileNotFoundException {
    	File file = new File(fileName);
    	Scanner sc = new Scanner(file);
    	String result = sc.nextLine();
    	sc.close();
    	return result;
    }
    
    protected static void writeFile(String str) throws IOException {
    	FileWriter fw = new FileWriter(new File(fileName), false);
    	fw.write(str);
    	fw.close();
    }
    
    protected static void deleteFile() {
    	if(isExists()) {
    		File file = new File(fileName);
    		file.delete();
    	}
    }
}
