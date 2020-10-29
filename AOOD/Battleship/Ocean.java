import java.util.Arrays;
import java.util.Random;

public class Ocean {
    //position refers to top most or right most square
    Random rand = new Random();
    Boat[] boatList = new Boat[5];
    char[][] water = new char[9][9];
    final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
    Boat airCarrier;
    Boat battleship;
    Boat cruiser;
    Boat sub;
    Boat destroyer;
    char[][] backup = new char[9][];  //backup grid before placing new ship
    int boatsPlaced = 0;
    boolean airCarrierPlaced = false;
    boolean battleshipPlaced = false;
    boolean cruiserPlaced = false;
    boolean subPlaced = false;
    boolean destroyerPlaced = false;
    Position airCarrierPos;
    Position battleshipPos;
    Position cruiserPos;
    Position subPos;
    Position destroyerPos;
    String boatDir;


    public Ocean(){
        //add spaces to the first index of each line
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                water[i][j] = ' ';
            }
        }
    }

    public void placeBoat(String boatName, String direction, Position pos){
        try {

            
            for(int i = 0; i < 9; i++){
                backup[i] = water[i].clone();
            }

            if(boatName.toLowerCase().equals("aircraft carrier")){
                airCarrier = new Boat(boatName, pos, direction);
                if(direction.toLowerCase().equals(("h"))){  
                    try{
                        for(int i = 0; i < 5; i++){
                            //check each time if another letter already exists in place, if so backup and cant place
                            if (water[airCarrier.boatPos.rowIndex()][airCarrier.boatPos.columnIndex() + i] != ' '){
                                _backup();
                                airCarrierPlaced = false;
                                boatsPlaced--;
                                break;
                            }else{
                                water[airCarrier.boatPos.rowIndex()][airCarrier.boatPos.columnIndex() + i] = 'A';
                                airCarrierPlaced = true;
                            }
                            
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        airCarrierPlaced = false;
                        boatsPlaced--;
                    }
                    
                }else{
                    try{
                        for(int i = 0; i < 5; i++){
                            if (water[airCarrier.boatPos.rowIndex() + i][airCarrier.boatPos.columnIndex()] != ' '){
                                _backup();
                                airCarrierPlaced = false;
                                boatsPlaced--;
                                break;
                            }else{
                                water[airCarrier.boatPos.rowIndex() + i][airCarrier.boatPos.columnIndex()] = 'A';
                                airCarrierPlaced = true;
                            }
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        airCarrierPlaced = false;
                        boatsPlaced--;
                    }
                }
            } else if(boatName.toLowerCase().equals("battleship")){
                battleship = new Boat(boatName, pos, direction);
                if(direction.toLowerCase().equals(("h"))){  
                    try{
                        for(int i = 0; i < 4; i++){
                            //check each time if another letter already exists in place, if so backup and cant place
                            if (water[battleship.boatPos.rowIndex()][battleship.boatPos.columnIndex() + i] != ' '){
                                _backup();
                                boatsPlaced--;
                                battleshipPlaced = false;
                                break;
                            }else{
                                water[battleship.boatPos.rowIndex()][battleship.boatPos.columnIndex() + i] = 'B';
                                battleshipPlaced = true;
                            }
                            
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        battleshipPlaced = false;
                        boatsPlaced--;
                    }
                    
                }else{
                    try{
                        for(int i = 0; i < 4; i++){
                            if (water[battleship.boatPos.rowIndex() + i][battleship.boatPos.columnIndex()] != ' '){
                                _backup();
                                boatsPlaced--;
                                battleshipPlaced = false;
                                break;
                            }else{
                                water[battleship.boatPos.rowIndex() + i][battleship.boatPos.columnIndex()] = 'B';
                                battleshipPlaced = true;
                            }
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        battleshipPlaced = false;
                        boatsPlaced--;
                    }
                }
            }else if(boatName.toLowerCase().equals("cruiser")){
                cruiser = new Boat(boatName, pos, direction);
                if(direction.toLowerCase().equals(("h"))){  
                    try{
                        for(int i = 0; i < 3; i++){
                            //check each time if another letter already exists in place, if so backup and cant place
                            if (water[cruiser.boatPos.rowIndex()][cruiser.boatPos.columnIndex() + i] != ' '){
                                _backup();
                                boatsPlaced--;
                                cruiserPlaced = false;
                                break;
                            }else{
                                water[cruiser.boatPos.rowIndex()][cruiser.boatPos.columnIndex() + i] = 'C';
                                cruiserPlaced = true;
                            }
                            
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        cruiserPlaced = false;
                        boatsPlaced--;
                    }
                    
                }else{
                    try{
                        for(int i = 0; i < 3; i++){
                            if (water[cruiser.boatPos.rowIndex() + i][cruiser.boatPos.columnIndex()] != ' '){
                                _backup();
                                boatsPlaced--;
                                cruiserPlaced = false;
                                break;
                            }else{
                                water[cruiser.boatPos.rowIndex() + i][cruiser.boatPos.columnIndex()] = 'C';
                                cruiserPlaced = true;
                            }
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        cruiserPlaced = false;
                        boatsPlaced--;
                    }
                }
            } else if(boatName.toLowerCase().equals("submarine")){
                sub = new Boat(boatName, pos, direction);
                if(direction.toLowerCase().equals(("h"))){  
                    try{
                        for(int i = 0; i < 3; i++){
                            //check each time if another letter already exists in place, if so backup and cant place
                            if (water[sub.boatPos.rowIndex()][sub.boatPos.columnIndex() + i] != ' '){
                                _backup();
                                boatsPlaced--;
                                subPlaced = false;
                                break;
                            }else{
                                water[sub.boatPos.rowIndex()][sub.boatPos.columnIndex() + i] = 'S';
                                subPlaced = true;
                            }
                            
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        subPlaced = false;
                        boatsPlaced--;
                    }
                    
                }else{
                    try{
                        for(int i = 0; i < 3; i++){
                            if (water[sub.boatPos.rowIndex() + i][sub.boatPos.columnIndex()] != ' '){
                                _backup();
                                boatsPlaced--;
                                subPlaced = false;
                                break;
                            }else{
                                water[sub.boatPos.rowIndex() + i][sub.boatPos.columnIndex()] = 'S';
                                subPlaced = true;
                            }
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        subPlaced = false;
                        boatsPlaced--;
                    }
                }
            }else if(boatName.toLowerCase().equals("destroyer")){
                destroyer = new Boat(boatName, pos, direction);
                if(direction.toLowerCase().equals(("h"))){  
                    try{
                        for(int i = 0; i < 2; i++){
                            //check each time if another letter already exists in place, if so backup and cant place
                            if (water[destroyer.boatPos.rowIndex()][destroyer.boatPos.columnIndex() + i] != ' '){
                                _backup();
                                boatsPlaced--;
                                destroyerPlaced = false;
                                break;
                            }else{
                                water[destroyer.boatPos.rowIndex()][destroyer.boatPos.columnIndex() + i] = 'D';
                                destroyerPlaced = true;
                            }
                            
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        destroyerPlaced = false;
                        boatsPlaced--;
                    }
                    
                }else{
                    try{
                        for(int i = 0; i < 2; i++){
                            if (water[destroyer.boatPos.rowIndex() + i][destroyer.boatPos.columnIndex()] != ' '){
                                _backup();
                                boatsPlaced--;
                                destroyerPlaced = false;
                                break;
                            }else{
                                water[destroyer.boatPos.rowIndex() + i][destroyer.boatPos.columnIndex()] = 'D';
                                destroyerPlaced = true;
                            }
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        destroyerPlaced = false;
                        boatsPlaced--;
                    }
                }
            }

            for(int i = 0; i < 9; i++){
                backup[i] = water[i].clone();
            }
                     
        } catch(Exception ex){
            System.out.println("Exception: " + ex);
            // Put statements here to do if the exception is thrown
        }




    }

    public void placeAllBoats(){
        while(boatsPlaced < 5){
            if(!airCarrierPlaced){
                try{
                    airCarrierPos = new Position(rand.nextInt(9), rand.nextInt(9));
                    if(rand.nextInt(2) == 0){
                        boatDir = "v";
                    } else{
                        boatDir = "h";
                    }
                    placeBoat("aircraft carrier", boatDir, airCarrierPos);
                    boatsPlaced++; 
                }catch(Exception e){
                    _backup();
                }

            }else if(!battleshipPlaced){
                try{
                    battleshipPos = new Position(rand.nextInt(9), rand.nextInt(9));
                    if(rand.nextInt(2) == 0){
                        boatDir = "v";
                    } else{
                        boatDir = "h";
                    }
                    placeBoat("battleship", boatDir, battleshipPos);
                    boatsPlaced++; 
                }catch(Exception e){
                    _backup();
                }
            }else if(!cruiserPlaced){
                try{
                    cruiserPos = new Position(rand.nextInt(9), rand.nextInt(9));
                    if(rand.nextInt(2) == 0){
                        boatDir = "v";
                    } else{
                        boatDir = "h";
                    }
                    placeBoat("cruiser", boatDir, cruiserPos);
                    boatsPlaced++; 
                }catch(Exception e){
                    _backup();
                }
            }else if(!subPlaced){
                try{
                    subPos = new Position(rand.nextInt(9), rand.nextInt(9));
                    if(rand.nextInt(2) == 0){
                        boatDir = "v";
                    } else{
                        boatDir = "h";
                    }
                    placeBoat("submarine", boatDir, subPos);
                    boatsPlaced++; 
                }catch(Exception e){
                    _backup();
                }
            }else if(!destroyerPlaced){
                try{
                    destroyerPos = new Position(rand.nextInt(9), rand.nextInt(9));
                    if(rand.nextInt(2) == 0){
                        boatDir = "v";
                    } else{
                        boatDir = "h";
                    }
                    placeBoat("destroyer", boatDir, destroyerPos);
                    boatsPlaced++; 
                }catch(Exception e){
                    _backup();
                }
            }
        }
        //viewOcean();
    }

    public void shootAt(Position pos){
        if(water[pos.rowIndex()][pos.columnIndex()] == 'A'){
            airCarrier.isHit();
            water[pos.rowIndex()][pos.columnIndex()] = 'X';
            
        }else if(water[pos.rowIndex()][pos.columnIndex()] == 'B'){
            battleship.isHit();
            water[pos.rowIndex()][pos.columnIndex()] = 'X';
            
        }else if(water[pos.rowIndex()][pos.columnIndex()] == 'C'){
            cruiser.isHit();
            water[pos.rowIndex()][pos.columnIndex()] = 'X';
            
        }else if(water[pos.rowIndex()][pos.columnIndex()] == 'S'){
            sub.isHit();
            water[pos.rowIndex()][pos.columnIndex()] = 'X';
            
        }else if(water[pos.rowIndex()][pos.columnIndex()] == 'D'){
            destroyer.isHit();
            water[pos.rowIndex()][pos.columnIndex()] = 'X';
            
        }
    }

    public boolean hit(Position pos){
        if(water[pos.rowIndex()][pos.columnIndex()] == 'X'){
            return true;
        }
        return false;
    }

    public char boatInital(Position pos){
        System.out.println(backup[pos.rowIndex()][pos.columnIndex()]);
        return backup[pos.rowIndex()][pos.columnIndex()];
    }

    public String boatName(Position pos){
        if(backup[pos.rowIndex()][pos.columnIndex()] == 'A'){
            return "Aircraft Carrier";
        }else if(backup[pos.rowIndex()][pos.columnIndex()] == 'B'){
            return "Battleship";
        }else if(backup[pos.rowIndex()][pos.columnIndex()] == 'C'){
            return "Cruiser";
        }else if(backup[pos.rowIndex()][pos.columnIndex()] == 'S'){
            return "Submarine";
        }else if(backup[pos.rowIndex()][pos.columnIndex()] == 'D'){
            return "Destroyer";
        }
        return "No ship found";
    }

    public boolean sunk(Position pos){
        if(backup[pos.rowIndex()][pos.columnIndex()] == 'A'){
            return airCarrier.sunk();
        }else if(backup[pos.rowIndex()][pos.columnIndex()] == 'B'){
            return battleship.sunk();
        }else if(backup[pos.rowIndex()][pos.columnIndex()] == 'C'){
            return cruiser.sunk();
        }else if(backup[pos.rowIndex()][pos.columnIndex()] == 'S'){
            return sub.sunk();
        }else if(backup[pos.rowIndex()][pos.columnIndex()] == 'D'){
            return destroyer.sunk();
        }
        return false;
    }

    public boolean allSunk(){
        if(airCarrier.sunk() && battleship.sunk() && cruiser.sunk() && sub.sunk() && destroyer.sunk()){
            return true;
        }
        return false;
    }

    public void viewOcean(){
        System.out.println("  1 2  3  4  5  6  7  8  9");
        for(int i = 0; i < water.length; i++){
            System.out.println(alphabet[i] + Arrays.toString(water[i]));
        }
        //System.out.println(Arrays.deepToString(water).replace("], " , "]\n").replace("[[", "[").replace("]]" ,"]"));
        
    }

    public void viewBackup(){
        System.out.println("  1 2  3  4  5  6  7  8  9");
        for(int i = 0; i < backup.length; i++){
            System.out.println(alphabet[i] + Arrays.toString(backup[i]));
        }
    }

    private void _backup(){
        for(int i = 0; i < 9; i++){
            water[i] = backup[i].clone();
        }
    }
}

//BS AND D
//D FOUND NO SHIP
// B MISSED
