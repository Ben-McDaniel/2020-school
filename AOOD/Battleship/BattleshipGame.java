public class BattleshipGame {
    int turnsToZero;
    BattleshipPlayer player;
    Ocean cOcean = new Ocean();

    BattleshipGame(BattleshipPlayer pl){
        cOcean.placeAllBoats();
        turnsToZero = 100;
        player = pl;
        player.startGame();
    }

    public int play(){
        while(!player.gameOver() && turnsToZero != 0){
            player.updateGrid(); 
        }
        return 100 - turnsToZero;
    }






}
