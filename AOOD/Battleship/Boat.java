public class Boat {
    //position refers to top most or right most square

    String type;
    int size;
    Position boatPos;
    int health;
    String orientation;

    public Boat(String type, Position pos, String orientation) {
        this.type = type;
        boatPos = pos;
        this.orientation = orientation;

        if (type.toLowerCase().equals("aircraft carrier")) {
            size = 5;
            health = 5;
        } else if (type.toLowerCase().equals("battleship")) {
            size = 4;
            health = 4;
        } else if (type.toLowerCase().equals("cruiser") || type.toLowerCase().equals("submarine")) {
            size = 3;
            health = 3;
        } else {
            size = 2;
            health = 2;
        }
    }

    public String name() {
        return type;
    }

    public Character abbreviation() {
        return type.charAt(0);
    }

    public int size() {
        return size;
    }

    public boolean onBoat(Position check){
        if(boatPos.toString().equals(check.toString())){
            return true;            
        } else {
            return false;
        }
    }

    public boolean isHit(Position attack) {
        if (boatPos.toString().equals(attack.toString())) {
            return true;
        } else {
            return false;
        }

    }

    public void hit(Position strike) {
        if(boatPos.toString().equals(strike.toString())){
            health--;
        }
    }

    public void isHit(){
        health--;
    }

    public boolean sunk(){
        if(health == 0){
            return true;
        } else {
            return false;
        }
    }

    public String position(){
        return boatPos.toString();
    }

    public String direction(){
        return orientation;
    }
}
