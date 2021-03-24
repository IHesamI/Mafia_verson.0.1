import java.util.Scanner;

public class Game {
    Scanner getter = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    Player[] the_players;
    Player the_doctor_choosed = new Player();
    Player mafias_number1_choosed /*= new Player()*/, mafias_number2_choosed /*= new Player()*/,player_silenced;

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
        for (String the_role : the_roles) {
            if (the_role.equals(role)) {
                return true;
            }
        }
        return false;
    }


    public boolean has_that_name(String name) {
        for (Player the_player : the_players) {
            if (the_player.name.equals(name)) {
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
        for (Player the_player : the_players) {
            if (the_player.name.equals(name)) {
                if (the_player.is_silenced)
                    return true;
            }
        }
        return false;
    }

    public void find_the_doctor_chosed(String name) {

        for (int i = 0; i < the_players.length; i++) {
            if (the_players[i].name.equals(name)) {
                the_players[i].saved_by_doctor = true;
                the_doctor_choosed = the_players[i];

            }
        }

    }

    public boolean Is_Votee_alive(String name) {
        for (Player the_player : the_players) {
            if (the_player.name.equals(name)) {
                if (the_player.is_alive)
                    return true;
            }
        }
        return false;
    }

    public void reset_voting_number() {
        for (int i = 0; i < the_players.length; i++) the_players[i].voting_numbers = 0;
    }
    public  Player [] the_names_of_killed(){
        Player [] the_killed=new Player[2];

        for(int i=0,k=0;i<the_players.length;i++)
                if(the_players[i].voting_numbers== the_players[find_the_max()].voting_numbers){
                    the_killed[k]=the_players[i];
                    k++;
                }

        return the_killed;
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
    public int how_many_max(){
        int maxes=0;
        for (int i = 0; i < the_players.length; i++)
            if(the_players[find_the_max()].voting_numbers == the_players[i].voting_numbers && i !=find_the_max())
                    maxes++;
            return  maxes;

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

    public boolean IS_SUPECTED_BEFORE(String name) {
        for (Player the_player : the_players) {
            if (the_player.name.equals(name)) {
                if (the_player.is_suspect)
                    return true;
            }
        }
        return false;

    }

    public void detective_job() {
        boolean is_done = false;
        while (!is_done) {
            String name1 = getter.next();
            String name2 = getter.next();
            if (DETECTVIE.name.equals(name1)) {
                if (DETECTVIE.is_alive) {
                    if (has_that_name(name2) && Is_Votee_alive(name2) && !IS_SUPECTED_BEFORE(name2)) {
                        detective(name2);
                        is_done = true;
                    } else if (!has_that_name(name2)) System.out.println(ANSI_RED + "USER NOT FOUND");
                    else if (IS_SUPECTED_BEFORE(name2)) System.out.println(ANSI_RED + " DETECTIVE HAS ALREADY ASKED");
                    else System.out.println(ANSI_RED + " SUSPECT IS DEAD");
                } else
                    System.out.println(ANSI_RED + "DETECTIVE IS DEAD");
            } else System.out.println(ANSI_RED + "USER CAN NOT WAKE UP DURING NIGHT");
        }
    }

    public void detective(String name) {
        for (Player the_player : the_players)
            if (the_player.name.equals(name)) {
                the_player.is_suspect = true;
                if (the_player.is_villager || the_player.role.equals("godfather"))
                    System.out.println("NO");
                else {
                    System.out.println("YES");
                }
            }
    }


    public void doctor_job() {
        boolean is_done = false;
        while (!is_done) {
            String name1 = getter.next();
            String name2 = getter.next();
            if (Doctor.name.equals(name1)) {
                if (Doctor.is_alive) {
                    if (has_that_name(name2) && Is_Votee_alive(name2)) {
                        find_the_doctor_chosed(name2);
                        is_done = true;
                    } else if (!has_that_name(name2)) System.out.println(ANSI_RED + "USER NOT FOUND");
                    else System.out.println(ANSI_RED + " USER IS DEAD");
                } else
                    System.out.println(ANSI_RED + "USER IS DEAD");
            } else System.out.println(ANSI_RED + "USER CAN NOT WAKE UP DURING NIGHT");
        }
    }
    public void reset_the_silenced(){
        for (int i = 0; i < the_players.length; i++)
            the_players[i].is_silenced=false;
    }

    public void silenced(String name) {
        for (int i = 0; i < the_players.length; i++)
            if (the_players[i].name.equals(name))
            {the_players[i].is_silenced = true;
                player_silenced=the_players[i];
            }

    }

    public void silencer_job() {
        String name = getter.next();
        String name2 = getter.next();
        if (has_that_name(name) && Silencer.name.equals(name)) {
            if (Is_Votee_alive(name)) {
                if (Is_Votee_alive(name2)) {
                    silenced(name2);
                } else System.out.println(ANSI_RED + "VOTEE IS DEAD");
            } else System.out.println(ANSI_RED + "SILENCER IS DEAD");
        }
        System.out.println(ANSI_RED + "USER NOT FOUND");
    }

    public void mafia_election() {
        for (int i = 0; i < the_players.length; i++) {
            if (!the_players[i].is_villager && !the_players[i].is_joker) {
                String name = getter.next();
                String name2 = getter.nextLine();
                String[] the_choicese = name2.split(" ");
                String the_last_chice = the_choicese[the_choicese.length - 1];
                name2 = the_last_chice;
                if (has_that_name(name)) {
                    if(has_that_name(name2) && Is_Votee_alive(name2))
                    {
                        increase_the_votee(name2);
                    }
                    else if(!has_that_name(name2) ){System.out.println(ANSI_RED + "USER NOT JOINED") ;i--;}

                    else if(!Is_Votee_alive(name2) ){System.out.println(ANSI_RED + "VOTEE ALREADY DEAD") ;i--;}

                } else {System.out.println(ANSI_RED + "USER NOT JOINED") ;i--;}

            }
        }
    }
    public void set_role(String name, String role) {
        if (has_that_name(name) && has_the_role(role)) {
            for (Player the_player : the_players) {
                if (the_player.name.equals(name)) {
                    the_player.role = role;
                    the_player.is_alive = true;
                    //{"Joker", "villager", "detective", "doctor", "bulletproof", "mafia","godfather","silencer"};
                    //
                    if (role.equals("Joker")) {
                        joker.change_the_class(the_player);
                        the_player.is_joker = true;
                    } else if (role.equals("detective")) {
                        the_player.is_villager = true;
                        DETECTVIE.change_the_class(the_player);
                    } else if (role.equals("doctor")) {
                        the_player.is_villager = true;
                        Doctor.change_the_class(the_player);
                    } else if (role.equals("bulletproof")) {
                        the_player.is_villager = true;
                        Bulletproof.change_the_class(the_player);
                    } else if (role.equals("godfather")) {
                        the_player.is_villager = false;
                        Godfather.change_the_class(the_player);
                    } else if (role.equals("silencer")) {
                        Silencer.change_the_class(the_player);
                        the_player.is_villager = false;
                    } else if (role.equals("mafia"))
                        the_player.is_villager = false;
                    else if (role.equals("villager")) {
                        the_player.is_villager = true;
                    }
                }
            }

        } else {
            if (!has_that_name(name)) System.out.println(ANSI_RED + "USER NOT FOUND");
            else System.out.println(ANSI_RED + "ROLE NOT FOUND");
        }


    }

}
