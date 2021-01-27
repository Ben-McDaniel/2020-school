import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class quizAid {
    public static void main(String[] args) throws IOException {
        Random rand = new Random();
        String player = "ben.csv";
        domainMaker dm = new domainMaker();
        profile pf = new profile();
        int choice = 1;

        Scanner input = new Scanner(System.in);

        

        do {
            
            
            System.out.println("1) Edit Profile");
            System.out.println("2) Change Profile");
            System.out.println("3) Select or Edit Domain");
            System.out.println("4) Create New Domain");
            System.out.println("5) Import New Domain");
            System.out.println("6) Detach Domain");
            System.out.println("7) Exit Program");
            System.out.println();
            System.out.print("Enter Selection: ");
            choice = input.nextInt();

            System.out.println("\u000C");


            if(choice == 1){
                System.out.println("What would you like to change");
                System.out.println("1) Change Mode");
                System.out.println("2) Change Question Order");
                System.out.print("Enter Selection: ");
                int c1 = input.nextInt();

                if(c1 == 1){
                    System.out.println("\u000C");
                    System.out.println("Which Mode do You Want, 1) All Questions, 2) Questions you have less than 50% accurcy with, 3) Questions you have never answered correctly");
                    int c1a = input.nextInt();
                    if(c1a < 4 && c1a > 0){
                        pf.changeMode(c1a, player);
                    }else {
                        System.out.println("Invalid Selection");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    }
                }else if(c1 == 2){
                    System.out.println("\u000C");
                    System.out.println("Would you like the questions 1) in the order they are listed, or 2) in a random order");
                    int c1b = input.nextInt();

                    if(c1b < 4 && c1b > 0){
                        pf.changeOrder(c1b, player);
                    }else {
                        System.out.println("Invalid Selection");
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    }
                }else{
                    System.out.println("Invalid Selection");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                }
            }else if(choice == 2){
                //change profile
                String[] profile;
                try {
                    BufferedReader csvReader = new BufferedReader(new FileReader("profileList.csv"));
                    String row = csvReader.readLine();
                    profile = row.split(",");
                    csvReader.close();
                } catch (IOException e) {
                    System.out.println("Falied to split");
                    e.printStackTrace();
                    profile = new String[1];
                }

                for(int i = 0; i < profile.length; i++){
                    String pN = profile[i].substring(0, profile[i].length() - 4);
                    System.out.println((i+1) + ") " + pN);
                }
                System.out.println();
                System.out.print("Which Profile do you want to use: ");
                int c2a = input.nextInt();

                String[] newP;
                try {
                    BufferedReader csvReader = new BufferedReader(new FileReader(profile[c2a-1]));
                    String row = csvReader.readLine();
                    newP = row.split(",");
                    csvReader.close();
                } catch (IOException e) {
                    System.out.println("Falied to split");
                    e.printStackTrace();
                    newP = new String[2];
                }

                System.out.println("\u000C");
                System.out.print("Enter Password: ");
                String pw = input.next();
                if(pw.equals(newP[1])){
                    System.out.println("PROFILE CHANGED");
                    player = profile[c2a-1];
                }else{
                    System.out.println("Incorrect Password, Profile not Changed");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                }
            }else if(choice == 3){
                //select or edit domain
                System.out.println("\u000C");
                System.out.println("1) Edit Domain");
                System.out.println("2) Select Domain to Study");
                System.out.print("Enter Choice: ");
                int p3 = input.nextInt();

                if(p3 == 1){
                    //lists avalible domains and has user select one
                    ArrayList<String> dcv1 = (domainsCanView(player));
                    System.out.println("\u000C");
                    for(int i = 0; i < dcv1.size(); i++){
                        System.out.println(i+1 + ") " + dcv1.get(i).substring(0, dcv1.get(i).length() - 4));
                    }

                    System.out.print("Which Domain do you want to Edit: ");
                    int c3a = input.nextInt();

                    if(c3a < dcv1.size()){
                        dm.editDomain(dcv1.get(c3a));
                    }else{
                        System.out.println("\u000C");
                        System.out.println("Invalid Choice");
                    }

                }else if(p3 == 2){
                    //lists avalible domains and has user select one
                    ArrayList<String> dcv2 = (domainsCanView(player));

                    System.out.println("\u000C");
                    for(int i = 0; i < dcv2.size(); i++){
                        System.out.println(i+1 + ") " + dcv2.get(i).substring(0, dcv2.get(i).length() - 4));
                    }

                    System.out.print("Which Domain do you want to Study: ");
                    int c3b = input.nextInt() - 1;

                    if(c3b < dcv2.size()){
                        //go through domain here
                        
                        //go through profile conditions
                        //print record then question with enter any key to show answer
                        //ask if correct then use updaterecord method

                        String[] profile;
                        try {
                            BufferedReader csvReader = new BufferedReader(new FileReader(player));
                            String row = csvReader.readLine();
                            profile = row.split(",");
                            csvReader.close();
                        } catch (IOException e) {
                            System.out.println("Falied to split");
                            e.printStackTrace();
                            profile = new String[1];
                        }

                        String[] domain;
                        try {
                            BufferedReader csvReader = new BufferedReader(new FileReader(dcv2.get(c3b)));
                            String row = csvReader.readLine();
                            domain = row.split(",");
                            csvReader.close();
                        } catch (IOException e) {
                            System.out.println("Falied to split");
                            e.printStackTrace();
                            domain = new String[1];
                        }

                        //get record for specific domain
                        String[] record;
                        try {
                            String uP = "";
                            String row;
                            BufferedReader csvReader = new BufferedReader(new FileReader(player));
                            while ((row = csvReader.readLine()) != null) {
                                record = row.split(",");
                                if(record[0].equals(dcv2.get(c3b))){
                                    if(domain[3].equals("true")){
                                        System.out.println("\u000C");
                                        System.out.print("Enter Password for Domain: ");
                                        uP = input.next();
                                        System.out.println("\u000C");
                                        System.out.println("\u000C");
                                    }
                                    if(uP.equals(domain[4]) || domain[3].equals("false")){
                                        //goes through questions start with order then check if each question meets mode req
                                        if(Integer.parseInt(profile[3]) == 1){
                                            //in order
                                            for (int i = 0; i < Integer.parseInt(domain[5]); i++){
                                                if(Integer.parseInt(profile[2]) == 1){
                                                    //6 + i*2
                                                    System.out.println("\u000C");
                                                    System.out.println("\u000C");
                                                    System.out.println("Record " + record[1 + i*2] + "/" + record[2+ i*2]);
                                                    System.out.println();
                                                    System.out.println("Question: " + domain[6 + 2*i]);
                                                    System.out.println("Enter anything to continue");
                                                    String asdf = input.next();
                                                    System.out.println("Answer: " + domain[7 + 2*i]);
                                                    System.out.println("Did you get it correct(Y/N) ");
                                                    char sel = input.next().charAt(0);
                                                    if(sel == 'y' || sel == 'Y'){
                                                        pf.updateRecord(player, dcv2.get(c3b), i+1, true);
                                                    }else{
                                                        pf.updateRecord(player, dcv2.get(c3b), i+1, false);
                                                    }
                                                }else if(Integer.parseInt(profile[2]) == 2){
                                                    //if less than 50% accuracy
                                                    if((Integer.parseInt(record[1 + i*2]) / Integer.parseInt(record[2+ i*2])) < .5){
                                                        System.out.println("\u000C");
                                                        System.out.println("\u000C");
                                                        System.out.println("Record " + record[1 + i*2] + "/" + record[2+ i*2]);
                                                        System.out.println();
                                                        System.out.println("Question: " + domain[6 + 2*i]);
                                                        System.out.println("Enter anything to continue");
                                                        String asdf = input.next();
                                                        System.out.println("Answer: " + domain[7 + 2*i]);
                                                        System.out.println("Did you get it correct(Y/N) ");
                                                        char sel = input.next().charAt(0);
                                                        if(sel == 'y' || sel == 'Y'){
                                                            pf.updateRecord(player, dcv2.get(c3b), i+1, true);
                                                        }else{
                                                            pf.updateRecord(player, dcv2.get(c3b), i+1, false);
                                                        }
                                                    }
                                                }else if(Integer.parseInt(profile[2]) == 3){
                                                    //questions with 0 correct answers
                                                    if((Integer.parseInt(record[2 + i*2]) == 0)){
                                                        System.out.println("\u000C");
                                                        System.out.println("\u000C");
                                                        System.out.println("Record " + record[1 + i*2] + "/" + record[2+ i*2]);
                                                        System.out.println();
                                                        System.out.println("Question: " + domain[6 + 2*i]);
                                                        System.out.println("Enter anything to continue");
                                                        String asdf = input.next();
                                                        System.out.println("Answer: " + domain[7 + 2*i]);
                                                        System.out.println("Did you get it correct(Y/N) ");
                                                        char sel = input.next().charAt(0);
                                                        if(sel == 'y' || sel == 'Y'){
                                                            pf.updateRecord(player, dcv2.get(c3b), i+1, true);
                                                        }else{
                                                            pf.updateRecord(player, dcv2.get(c3b), i+1, false);
                                                        }
                                                    }
                                                }
                                            }
                                        }else{
                                            //random order
                                            System.out.print("How many questions do you want to be asked: ");
                                            int tnq = input.nextInt();
        
                                            for (int i = 0; i < tnq; i++){
                                                int q = rand.nextInt(Integer.parseInt(domain[5]));
                                                if(Integer.parseInt(profile[2]) == 1){
                                                    //6 + i*2
                                                    System.out.println("\u000C");
                                                    System.out.println("\u000C");
                                                    System.out.println("Record " + record[1 + q*2] + "/" + record[2+ q*2]);
                                                    System.out.println();
                                                    System.out.println("Question: " + domain[6 + 2*q]);
                                                    System.out.println("Enter anything to continue");
                                                    String asdf = input.next();
                                                    System.out.println("Answer: " + domain[7 + 2*q]);
                                                    System.out.println("Did you get it correct(Y/N) ");
                                                    char sel = input.next().charAt(0);
                                                    if(sel == 'y' || sel == 'Y'){
                                                        pf.updateRecord(player, dcv2.get(c3b), q+1, true);
                                                    }else{
                                                        pf.updateRecord(player, dcv2.get(c3b), q+1, false);
                                                    }
                                                }else if(Integer.parseInt(profile[2]) == 2){
                                                    //if less than 50% accuracy
                                                    if((Integer.parseInt(record[1 + q*2]) / Integer.parseInt(record[2+ q*2])) < .5){
                                                        System.out.println("\u000C");
                                                        System.out.println("\u000C");
                                                        System.out.println("Record " + record[1 + q*2] + "/" + record[2+ q*2]);
                                                        System.out.println();
                                                        System.out.println("Question: " + domain[6 + 2*q]);
                                                        System.out.println("Enter anything to continue");
                                                        String asdf = input.next();
                                                        System.out.println("Answer: " + domain[7 + 2*q]);
                                                        System.out.println("Did you get it correct(Y/N) ");
                                                        char sel = input.next().charAt(0);
                                                        if(sel == 'y' || sel == 'Y'){
                                                            pf.updateRecord(player, dcv2.get(c3b), q+1, true);
                                                        }else{
                                                            pf.updateRecord(player, dcv2.get(c3b), q+1, false);
                                                        }
                                                    }
                                                }else if(Integer.parseInt(profile[2]) == 3){
                                                    //questions with 0 correct answers
                                                    if((Integer.parseInt(record[2 + q*2]) == 0)){
                                                        System.out.println("\u000C");
                                                        System.out.println("\u000C");
                                                        System.out.println("Record " + record[1 + q*2] + "/" + record[2+ q*2]);
                                                        System.out.println();
                                                        System.out.println("Question: " + domain[6 + 2*q]);
                                                        System.out.println("Enter anything to continue");
                                                        String asdf = input.next();
                                                        System.out.println("Answer: " + domain[7 + 2*q]);
                                                        System.out.println("Did you get it correct(Y/N) ");
                                                        char sel = input.next().charAt(0);
                                                        if(sel == 'y' || sel == 'Y'){
                                                            pf.updateRecord(player, dcv2.get(c3b), q+1, true);
                                                        }else{
                                                            pf.updateRecord(player, dcv2.get(c3b), q+1, false);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else{
                                        System.out.println("\u000C");
                                        System.out.println("Incorrect Password");
                                    }
                                }
                            }
                            csvReader.close();
                        } catch (Exception e) {
                            //TODO: handle exception
                            
                        }
  
                    }else{
                        System.out.println("\u000C");
                        System.out.println("Invalid Choice");
                    }
                }else{
                    System.out.println("\u000C");
                    System.out.println("Invalid Choice");
                }
            }else if(choice == 4){
                //create new domain
                dm.newDomain(player);
            }else if(choice == 5){
                //import new domain
                System.out.println("\u000C");
                System.out.println("To Import a new Domain, make sure it's in the same directory as your code");
                System.out.println();
                System.out.print("Enter the full name of your file including the extension(ex. ben.csv): ");
                String p5 = input.next();
                try {
                    dm.importDomain(p5);
                } catch (Exception e) {
                    System.out.println("FAILED TO IMPORT DOMAIN");
                    System.out.println("\u000C");
                }
            }else if(choice == 6){
                //detach domain
                String[] dM;
                try {
                    BufferedReader csvReader = new BufferedReader(new FileReader("profileList.csv"));
                    String row = csvReader.readLine();
                    dM = row.split(",");
                    csvReader.close();
                } catch (IOException e) {
                    System.out.println("Falied to split");
                    e.printStackTrace();
                    dM = new String[1];
                }

                for(int i = 0; i < dM.length; i++){
                    String pN = dM[i].substring(0, dM[i].length() - 4);
                    System.out.println((i+1) + ") " + pN);
                }
                System.out.println();
                System.out.print("Which Domain do you want to Detach: ");
                int c6a = input.nextInt();

                dm.detachDomain(dM[c6a - 1], player);
            }else if(choice == 7){
                //exit
                System.out.println("\u000C");
            }else{
                System.out.println("Invalid Selection");
                System.out.println();
                System.out.println();
                System.out.println();
            }


        }while(choice != 7);
    }

    public static ArrayList<String> domainsCanView(String pN) {
        //loop through each domain, if player is the creator, print, else if public print, else do nothing
        ArrayList<String> domains = new ArrayList<>();

        pN = pN.substring(0, pN.length() - 3);
        String[] data;
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

        for(int i = 0; i < data.length; i++){
            String[] da;
            try {
                BufferedReader csvReader = new BufferedReader(new FileReader(data[i]));
                String row = csvReader.readLine();
                da = row.split(",");
                csvReader.close();
            } catch (IOException e) {
                System.out.println("Falied to split");
                e.printStackTrace();
                da = new String[2];
            }
            
            if(da[1].toUpperCase().equals(pN.toUpperCase().substring(0, pN.length()-1))){
                domains.add(data[i]);
            }else if(Integer.parseInt(da[2]) == 1){
                domains.add(data[i]);
            }
            
        }

        return domains;
    }

}


//todo
//=========select/edit domain method=====================
//code to go through domain and show score line 160