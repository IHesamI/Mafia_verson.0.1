public class Game {
    public static final String ANSI_RED = "\u001B[31m";
    Player [] the_players;
    String [] the_roles={"Joker", "villager", "detective", "doctor", "bulletproof", "mafia","godfather","silencer"};
        Joker joker=new Joker();
        detective DETECTVIE=new detective();
        doctor Doctor=new doctor();
    bulletproof  Bulletproof=new bulletproof();
    godfather Godfather=new godfather();
    silencer Silencer=new silencer();

    public void setThe_players(String [] players_name){
        the_players =new Player[players_name.length-1];
        for(int i=0,k=1;k<players_name.length;i++,k++)
            the_players[i]=new Player(players_name[k]);
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
        public void increase_the_votee(String name){
            for(int i=0;i<the_players.length;i++){
                if(the_players[i].name.equals(name))
                    the_players[i].voting_numbers++;
            }
        }

    public boolean Is_silenced(String name){
        for(int i=0;i<the_players.length;i++){
            if(the_players[i].name.equals(name))
            {   if(the_players[i].is_silenced)
                return true;
            }
        }
        return false;
    }
    public boolean Is_Votee_alive(String name){
        for(int i=0;i<the_players.length;i++){
            if(the_players[i].name.equals(name))
            {   if(the_players[i].is_alive)
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
                    the_players[i].is_alive=true;
                //{"Joker", "villager", "detective", "doctor", "bulletproof", "mafia","godfather","silencer"};
                    //
                   if(role.equals("Joker"))
                   {
                       joker.change_the_class(the_players[i]);
                   }

                  else if(role.equals("detective")) {
                       the_players[i].is_villager=true;
                       DETECTVIE.change_the_class(the_players[i]);
                   }
                   else if(role.equals("doctor")) {
                       the_players[i].is_villager=true;
                       Doctor.change_the_class(the_players[i]);
                   }
                   else if(role.equals("bulletproof")) {
                       the_players[i].is_villager=true;
                       Bulletproof.change_the_class(the_players[i]);
                   }
                   else if(role.equals("godfather")) {
                       the_players[i].is_villager=false;
                       Godfather.change_the_class(the_players[i]);
                   }
                   else if(role.equals("silencer")) {
                       Silencer.change_the_class(the_players[i]);
                       the_players[i].is_villager=false;
                   }
                   else if(role.equals("mafia"))
                       the_players[i].is_villager=false;
                   else if(role.equals("villager")) {
                       the_players[i].is_villager = true;
                   }               }
            }

        }
        else {if(!has_that_name(name))  System.out.println(ANSI_RED+"USER NOT FOUND");
                else  System.out.println(ANSI_RED+"ROLE NOT FOUND");
        }


    }

}
