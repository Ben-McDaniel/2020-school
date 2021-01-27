import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.xml.crypto.Data;


public class profile {
    
    public profile(){
    
    }

    public String getName(String path){
        String[] profile;
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            String row = csvReader.readLine();
            profile = row.split(",");
            csvReader.close();
        } catch (IOException e) {
            System.out.println("Falied to split");
            e.printStackTrace();
            profile = new String[1];
        }
        List<String> list = Arrays.asList(profile);

        List<String> coolKidList = new LinkedList<String>(Arrays.asList(profile));
        return profile[0];
    }

    public void changeMode(int newMode, String path){
        String[] profile;
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            String row = csvReader.readLine();
            profile = row.split(",");
            csvReader.close();
        } catch (IOException e) {
            System.out.println("Falied to split");
            e.printStackTrace();
            profile = new String[1];
        }
        List<String> list = Arrays.asList(profile);

        List<String> coolKidList = new LinkedList<String>(Arrays.asList(profile));
        list.set(2, Integer.toString(newMode));

        try {
            FileWriter csvWriter = new FileWriter(path);
            for(int i = 0; i < list.size(); i++){
                csvWriter.append(list.get(i));
                csvWriter.append(",");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeOrder(int newOrder, String path){
        String[] profile;
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            String row = csvReader.readLine();
            profile = row.split(",");
            csvReader.close();
        } catch (IOException e) {
            System.out.println("Falied to split");
            e.printStackTrace();
            profile = new String[1];
        }
        List<String> list = Arrays.asList(profile);

        List<String> coolKidList = new LinkedList<String>(Arrays.asList(profile));
        list.set(3, Integer.toString(newOrder));

        try {
            FileWriter csvWriter = new FileWriter(path);
            for(int i = 0; i < list.size(); i++){
                csvWriter.append(list.get(i));
                csvWriter.append(",");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateRecord(String userPath, String path, int questionNum, boolean sucess){
        boolean foundElement = false;
        String[] data = {"replace", "this", "hopefully", "pls"};
        //search each line until path matches first element
        //if no match create new line with appropriate # of cells 
        try {
            String row;
            BufferedReader csvReader = new BufferedReader(new FileReader(userPath));
            while ((row = csvReader.readLine()) != null) {
                data = row.split(",");
                if(data[0].equals(path)){
                    foundElement = true;
                    csvReader.close();
                    List<String> record = new LinkedList<String>(Arrays.asList(data));
                    break;
                    
                    
                }
            }
            csvReader.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        
        if(!foundElement){
            //create new line to store record
            //create an array then write to csv file
            String[] domain;
            try {
                BufferedReader csvReader = new BufferedReader(new FileReader(path));
                String row = csvReader.readLine();
                domain = row.split(",");
                csvReader.close();
            } catch (IOException e) {
                System.out.println("Falied to split");
                e.printStackTrace();
                domain = new String[1];
            }

            int tricky = Integer.parseInt(domain[5]);
            String[] newLine = new String[1 + tricky*2];
            newLine[0] = path;
            for(int k = 1; k < newLine.length; k++){
                newLine[k] = "0";
            }

            try {
                FileWriter csvWriter = new FileWriter(userPath, true);
                csvWriter.append("\n");
                for(int i = 0; i < newLine.length; i++){
                    csvWriter.append(newLine[i]);
                    csvWriter.append(",");
                }
                csvWriter.flush();
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //update arraylist with results
        String[] found;
        String[] nullStr = {"n", "u", "l", "l"};
        int y = 1;
        String compareTo = " ";
        try {
            
            String row;
            BufferedReader csvReader = new BufferedReader(new FileReader(userPath));
            
            while ((row = csvReader.readLine()) != null) {
                data = row.split(",");
                if(data[0].equals(path)){
                    
                    compareTo = row;
                    foundElement = true;
                    found = data;

                    List<String> u = new ArrayList<String>();
                    
                    String r;
                    BufferedReader cr = new BufferedReader(new FileReader(userPath));
                    while ((r = cr.readLine()) != null) {
                        if(!r.equals(compareTo)){
                            u.add(r);
                        }
                    }
                    System.out.println(u.toString());
                    FileWriter fwOb = new FileWriter(userPath, false);
                    PrintWriter pwOb = new PrintWriter(fwOb, false);
                    pwOb.flush();
                    pwOb.close();
                    fwOb.close();

                    FileWriter f = new FileWriter(userPath, true);
                    String[] itemsArray = new String[u.size()];
                    itemsArray = u.toArray(itemsArray);
                   
                    for(int i = 0; i < u.size(); i++){
                        f.append(itemsArray[i]);
                        f.append("\n");
                    }
                    f.flush();
                    f.close();

                    found[2 * questionNum - 1] = String.valueOf(Integer.parseInt(found[2 * questionNum - 1]) + 1);
                    if(sucess){
                        found[2 * questionNum] = String.valueOf(Integer.parseInt(found[2 * questionNum]) + 1);
                    }


                    
                    try {
            
                        FileWriter csvWriter = new FileWriter(userPath, true);
                        for(int i = 0; i < found.length; i++){
                            csvWriter.append(found[i]);
                            csvWriter.append(",");
                        }
                        csvWriter.flush();
                        csvWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }




                    csvReader.close();
                    
                    break; 
                }
                y++;
            }


            
            csvReader.close();
        } catch (Exception e) {
            //TODO: handle exception
            found = nullStr;
        } 

        
        
        

        //current error, found is always becoming nullstr
        

        
    }


  
}

//csv file
//name, password, mode123(1 all questions, 2 answer percent, 3 answer #), randomOrInOrder(1,2), 
//domainName, q1Attempts, q1Sucesses
