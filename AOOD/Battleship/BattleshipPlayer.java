import java.util.Scanner;
import java.util.Arrays;

public class BattleshipPlayer {
    String pName;
    Scanner input = new Scanner(System.in);
    Position pShoot;
    char pShootChar;
    int pShootInt;
    public Ocean cOcean;
    BattleshipGrid cGrid;
    int turn = 0;
    boolean over = false;

    public BattleshipPlayer(){
        pName = null;
        cGrid = new BattleshipGrid();
        cOcean = new Ocean();
        cOcean.placeAllBoats();
    }

    public void startGame(){
        if(pName == null){
            System.out.print("Enter Name: ");
            pName = input.next();
        }
        System.out.println("Welcome " + pName);
        BattleshipGrid pBattleshipGrid = new BattleshipGrid();
    }

    public String playerName(){
        return pName;
    }

    public Position shoot(){
        turn++;
        while(turn < 100){
            cGrid.viewGrid();
            System.out.print("Enter the row: ");
            pShootChar = input.next().charAt(0);
            System.out.print("Enter the column: ");
            pShootInt = input.nextInt() - 1;
            
            if(pShootInt < 10 && (pShootChar == 'A' || pShootChar == 'B' || pShootChar == 'C' || pShootChar == 'D' || pShootChar == 'E' || pShootChar == 'F' || pShootChar == 'G' || pShootChar == 'H' || pShootChar == 'I' || pShootChar == 'J')){
                pShoot = new Position(pShootInt, pShootChar);
                return pShoot;
            }else{
                System.out.println("Invalid Selection, try again making sure you enter an uppercase letter");
            }
        }
        return null;
    }

    public void updateGrid(){
        cOcean.viewBackup();
        cOcean.viewOcean();
        Position shotAt = shoot();
        cOcean.shootAt(shotAt);
        
        if(cOcean.hit(shotAt)){
            cGrid.shotAt(shotAt, true, cOcean.boatInital(shotAt));
            if(cOcean.sunk(shotAt)){
                System.out.println("Turn #" + turn);
                System.out.println("Sunk " + cOcean.boatName(shotAt));
            }else{
                System.out.println("Turn #" + turn);
                System.out.println("Hit " + cOcean.boatName(shotAt));
            }

            if(cOcean.allSunk() || turn > 99){
                System.out.println("GAME OVER!");
                over = true;
            }
            
        }else{
            cGrid.shotAt(shotAt, false, 'X');
            System.out.println("Turn #" + turn);
            System.out.println("Missed");
        }

    }

    public boolean gameOver(){
        return over;
    }


    // public void updatePlayer(Position pos, boolean hit, char initial, string boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns){

    // }



}
