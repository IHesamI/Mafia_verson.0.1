public class Game {
    Player [] the_players;

    public void setThe_players(String [] players){
        the_players =new Player[players.length];
        for(int i=0;i<players.length;i++)
            the_players[i]=new Player(players[i]);
    }

}
