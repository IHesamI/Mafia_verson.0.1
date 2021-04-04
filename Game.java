import java.util.Scanner;

public class Game {
    int villagers, mafias;

    Scanner getter = new Scanner(System.in);
    public boolean success_elected = false;
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    Player[] the_players;
    Player the_doctor_choosed = new Player();
    Player mafias_number1_choosed /*= new Player()*/, mafias_number2_choosed /*= new Player()*/, player_silenced;

    String[] the_roles = {"Joker", "villager", "detective", "doctor", "bulletproof", "mafia", "godfather", "silencer"};
    Joker joker = new Joker();
    detective DETECTVIE = new detective();
    doctor Doctor = new doctor();
    bulletproof Bulletproof = new bulletproof();
    godfather Godfather = new godfather();
    silencer Silencer = new silencer();

    public void role_maker() {
        for (int i = 0; i < the_players.length; i++) {
            if (the_players[i].role == null) {
                String ROEL;
                System.out.println(ANSI_YELLOW + the_players[i].name + " DOESNT HAVE ANY ROLE ,ENTER THE ROLE");

                while (the_players[i].role == null) {
                    ROEL = getter.next();
                    if (has_the_role(ROEL))
                        the_players[i].role = ROEL;
                    else System.out.println(ANSI_RED + "ROLE NOT FOUND");
                }
                if (the_players[i].role.equals("Joker")) {
                    joker.change_the_class(the_players[i]);
                    the_players[i].is_joker = true;
                }
                else if (the_players[i].role.equals("detective")) {
                    the_players[i].is_villager = true;
                    DETECTVIE.change_the_class(the_players[i]);
                }
                else if (the_players[i].role.equals("doctor")) {
                    the_players[i].is_villager = true;
                    Doctor.change_the_class(the_players[i]);
                }
                else if (the_players[i].role.equals("bulletproof")) {
                    the_players[i].is_villager = true;
                    Bulletproof.change_the_class(the_players[i]);
                }
                else if (the_players[i].role.equals("godfather")) {
                    the_players[i].is_villager = false;
                    Godfather.change_the_class(the_players[i]);
                } else if (the_players[i].role.equals("silencer")) {
                    Silencer.change_the_class(the_players[i]);
                    the_players[i].is_villager = false;
                } else if (the_players[i].role.equals("mafia"))
                    the_players[i].is_villager = false;
                else if (the_players[i].role.equals("villager")) {
                    the_players[i].is_villager = true;
                }


            }
        }
    }


