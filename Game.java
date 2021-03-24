public class Game {
    public static final String ANSI_RED = "\u001B[31m";
    Player[] the_players;
    Player the_doctor_choosed=new Player();
    Player mafias_number1_choosed=new Player(), mafias_number2_choosed= new Player();

    String[] the_roles = {"Joker", "villager", "detective", "doctor", "bulletproof", "mafia", "godfather", "silencer"};
    Joker joker = new Joker();
    detective DETECTVIE = new detective();
    doctor Doctor = new doctor();
    bulletproof Bulletproof = new bulletproof();
    godfather Godfather = new godfather();
    silencer Silencer = new silencer();

    public void setThe_players(String[] players_name) {
        the_players = new Player[players_name.length - 1];
        for (int i = 0, k = 1; k < players_name.length; i++, k++)
            the_players[i] = new Player(players_name[k]);
    }

    public boolean has_the_role(String role) {
        for (int i = 0; i < the_roles.length; i++) {
            if (the_roles[i].equals(role)) {
                return true;
            }
        }
        return false;
    }


    public boolean has_that_name(String name) {
        for (int i = 0; i < the_players.length; i++) {
            if (the_players[i].name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void increase_the_votee(String name) {
        for (int i = 0; i < the_players.length; i++) {
            if (the_players[i].name.equals(name))
                the_players[i].voting_numbers++;
        }
    }

    public boolean Is_silenced(String name) {
        for (int i = 0; i < the_players.length; i++) {
            if (the_players[i].name.equals(name)) {
                if (the_players[i].is_silenced)
                    return true;
            }
        }
        return false;
    }
    public  void find_the_doctor_chosed( String name){

        for (int i = 0; i < the_players.length; i++) {
            if (the_players[i].name.equals(name)) {
                the_players[i].saved_by_doctor=true;
                the_doctor_choosed=the_players[i];

            }
        }

    }

    public boolean Is_Votee_alive(String name) {
        for (int i = 0; i < the_players.length; i++) {
            if (the_players[i].name.equals(name)) {
                if (the_players[i].is_alive)
                    return true;
            }
        }
        return false;
    }

    public void reset_voting_number() {
        for (int i = 0; i < the_players.length; i++)
            the_players[i].voting_numbers = 0;
    }

    public int find_the_max() {
        int the_most_voted_player_index = 0, max = 0;
        for (int i = 0; i < the_players.length; i++) {
            if (the_players[i].voting_numbers > max && the_players[i].voting_numbers != 0) {
                the_most_voted_player_index = i;
                max = the_players[i].voting_numbers;
            }
        }
        return the_most_voted_player_index;
    }

    public boolean player_should_be_deleted() {
        int the_most_voted_player_index = find_the_max();
        for (int i = 0; i < the_players.length; i++) {
            if (the_players[the_most_voted_player_index].voting_numbers == the_players[i].voting_numbers && i != the_most_voted_player_index) {
                return false;
            }
        }
        return true;

    }

    public void doctor_job(String name1, String name2) {
        boolean is_done = false;
        while (!is_done)
        {
            if (Doctor.name.equals(name1))
            {
                if (Doctor.is_alive)
                {
                    if (has_that_name(name2) && Is_Votee_alive(name2) )
                    {   find_the_doctor_chosed(name2);
                         is_done=true;
                    }
                    else if(!has_that_name(name2)) System.out.println(ANSI_RED + "USER NOT FOUND");
                    else System.out.println(ANSI_RED + " USER IS DEAD");
                }
                else
                    System.out.println(ANSI_RED + "USER IS DEAD");
            }
             else System.out.println(ANSI_RED + "USER CAN NOT WAKE UP DURING NIGHT");
        }
    }


    public void set_role(String name, String role) {
        if (has_that_name(name) && has_the_role(role)) {
            for (int i = 0; i < the_players.length; i++) {
                if (the_players[i].name.equals(name)) {
                    the_players[i].role = role;
                    the_players[i].is_alive = true;
                    //{"Joker", "villager", "detective", "doctor", "bulletproof", "mafia","godfather","silencer"};
                    //
                    if (role.equals("Joker")) {
                        joker.change_the_class(the_players[i]);
                        the_players[i].is_joker = true;
                    } else if (role.equals("detective")) {
                        the_players[i].is_villager = true;
                        DETECTVIE.change_the_class(the_players[i]);
                    } else if (role.equals("doctor")) {
                        the_players[i].is_villager = true;
                        Doctor.change_the_class(the_players[i]);
                    } else if (role.equals("bulletproof")) {
                        the_players[i].is_villager = true;
                        Bulletproof.change_the_class(the_players[i]);
                    } else if (role.equals("godfather")) {
                        the_players[i].is_villager = false;
                        Godfather.change_the_class(the_players[i]);
                    } else if (role.equals("silencer")) {
                        Silencer.change_the_class(the_players[i]);
                        the_players[i].is_villager = false;
                    } else if (role.equals("mafia"))
                        the_players[i].is_villager = false;
                    else if (role.equals("villager")) {
                        the_players[i].is_villager = true;
                    }
                }
            }

        } else {
            if (!has_that_name(name)) System.out.println(ANSI_RED + "USER NOT FOUND");
            else System.out.println(ANSI_RED + "ROLE NOT FOUND");
        }


    }

}
