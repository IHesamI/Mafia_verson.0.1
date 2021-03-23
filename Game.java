public class Game {
    public static final String ANSI_RED = "\u001B[31m";
    Player [] the_players;
    String [] the_roles={"Joker", "villager", "detective", "doctor", "bulletproof", "mafia","godfather","silencer"};
        Joker joker;
        detective DETECTVIE;
        doctor Doctor;
    bulletproof  Bulletproof;
    godfather Godfather;
    silencer Silencer;

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
                //{"Joker", "villager", "detective", "doctor", "bulletproof", "mafia","godfather","silencer"};
                    //
                   if(role.equals("Joker"))
                       joker =  (Joker) the_players[i];

                  else if(role.equals("detective"))
                        DETECTVIE =  (detective) the_players[i];

                   else if(role.equals("doctor"))
                       Doctor =  (doctor) the_players[i];

                   else if(role.equals("bulletproof"))
                       Bulletproof =  (bulletproof) the_players[i];
                   else if(role.equals("godfather"))
                       Godfather = (godfather) the_players[i];

                   else if(role.equals("silencer")) Silencer = (silencer) the_players[i];
                   else if(role.equals("mafia"))
                       the_players[i].is_villager=false;
                   else if(role.equals("villager"))
                       the_players[i].is_villager=true ;
                }
            }

        }
        else {if(!has_that_name(name))  System.out.println(ANSI_RED+"USER NOT FOUND");
                else  System.out.println(ANSI_RED+"ROLE NOT FOUND");
        }

    }

}
