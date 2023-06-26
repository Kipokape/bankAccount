package com.example.bankAccountGenerator;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileDataReader {

    private final List<String> mansNames;
    private final List<String> mansSurnames;
    private final List<String> mansPatronymics;
    private final List<String> womansNames;
    private final List<String> womansSurnames;
    private final List<String> womansPatronymics;

    private final String mansNamesPath = "/NamesForBankAccounts/MansNames.txt";
    private final String mansSurnamesPath = "/NamesForBankAccounts/MansSurnames.txt";
    private final String mansPatronymicsPath = "/NamesForBankAccounts/MansPatronymics.txt";
    private final String womansNamesPath = "/NamesForBankAccounts/WomansNames.txt";
    private final String womansSurnamesPath = "/NamesForBankAccounts/WomansSurnames.txt";
    private final String womansPatronymicsPath = "/NamesForBankAccounts/WomansPatronymics.txt";

    public FileDataReader() {
        mansNames = readFromFile(mansNamesPath);
        mansSurnames = readFromFile(mansSurnamesPath);
        mansPatronymics = readFromFile(mansPatronymicsPath);
        womansNames = readFromFile(womansNamesPath);
        womansSurnames = readFromFile(womansSurnamesPath);
        womansPatronymics = readFromFile(womansPatronymicsPath);
    }

    private List<String> readFromFile(String path){
        List<String> data = new ArrayList<>();
        try {
            InputStream inputStream = getClass().getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line;
            while ((line= reader.readLine())!=null){
                data.add(line);
            }
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }



}
