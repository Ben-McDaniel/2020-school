public class Tester{
    public static void main(String[]args){
        Position p1 = new Position(1,'a');
        Position p2 = new Position(4,'c');

        System.out.println("Position 1 Output:");
        System.out.println("Row: " + p1.row());
        System.out.println("Column: " + p1.column());
        System.out.println("toString: " + p1.toString());

        System.out.println();

        System.out.println("Position 2 Output:");
        System.out.println("Row: " + p2.row());
        System.out.println("Column: " + p2.column());
        System.out.println("toString: " + p2.toString());
    }
}