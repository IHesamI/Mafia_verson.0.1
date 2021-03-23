public class Game {
    public static final String ANSI_RED = "\u001B[31m";
    Player [] the_players;
    String [] the_roles={"Joker", "villager", "detective", "doctor", "bulletproof", "mafia","godfather","silencer"};

    public void setThe_players(String [] players){
        the_players =new Player[players.length];
        for(int i=0;i<players.length;i++)
            the_players[i]=new Player(players[i]);
    }
    public boolean has_the_role(String role)
    { for(int i=0;i<the_roles.length;i++){
        if(the_roles[i].equals(role))
        {
            return true;
        }
    }
        return false;


    }

    public boolean has_that_name(String name){
        for(int i=0;i<the_players.length;i++){
            if(the_players[i].name.equals(name))
            {
            return true;
            }
        }
        return false;
    }

    public void set_role(String name,String role){
        if(has_that_name(name)&&  has_the_role(role)){
            for(int i=0;i<the_players.length;i++){
                if(the_players[i].name.equals(name))
                {   the_players[i].role=role;
                   /*the_players[i]=*/
                }
            }

        }
        else {if(!has_that_name(name))  System.out.println(ANSI_RED+"USER NOT FOUND");
                else  System.out.println(ANSI_RED+"ROLE NOT FOUND");
        }

    }

}
