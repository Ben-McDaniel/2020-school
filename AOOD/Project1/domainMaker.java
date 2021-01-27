import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class domainMaker {
    private final String ANSI_CLS = "\033[2J";
    public void clear() {
        System.out.println(ANSI_CLS);
    }


    Scanner input = new Scanner(System.in);
    public domainMaker() {

    }

    public void newDomain(String user) {
        String username = user.substring(0, user.length() - 3);
        String pas = "0000";
        int pass = 0;
        String filename;
        // new domain creates a domain in a way that exportDomain is not needed
        clear();
        System.out.print("Enter Title of domain: ");
        String name = input.next();
        clear();
        System.out.println("1) Public, anyone can access");
        System.out.println("2) Private, only you can see this");
        int publicOrPrivate = input.nextInt();
        clear();
        System.out.println("Would you like a password (y/n)");
        String pa = input.next();
        if(pa.charAt(0) == 'Y' || pa.charAt(0) == 'y'){
            pass = 1;
            clear();
            System.out.print("Enter password for domain: ");
            pas = input.next();
        }else{
            pass = 0;
        }

        filename = name + ".csv";
        System.out.println(filename);
        try {
            File newDom = new File(filename);
            FileWriter csvWriter = new FileWriter(filename, true);
            csvWriter.append(name + ",");
            csvWriter.append(username + ",");
            csvWriter.append(publicOrPrivate + ",");
            csvWriter.append(pass + ",");
            csvWriter.append(pas + ",");
            csvWriter.append("0,");
            csvWriter.flush();
            csvWriter.close();
            importDomain(filename);
            editDomain(filename);
        } catch (Exception e) {
            System.out.println("Failed to make new file");
        }

    }

    public void importDomain(String path) {
        try {
            File csvFile = new File(path);
            if (csvFile.isFile()) {
                FileWriter csvWriter = new FileWriter("domainList.csv", true);
                csvWriter.append(path + ",");
                csvWriter.flush();
                csvWriter.close();
            } else {
                System.out.println("Path could not be found");
            }
        } catch (Exception e) {
            System.out.println("Path could not be found");
        }
    }

    public void deleteDomain(String path) throws IOException {
        File csvFile = new File(path);
        if (csvFile.isFile()) {
            StringBuilder str = new StringBuilder(path);
            str.append(",");
            String[] data;
            ArrayList<String> fixed = new ArrayList<String>();
            // split into array, delete item that matches path, put array back into csv
            try {
                BufferedReader csvReader = new BufferedReader(new FileReader("domainList.csv"));
                String row = csvReader.readLine();
                data = row.split(",");
                csvReader.close();
            } catch (IOException e) {
                System.out.println("Falied to split domainList.csv");
                e.printStackTrace();
                data = new String[1];
            }
            
            for(int i = 0; i < data.length; i++) {
                if(!data[i].equals(path)){
                    fixed.add(data[i]);
                }
            }

            //delete all info from domainList
            new FileWriter("domainList.csv", false).close();

            try {
                FileWriter csvWriter = new FileWriter("domainList.csv");
                for(int i = 0; i < fixed.size(); i++){
                    csvWriter.append(fixed.get(i));
                    csvWriter.append(",");
                }
                csvWriter.flush();
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //delete file
            File fileDel = new File(path); 
            if (fileDel.delete()) { 
                System.out.println("Deleted the file: " + fileDel.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
        }else{
            System.out.println("Path could not be found");
        }
        
    }

    public void editDomain(String domainName){
        while(true){
            String[] domain;
            try {
                BufferedReader csvReader = new BufferedReader(new FileReader(domainName));
                String row = csvReader.readLine();
                domain = row.split(",");
                csvReader.close();
            } catch (IOException e) {
                System.out.println("Falied to split");
                e.printStackTrace();
                domain = new String[1];
            }
            List<String> list = Arrays.asList(domain);

            List<String> coolKidList = new LinkedList<String>(Arrays.asList(domain));

            printDomain(domainName);
            System.out.println();
            System.out.println("A) Change domain name");
            System.out.println("B) Edit a question");
            System.out.println("C) Add new question");
            System.out.println("D) Delete a question");
            System.out.println("E) Exit");

            char choice = input.next().charAt(0);

            if(choice == 'A' || choice == 'a'){
                clear();
                System.out.println("Current name: " + domain[0]);
                System.out.print("Enter new name without spaces: ");
                String newName = input.next();

                System.out.println();
                System.out.println("Is this correct? " + newName + "(y/n)");
                String pa = input.next();
                if(pa.charAt(0) == 'Y' || pa.charAt(0) == 'y'){
                    list.set(0, newName);
                
                    try {
                        FileWriter csvWriter = new FileWriter(domainName);
                        for(int i = 0; i < list.size(); i++){
                            csvWriter.append(list.get(i));
                            csvWriter.append(",");
                        }
                        csvWriter.flush();
                        csvWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    clear();
                    System.out.println("Domain name was not changed");
                }
            }else if(choice == 'B' || choice == 'b'){
                clear();
                printDomain(domainName);
                System.out.print("Which question do you want to change: ");
                int nChoice = input.nextInt();
                editQuestion(domainName, nChoice);
            }else if(choice == 'C' || choice == 'c'){
                clear();
                System.out.print("Enter the question you want to add without spaces: ");
                String nQ = input.next();
                System.out.print("Enter the answer you want to add without spaces: ");
                String nA = input.next();
                System.out.println();
                
                System.out.println("Is This correct " + nQ  + " : " + nA + "(Y/N)");
                String pa = input.next();
                if(pa.charAt(0) == 'Y' || pa.charAt(0) == 'y'){
                    coolKidList.add((String)nQ);
                    coolKidList.add((String)nA);
                    coolKidList.set(5, coolKidList.get(5) + 1);
                    try {
                        FileWriter csvWriter = new FileWriter(domainName);
                        for(int i = 0; i < coolKidList.size(); i++){
                            csvWriter.append(coolKidList.get(i));
                            csvWriter.append(",");
                        }
                        csvWriter.flush();
                        csvWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    clear();
                    System.out.println("Domain name was not changed");
                }

            }else if(choice == 'D' || choice == 'd'){
                clear();
                printDomain(domainName);
                System.out.println("Which question do you want to delete: ");
                int nChoice = input.nextInt();
                
                System.out.println("You want to delete " + domain[4 + (2*nChoice)] + " : " + domain[5 + (2*nChoice)] + "(Y/N)");
                String pa = input.next();
                if(pa.charAt(0) == 'Y' || pa.charAt(0) == 'y'){
                    coolKidList.remove(4 + (2*nChoice));
                    coolKidList.remove(4 + (2*nChoice));

                    try {
                        FileWriter csvWriter = new FileWriter(domainName);
                        for(int i = 0; i < coolKidList.size(); i++){
                            csvWriter.append(coolKidList.get(i));
                            csvWriter.append(",");
                        }
                        csvWriter.flush();
                        csvWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    clear();
                    System.out.println("Domain name was not changed");
                }
            }else if(choice == 'E' || choice == 'e'){
                clear();
                break;
            }else{
                System.out.println("Invalid input");
            }
        }
    }


    public void editQuestion(String domainName, int questionNum){
        String[] domain;
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(domainName));
            String row = csvReader.readLine();
            domain = row.split(",");
            csvReader.close();
        } catch (IOException e) {
            System.out.println("Falied to split domainList.csv");
            e.printStackTrace();
            domain = new String[1];
        }
        List<String> list = Arrays.asList(domain); 
        int numQuestions = Integer.parseInt(domain[5]) * 2;
        //questions start on 6
        int qPos = 4 + (2 * questionNum);
        while(true){
            System.out.println("1) Edit Question");
            System.out.println("2) Edit Answer");
            System.out.println("3) Exit");
            System.out.print("Select Option: ");
            int selection = input.nextInt();

            if(selection == 1){
                System.out.println("Current Question: " + domain[qPos]);
                System.out.print("Enter the new question without spaces: ");
                String newQ = input.next();
                System.out.println();
                System.out.println("Is this correct? " + newQ + "(y/n)");
                String pa = input.next();
                if(pa.charAt(0) == 'Y' || pa.charAt(0) == 'y'){
                    list.set(qPos, newQ);

                    try {
                        FileWriter csvWriter = new FileWriter(domainName);
                        for(int i = 0; i < list.size(); i++){
                            csvWriter.append(list.get(i));
                            csvWriter.append(",");
                        }
                        csvWriter.flush();
                        csvWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    clear();
                    System.out.println("Question was not changed");
                }
            }else if(selection == 2){
                System.out.println("Current Answer: " + domain[qPos + 1]);
                System.out.print("Enter the new Answer without spaces: ");
                String newQ = input.next();
                System.out.println();
                System.out.println("Is this correct? " + newQ + "(y/n)");
                String pa = input.next();
                if(pa.charAt(0) == 'Y' || pa.charAt(0) == 'y'){
                    list.set(qPos + 1, newQ);

                    try {
                        FileWriter csvWriter = new FileWriter(domainName);
                        for(int i = 0; i < list.size(); i++){
                            csvWriter.append(list.get(i));
                            csvWriter.append(",");
                        }
                        csvWriter.flush();
                        csvWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    clear();
                    System.out.println("Answer was not changed");
                }
            }else if(selection == 3){
                clear();
                break;
            }else{
                System.out.println("Input not valid");
            }
            System.out.println();
        }
    }

    public void printDomain(String path){
        int n = 1;
        String[] domain;
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            String row = csvReader.readLine();
            domain = row.split(",");
            csvReader.close();
        } catch (IOException e) {
            System.out.println("Falied to split domainList.csv");
            e.printStackTrace();
            domain = new String[1];
        }
        System.out.println("Question : Answer");
        System.out.println();
        for(int i = 6; i < domain.length; i = i + 2){
            System.out.println(n + ") " + domain[i] + " : " + domain[i + 1]);
            n++;
        }
    }

    public void detachDomain(String path, String playerPath){
        String[] domain;
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("domainList.csv"));
            String row = csvReader.readLine();
            domain = row.split(",");
            csvReader.close();
        } catch (IOException e) {
            System.out.println("Falied to split");
            e.printStackTrace();
            domain = new String[1];
        }
        List<String> list = Arrays.asList(domain);

        List<String> coolKidList = new LinkedList<String>(Arrays.asList(domain));
        for(int i = 0; i < domain.length; i++){
            if(domain[i].equals(path)){
                coolKidList.remove(i);
                break;
            }
        }
        try {
            FileWriter csvWriter = new FileWriter("domainList.csv");
            for(int i = 0; i < coolKidList.size(); i++){
                csvWriter.append(coolKidList.get(i));
                csvWriter.append(",");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //remove from player data
        boolean stored = false;
        String domain2 = "";
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(playerPath));
            int lines = 0;
            while(csvReader.readLine() != null){
                lines++;
            }
            for (int i = 0; i < lines; i++) {
                String[] data = domain2.split(",");
                if(data[0].equals(path)){
                    
                }else{
                    List<String> list2 = Arrays.asList(data);
                    try {
                        FileWriter csvWriter = new FileWriter(playerPath, true);
                        BufferedWriter out = new BufferedWriter(csvWriter);
                        out.newLine();
                        for(int j = 0; j < list2.size(); j++){
                            out.append(list2.get(j));
                            out.append(",");
                        }
                        
                        csvWriter.flush();
                        out.close();
                        csvWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            csvReader.close();
        } catch (IOException e) {
            System.out.println("Falied to split");
            e.printStackTrace();
            domain2 = "";
        }
        List<String> list2 = Arrays.asList(domain);

        List<String> coolKidList2 = new LinkedList<String>(Arrays.asList(domain2));

        String pN = path.substring(0, path.length() - 3);

        for(int i = 0; i < coolKidList2.size(); i++){
            if(list2.equals(pN)){
                coolKidList.remove(i);
            }
        }

        try {
            FileWriter csvWriter = new FileWriter("domainList.csv");
            for(int i = 0; i < list.size(); i++){
                csvWriter.append(coolKidList2.get(i));
                csvWriter.append(",");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

//csv file
//subject, userCreated, publicOrNot(1,2), password true/false, password(0000 if false), numQuestions, question1, question1Answer...