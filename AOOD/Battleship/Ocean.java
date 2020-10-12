import java.util.Arrays;

public class Ocean {
    //position refers to top most or right most square
    Boat[] boatList = new Boat[5];
    char[][] water = new char[9][9];
    Boat airCarrier;
    Boat battleship;
    Boat cruiser;
    Boat sub;
    Boat destroyer;
    char[][] backup = new char[9][];  //backup grid before placing new ship


    boolean test = false;

    public Ocean(){
        //add spaces to the first index of each line
        for(int i = 0; i < 9; i++){
            water[i][0] = ' ';
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
                                System.out.println("Could not place ship there");
                                break;
                            }else{
                                water[airCarrier.boatPos.rowIndex()][airCarrier.boatPos.columnIndex() + i] = 'A';
                            }
                            
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        System.out.println("Could not place ship there");
                    }
                    
                }else{
                    try{
                        for(int i = 0; i < 5; i++){
                            if (water[airCarrier.boatPos.rowIndex() + i][airCarrier.boatPos.columnIndex()] != ' '){
                                _backup();
                                System.out.println("Could not place ship there");
                                break;
                            }else{
                                water[airCarrier.boatPos.rowIndex() + i][airCarrier.boatPos.columnIndex()] = 'A';
                            }
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        System.out.println("Could not place ship there");
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
                                System.out.println("Could not place ship there");
                                break;
                            }else{
                                water[battleship.boatPos.rowIndex()][battleship.boatPos.columnIndex() + i] = 'B';
                            }
                            
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        System.out.println("Could not place ship there");
                    }
                    
                }else{
                    try{
                        for(int i = 0; i < 4; i++){
                            if (water[battleship.boatPos.rowIndex() + i][battleship.boatPos.columnIndex()] != ' '){
                                _backup();
                                System.out.println("Could not place ship there");
                                break;
                            }else{
                                water[battleship.boatPos.rowIndex() + i][battleship.boatPos.columnIndex()] = 'B';
                            }
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        System.out.println("Could not place ship there");
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
                                System.out.println("Could not place ship there");
                                break;
                            }else{
                                water[cruiser.boatPos.rowIndex()][cruiser.boatPos.columnIndex() + i] = 'C';
                            }
                            
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        System.out.println("Could not place ship there");
                    }
                    
                }else{
                    try{
                        for(int i = 0; i < 3; i++){
                            if (water[cruiser.boatPos.rowIndex() + i][cruiser.boatPos.columnIndex()] != ' '){
                                _backup();
                                System.out.println("Could not place ship there");
                                break;
                            }else{
                                water[cruiser.boatPos.rowIndex() + i][cruiser.boatPos.columnIndex()] = 'C';
                            }
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        System.out.println("Could not place ship there");
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
                                System.out.println("Could not place ship there");
                                break;
                            }else{
                                water[sub.boatPos.rowIndex()][sub.boatPos.columnIndex() + i] = 'S';
                            }
                            
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        System.out.println("Could not place ship there");
                    }
                    
                }else{
                    try{
                        for(int i = 0; i < 3; i++){
                            if (water[sub.boatPos.rowIndex() + i][sub.boatPos.columnIndex()] != ' '){
                                _backup();
                                System.out.println("Could not place ship there");
                                break;
                            }else{
                                water[sub.boatPos.rowIndex() + i][sub.boatPos.columnIndex()] = 'S';
                            }
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        System.out.println("Could not place ship there");
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
                                System.out.println("Could not place ship there");
                                break;
                            }else{
                                water[destroyer.boatPos.rowIndex()][destroyer.boatPos.columnIndex() + i] = 'D';
                            }
                            
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        System.out.println("Could not place ship there");
                    }
                    
                }else{
                    try{
                        for(int i = 0; i < 2; i++){
                            if (water[destroyer.boatPos.rowIndex() + i][destroyer.boatPos.columnIndex()] != ' '){
                                _backup();
                                System.out.println("Could not place ship there");
                                break;
                            }else{
                                water[destroyer.boatPos.rowIndex() + i][destroyer.boatPos.columnIndex()] = 'D';
                            }
                        }
                    } catch(Exception shipCouldNotBePlaced){
                        _backup();
                        System.out.println("Could not place ship there");
                    }
                }
            }
                     
        } catch(Exception ex){
            System.out.println("Exception: " + ex);
            // Put statements here to do if the exception is thrown
        }




    }

    public void shootAt(Position pos){
        if(water[pos.rowIndex()][pos.columnIndex()] == 'A'){
            airCarrier.isHit();
            water[pos.rowIndex()][pos.columnIndex()] = 'X';
            viewOcean();
        }else if(water[pos.columnIndex()][pos.rowIndex()] == 'B'){
            battleship.isHit();
            water[pos.columnIndex()][pos.rowIndex()] = 'X';
            viewOcean();
        }else if(water[pos.rowIndex()][pos.columnIndex()] == 'C'){
            cruiser.isHit();
            water[pos.rowIndex()][pos.columnIndex()] = 'X';
            viewOcean();
        }else if(water[pos.rowIndex()][pos.columnIndex()] == 'S'){
            sub.isHit();
            water[pos.rowIndex()][pos.columnIndex()] = 'X';
            viewOcean();
        }else if(water[pos.rowIndex()][pos.columnIndex()] == 'D'){
            destroyer.isHit();
            water[pos.rowIndex()][pos.columnIndex()] = 'X';
            viewOcean();
        }
    }

    public boolean hit(Position pos){
        if(water[pos.rowIndex()][pos.columnIndex()] == 'X'){
            return true;
        }
        return false;
    }

    public char boatInital(Position pos){
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
        System.out.println(Arrays.deepToString(water).replace("], " , "]\n").replace("[[", "[").replace("]]" ,"]").replace(" [,", "[ ,").replace(", A", ",A").replace(", B", ",B").replace(", C", ",C").replace(", S", ",S"));
        //System.out.println(Arrays.deepToString(water));
    }

    private void _backup(){
        for(int i = 0; i < 9; i++){
            water[i] = backup[i].clone();
        }
    }
}
