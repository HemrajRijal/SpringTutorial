package com.hemraj.demo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author: hemraj
 * Date:  1/30/18.
 */
@Component
public class FileFortuneService implements FortuneService {
    private String fileName = "src/com/hemraj/demo/fortune-data.txt";
    private List<String> theFortune;

    private Random myRandom = new Random();


    public FileFortuneService() {
        System.out.println("On Default constructor");
    }

    @Override
    public String getDailyFortune() {
        int index = myRandom.nextInt(theFortune.size());

        return theFortune.get(index);
    }

    @PostConstruct
    public void readFile() {
        File theFile = new File(fileName);
        System.out.println("Reading file from function:--->" + fileName);
        System.out.println("File exist-->" + theFile);


//        initialize the array
        theFortune = new ArrayList<>();

//        read fortune from file
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(theFile));
            String tempLine = null;

            while ((tempLine = bufferedReader.readLine()) != null) {
                theFortune.add(tempLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
