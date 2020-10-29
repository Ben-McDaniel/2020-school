
public class Tester{
    //2d arrays are stupid so column and row are backwards, coloum is horizontal and index increases each line going down
    // row vertical and increases to the right
    public static void main(String[]args){
    //     Position p1 = new Position(1,'a');
        Position p2 = new Position(2,2); 
    //     Position p3 = new Position(5,5);

        Position p4 = new Position (4,4);

        // System.out.println("Position 1 Output:");
        // System.out.println("Row: " + p1.row());
        // System.out.println("Column: " + p1.column());
        // System.out.println("toString: " + p1.toString());
        // System.out.println("rowIndex: " + p1.rowIndex());
        // System.out.println("columnIndex: " + p1.columnIndex());

        // System.out.println();

        // System.out.println("Position 2 Output:");
        // System.out.println("Row: " + p2.row());
        // System.out.println("Column: " + p2.column());
        // System.out.println("toString: " + p2.toString());
        // System.out.println("rowIndex: " + p2.rowIndex());
        // System.out.println("columnIndex: " + p2.columnIndex());

        // Boat b1 = new Boat("Aircraft Carrier", p2, "Vertical");
        // System.out.println(b1.health);
        // b1.hit(p2);
        // System.out.println(b1.health);


        // BattleshipGrid bg1 = new BattleshipGrid();
        // bg1.shotAt(p1, true, 'S');
        // System.out.println(bg1.hit(p1));

        // bg1.shotAt(p2, false, 'X');
        // System.out.println(bg1.miss(p2));

        // System.out.println(bg1.empty(p3));
        // System.out.println(bg1.empty(p2));

        // System.out.println(bg1.boatInitial(p1));


        // Ocean oc = new Ocean();
        // oc.placeBoat("battleship", "v", p4);
        // oc.viewOcean();
        // System.out.println();
        // oc.placeBoat("aircraft carrier", "h", p2);
        // oc.viewOcean();
        // System.out.println();
        // oc.shootAt(p4);
        // System.out.println(oc.hit(p4));
        // System.out.println(oc.boatInital(p4));
        // System.out.println(oc.boatName(p4));
        // oc.viewOcean();
        // System.out.println();
        // oc.placeAllBoats();
        // oc.viewOcean();

        BattleshipPlayer player = new BattleshipPlayer();
        BattleshipGame game = new BattleshipGame(player);
        System.out.println(game.play());
    }
}