    public void setThe_players(String[] players_name) {
        the_players = new Player[players_name.length];
        for (int i = 0; i < players_name.length; i++) {
            the_players[i] = new Player(players_name[i]);

        }
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

    public void reset_the_saved() {
        for (int i = 0; i < the_players.length; i++) {
            if (the_players[i].saved_by_doctor) {
                the_players[i].saved_by_doctor = false;

            }
        }
    }

    public void day_election() {

    }

    public void change_the_list_of_players(Player[] players) {
        for (int j = 0; j < players.length; j++)
            for (int i = 0; i < the_players.length; i++) {
                if (the_players[i].name.equals(players[j].name))
                    the_players[i] = players[j];
            }

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
        for (int i = 0; i < the_players.length; i++)
            the_players[i].voting_numbers = 0;
    }

    public Player[] the_names_of_killed() {
        Player[] the_killed = new Player[2];

        for (int i = 0, k = 0; i < the_players.length; i++)
            if (the_players[i].voting_numbers == the_players[find_the_max()].voting_numbers) {
                the_killed[k] = the_players[i];
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

    public int how_many_max() {
        int maxes = 0;
        for (int i = 0; i < the_players.length; i++)
            if (the_players[find_the_max()].voting_numbers == the_players[i].voting_numbers)
                maxes++;
        return maxes;

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

    public void detective_job(String name1, String name2) {
        boolean is_done = false;
        if (DETECTVIE.name != null)
            while (!is_done) {

                if (DETECTVIE.name.equals(name1)) {
                    if (DETECTVIE.is_alive) {
                        if (has_that_name(name2) && Is_Votee_alive(name2) && !IS_SUPECTED_BEFORE(name2)) {
                            detective(name2);
                            is_done = true;
                        } else if (!has_that_name(name2)) {
                            System.out.println(ANSI_RED + "USER NOT FOUND,ENTER THE PLAYER NAME AGAIN");
                            name2 = getter.next();
                        } else if (IS_SUPECTED_BEFORE(name2)) {
                            System.out.println(ANSI_RED + " DETECTIVE HAS ALREADY ASKED,ENTER ANOTHER NAME");
                            name2 = getter.next();
                        } else {
                            System.out.println(ANSI_RED + " SUSPECT IS DEAD,ENTER ANOTHER NAME");
                            name2 = getter.next();
                        }
                    } else {
                        is_done = true;
                        System.out.println(ANSI_RED + "DETECTIVE IS DEAD");
                    }
                } else {
                    System.out.println(ANSI_RED + "USER CAN NOT WAKE UP DURING NIGHT,ENTER THE DETECTIVE NAME");
                    name1 = getter.next();
                }
            }
        else System.out.println(ANSI_RED + "DONT HAVE DETECTIVE");
    }

    public void detective(String name) {
        for (Player the_player : the_players)
            if (the_player.name.equals(name)) {
                the_player.is_suspect = true;
                if (the_player.is_villager || the_player.role.equals("godfather"))
                    System.out.println(ANSI_RED + "NO");
                else {
                    System.out.println(ANSI_YELLOW + "YES");
                }
            }
    }

    public void the_player_voote_has_special_role(Player player) {
        if (player.name.equals(DETECTVIE.name))
            DETECTVIE.is_alive = false;
        if (player.name.equals(Doctor.name))
            Doctor.is_alive = false;
        if (player.name.equals(Silencer.name))
            Silencer.is_alive = false;

    }


    public void doctor_job(String name1, String name2) {
        boolean is_done = false;
        if (Doctor.name != null)
            while (!is_done) {
                if (Doctor.name.equals(name1)) {
                    if (Doctor.is_alive) {
                        if (has_that_name(name2) && Is_Votee_alive(name2)) {
                            find_the_doctor_chosed(name2);
                            is_done = true;
                        } else if (!has_that_name(name2)) {
                            System.out.println(ANSI_RED + "USER NOT FOUND,ENTER ANOTHER NAME");
                            name2 = getter.next();
                        } else if (!Is_Votee_alive(name2)) {
                            System.out.println(ANSI_RED + " USER IS DEAD,ENTER ANOTHER NAME");
                            name2 = getter.next();
                        }
                    } else {
                        System.out.println(ANSI_RED + "DOCTOR IS DEAD");
                        is_done = true;
                    }

                } else {
                    System.out.println(ANSI_RED + "USER CAN NOT WAKE UP DURING NIGHT,ENTER THE DETECTIVE NAME");
                    name1 = getter.next();
                }
            }
        else System.out.println(ANSI_RED + "DOCTOR NOT FOUND");
    }

    public void reset_the_silenced() {
        for (int i = 0; i < the_players.length; i++)
            the_players[i].is_silenced = false;
    }

    public void silenced(String name) {

        for (int i = 0; i < the_players.length; i++)
            if (the_players[i].name.equals(name)) {
                the_players[i].is_silenced = true;
                player_silenced = new Player(the_players[i].name);
            }
    }

    public boolean has_the_silenced() {

        for (int i = 0; i < the_players.length; i++)
            if (the_players[i].is_silenced) {
                return true;
            }
        return false;
    }


    public void reset_silenced() {

        for (int i = 0; i < the_players.length; i++) {
            the_players[i].is_silenced = false;
        }

    }

    public String return_silenced() {
        String name = "";
        for (int i = 0; i < the_players.length; i++) {
            if (the_players[i].is_silenced)
                name = the_players[i].name;
        }
        return name;
    }


    public int how_many_alive() {
        int sum = 0;
        for (int i = 0; i < the_players.length; i++)
            if (the_players[i].is_alive)
                sum++;
        return sum;
    }


    public void silencer_job(String name, String name2) {
        boolean is_done = false;
        if (Silencer.name != null) {
            while (!is_done) {

                if (has_that_name(name) && Silencer.name.equals(name)) {
                    if (Is_Votee_alive(name)) {

                        if (has_that_name(name2)) {
                            if (Is_Votee_alive(name2)) {
                                Silencer.job_done = true;
                                is_done = true;
                                silenced(name2);
                            } else if (!Is_Votee_alive(name2)) {
                                System.out.println(ANSI_RED + "VOTEE IS DEAD");
                                name2 = getter.next();
                            }
                        } else {
                            System.out.println(ANSI_RED + name2 + " VOTEE NOT FOUND ,ENTER AGAIN");
                            name2 = getter.next();
                        }
                    } else {
                        System.out.println(ANSI_RED + "SILENCER IS DEAD");
                        Silencer.job_done = true;
                        is_done = true;
                    }
                } else
                    System.out.println(ANSI_RED + "USER NOT FOUND,ENTER THE SILENCER NAME");
                name = getter.next();
            }
        } else System.out.println(ANSI_RED + "SILENCER NOT FOUND");
    }

    public boolean is_mafia(String name) {
        for (int i = 0; i < the_players.length; i++) {
            if (the_players[i].name.equals(name))
                if (!the_players[i].is_villager && !the_players[i].is_joker) {
                    return true;

                }
        }
        return false;
    }

    public void mafia_election(String name) {
        System.out.println(ANSI_BLUE + "FOR VOTING ENTER V,TO END VOTING ENTER X");
        String name2 = null;
        char ORDER = 'c';
        while (ORDER != 'X') {
            ORDER = getter.next().charAt(0);
            if (ORDER == 'V')
                name2 = getter.next();
        }


        if (!Silencer.job_done && name.equals(Silencer.name)) {
            silencer_job(name, name2);
            return;
        }

        if (has_that_name(name)) {
            if (is_mafia(name)) {
                if (has_that_name(name2) && Is_Votee_alive(name2) && Is_Votee_alive(name)) {
                    success_elected = true;
                    increase_the_votee(name2);
                } else if (!has_that_name(name2)) {
                    System.out.println(ANSI_RED + "USER NOT FOUND ,ENTER THE VOTEE NAME AGAIN ");
                    name2 = getter.next();
                } else if (!Is_Votee_alive(name2)) {
                    System.out.println(ANSI_RED + "THE VOTEE IS ALREDY DEAD,ENTER AGAIN");
                    name2 = getter.next();
                } else if (!Is_Votee_alive(name)) {
                    System.out.println(ANSI_RED + name + " IS ALREDY DEAD");
                }
            } else {
                System.out.println(ANSI_RED + "THE PLAYER CANT WAKE ");

            }
        } else System.out.println(ANSI_RED + "THERE IS NO SUCH PLAYER");

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
                        the_players[i].shield = true;
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
