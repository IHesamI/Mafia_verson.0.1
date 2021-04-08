/*GIT_HUB LINK --> https://github.com/IHesamI/Mafia_verson.0.1*/

import java.util.*;


public class the_main {


    /*  public static final String ANSI_RESET = "\u001B[0m";
      public static final String ANSI_BLACK = "\u001B[30m";*/
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    /* public static final String ANSI_PURPLE = "\u001B[35m";*/
    public static final String ANSI_BRIGHT_RED = "\u001B[91m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";/*
    public static final String ANSI_BRIGHT_BLUE = "\u001B[94m";
    public static final String ANSI_BRIGHT_PURPLE = "\u001B[95m";
    public static final String ANSI_BRIGHT_CYAN = "\u001B[96m";
    public static final String ANSI_BRIGHT_WHITE = "\u001B[97m";*/
   /* public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BRIGHT_BLACK = "\u001B[90m";



    public static final String ANSI_BG_BLACK = "\u001B[40m";
    public static final String ANSI_BG_RED = "\u001B[41m";
    public static final String ANSI_BG_GREEN = "\u001B[42m";
    public static final String ANSI_BG_YELLOW = "\u001B[43m";
    public static final String ANSI_BG_BLUE = "\u001B[44m";
    public static final String ANSI_BG_PURPLE = "\u001B[45m";
    public static final String ANSI_BG_CYAN = "\u001B[46m";
    public static final String ANSI_BG_WHITE = "\u001B[47m";
    public static final String ANSI_BRIGHT_BG_BLACK = "\u001B[100m";
    public static final String ANSI_BRIGHT_BG_RED = "\u001B[101m";
    public static final String ANSI_BRIGHT_BG_GREEN = "\u001B[102m";
    public static final String ANSI_BRIGHT_BG_YELLOW = "\u001B[103m";
    public static final String ANSI_BRIGHT_BG_BLUE = "\u001B[104m";
    public static final String ANSI_BRIGHT_BG_PURPLE = "\u001B[105m";
    public static final String ANSI_BRIGHT_BG_CYAN = "\u001B[106m";
    public static final String ANSI_BRIGHT_BG_WHITE = "\u001B[107m";
*/

    public static void main(String[] arg) {
        /*tedad mafia va shahrvand*/
        int the_mafias = 0, villager = 0;
        boolean is_game_created = false, is_game_started = false;
        String order;
        String game_state = "get_game_state";
        Game the_game;
        Scanner getin = new Scanner(System.in);

        System.out.println(ANSI_BLUE + "!! WELCOME TO MAFIA !!");
        System.out.println(ANSI_BLUE + "FOR MAKING A GAME ENTER create_game,THEN PLAYERS NAMES");
        order = getin.nextLine();
        String[] THE_split = order.split(" ");
        String the_names;
        String[] names;

        the_game = new Game();


        if (THE_split.length == 1) {
            System.out.println(ANSI_BLUE + "ENTER THE PLAYERS NAME");
            the_names = getin.nextLine();
            names = the_names.split(" ");

        }
        if (THE_split[0].equals("create_game")) {
            names = new String[THE_split.length - 1];
            for (int i = 0, k = 1; k < THE_split.length; k++, i++)
                names[i] = THE_split[k];


        } else {
            names = new String[THE_split.length];
            for (int i = 0, k = 1; i < THE_split.length; k++, i++)
                names[i] = THE_split[i];
        }


        for (int z = 0; z < THE_split.length; z++) {
            if (THE_split[z].equals("create_game"))
                is_game_created = true;
            if (THE_split[z].equals("start_game"))
                is_game_started = true;
        }

        the_game.setThe_players(names);
            /*
            naqsh har bazi kon moshakhas mishavad
            */
        System.out.println(ANSI_BLUE + "FOR ASSIGN ROLES ENTER : assign_role,THEN PLAYER NAME AND ROLE");
        if (!is_game_created) {
            System.out.println(ANSI_RED + "NO GAME CREATED");
        }
        int i = 0;
        while (i < the_game.the_players.length) {
            String assign = getin.next();
            String name = getin.next();
            String ROLE = getin.next();
            if (assign.equals("assign_role")) {
                the_game.set_role(name, ROLE);

            } else {
                System.out.println(ANSI_RED + "WRONG ORDER , TRY AGAIN");
            }
            i++;
        }

        /* agar bazikoni naqsh nadasht ekhtar midahad*/
        the_game.role_maker();


        /*tedad mafia ha va shahrvandan malom mishavad*/
        for (int j = 0; j < the_game.the_players.length; j++) {
            if (the_game.the_players[j].is_villager)
                villager++;
            else if (!the_game.the_players[j].is_villager && !the_game.the_players[j].role.equals("Joker"))
                the_mafias++;
        }

        System.out.println(ANSI_BLUE + " TO START THE GAME ENTER start_game");
        order = getin.next();

        if (is_game_started) {
            System.out.println(ANSI_RED + " THE GAME HAS ALREADY STARTED");
        }
        if (!is_game_created) {
            System.out.println(ANSI_RED + "NO GAME CREATED");
        }

        if (order.equals("start_game")) {
            is_game_started = true;
        }   /*shahrvandan va mafia ha print mishavand*/
        for (i = 0; i < the_game.the_players.length; i++) {
            if (the_game.the_players[i].is_villager)
                System.out.println(ANSI_BLUE + the_game.the_players[i].name + " " + ANSI_GREEN + the_game.the_players[i].role);
            else
                System.out.println(ANSI_BLUE + the_game.the_players[i].name + " " + ANSI_RED + the_game.the_players[i].role);

        }
        System.out.println(ANSI_GREEN + "Villagers = " + villager + ANSI_RED + " mafias= " + the_mafias);

        /*charkhe koli bazi ta zamani ke ye goroh bebazad ya Joker barande shavad*/

        while (!the_game.joker.won && the_mafias < villager && the_mafias != 0) {

            if (the_DAY.number == 1)
                System.out.println(ANSI_CYAN + the_DAY.name + " [" + the_DAY.number + "]");

            int the_silenced = 0;
            i = 0;

            // raiy giri dar tole roz
            while (i + the_silenced < the_game.how_many_alive()) {

                System.out.print(ANSI_BLUE + "ENTER THE VOTER NAME AND THE VOTEE NAME:");
                String voter = getin.next();


                if (!voter.equals(game_state)) {
                    String votee = getin.next();
                    if (the_game.has_that_name(voter) && !the_game.Is_silenced(voter) && the_game.Is_Votee_alive(voter)) {
                        if (the_game.has_that_name(votee) && the_game.Is_Votee_alive(votee)) {
                            System.out.println(ANSI_GREEN + "FOUND");
                            the_game.increase_the_votee(votee);
                            i++;
                            System.out.println(ANSI_BLUE + i + " PLAYERS VOTE CORRECTLY");
                        } else if (!the_game.has_that_name(votee)) {
                            // agar esm eshtebahhi varad shavad qkhtar midahad
                            System.out.println(ANSI_RED + "USER NOT FOUND, TRY AGAIN");
                        } else {
                            // agar esm vared shode morde bashad
                            System.out.println(ANSI_RED + "VOTEE ALREADY DEAD , CHOOSE ANOTHER ONE");
                        }
                    } else if (!the_game.has_that_name(voter)) {
                        // agar raiy dahande esmash vojod nadashte bashad ekhtar midahad
                        System.out.println(ANSI_RED + "USER NOT FOUND, TRY AGAIN");
                    } else if (the_game.Is_silenced(voter)) {
                        // agar raiy dahande silenced bashad
                        System.out.println(ANSI_RED + "VOTER IS SILENCED, NEXT PERSON MUST CHOOSE");
                        the_silenced++;
                    } else if (!the_game.Is_Votee_alive(voter)) {
                        // agar raiy dahande morde bashad
                        System.out.println(ANSI_RED + "VOTER IS DEAD, NEXT PERSON MUST CHOOSE");

                    }
                } else {
                    System.out.println(ANSI_GREEN + "Villagers = " + villager + ANSI_RED + " mafias= " + the_mafias);
                }

            }
            // payane raiy giri

            System.out.println(ANSI_BLUE + "TO END THE VOTAION ENTER : end_vote");
            order = getin.next();
            if (order.equals(game_state)) {
                System.out.println(ANSI_GREEN + "Villagers = " + villager + ANSI_RED + " mafias= " + the_mafias);
            }
            while (!order.equals("end_vote")) {
                System.out.println(ANSI_RED + "ENTER end_vote to ENDING");
                order = getin.next();
            }

            // moshakhas mishavad ke aya bayad bazikoni hazph shavad
            if (the_game.player_should_be_deleted()) {
                the_game.the_players[the_game.find_the_max()].is_alive = false;

                the_game.the_player_voote_has_special_role(the_game.the_players[the_game.find_the_max()]);
                if (the_game.the_players[the_game.find_the_max()].is_villager)
                    villager--;
                else if (!the_game.the_players[the_game.find_the_max()].is_villager && !the_game.the_players[the_game.find_the_max()].is_joker)
                    the_mafias--;

                else if (the_game.the_players[the_game.find_the_max()].is_joker) {
                    the_game.joker.won = true;
                    break;
                }
                System.out.println(ANSI_RED + the_game.the_players[the_game.find_the_max()].name + " DIED");

            }
            if (the_mafias >= villager) {

                break;
            }
            if (the_mafias == 0) {

                break;
            } else if (!the_game.player_should_be_deleted()) {
                System.out.println(ANSI_BRIGHT_YELLOW + "NOBODY DIED");
            }
            the_DAY.number++;
            the_game.reset_the_silenced();
            the_game.reset_voting_number();
            System.out.println(ANSI_CYAN + the_night.name + " [" + the_night.number + "]");

                // phase shab
            int numbers = 0;
            boolean mafia_done = false, doctor_done = false, detedctive_done = false;
            while (!mafia_done || !doctor_done || !detedctive_done) {
                System.out.println(ANSI_BLUE + "ENTER THE FIRST PLAYER NAME");
                String voter = getin.next();
                if (!voter.equals(game_state)) {
                    // agar bazikon mafia bashad
                    if (the_game.is_mafia(voter)) {

                        the_game.mafia_election(voter);
                        if (the_game.success_elected)
                            numbers++;
                        if (numbers == the_mafias && the_game.Silencer.job_done)
                            mafia_done = true;
                    }
                        // agar bzikon doctor bashad
                    else if (voter.equals(the_game.Doctor.name)) {
                        System.out.println(ANSI_BLUE + "ENTER THE DOCTOR CHOICE");
                        String voote = getin.next();
                        the_game.doctor_job(voter, voote);
                        doctor_done = true;
                    }
                    // agar bzikon detective bashad
                    else if (voter.equals(the_game.DETECTVIE.name)) {
                        System.out.println(ANSI_BLUE + "ENTER THE DETECTIVE CHOICE");
                        String voote = getin.next();
                        the_game.detective_job(voter, voote);
                        detedctive_done = true;
                    } else if (!the_game.DETECTVIE.is_alive)
                        detedctive_done = true;
                    else if (!the_game.Doctor.is_alive)
                        doctor_done = true;

                    else {
                        // agar bzikon naqshi dar shab nadashte bashad
                        if (the_game.has_that_name(voter) && the_game.Is_Votee_alive(voter))
                            System.out.println(ANSI_RED + "PLAYER CANT WAKE UP");
                            // agar bzikoni ba hamchin esmi nabashad
                        else if (!the_game.has_that_name(voter))
                            System.out.println(ANSI_RED + "NO PLAYER WITH SUCH NAME");
                            // agar bzikoni morde bashad
                        else if (!the_game.Is_Votee_alive(voter))
                            System.out.println(ANSI_RED + "PLAYER IS DEAD");
                    }
                }

                if (voter.equals(game_state)) {
                    System.out.println(ANSI_GREEN + "Villagers = " + villager + ANSI_RED + " mafias= " + the_mafias);
                }
                the_game.success_elected = false;
            }
            the_game.Silencer.job_done = false;

                // payane shab
            System.out.println(ANSI_BLUE + " TO END THE NIGHT ENTER THE :  end_night");
            order = getin.next();
            if (order.equals(game_state)) {
                System.out.println(ANSI_GREEN + "Villagers = " + villager + ANSI_RED + " mafias= " + the_mafias);
            }
            while (!order.equals("end_night")) {
                System.out.println(ANSI_RED + " WRONG ORDER , TRY AGAIN");
                order = getin.next();
            }
            the_night.number++;
            System.out.println(the_DAY.name + " [" + the_DAY.number + "]");

        // agar koshte shab 1 nafar bashad
            if (the_game.how_many_max() == 1) {
                    //  agar tavasot doctor save nabashad
                if (!the_game.the_players[the_game.find_the_max()].saved_by_doctor) {
                    // agar bulletproof bashad
                    if (the_game.the_players[the_game.find_the_max()].role.equals("bulletproof")) {
                        // agar bulletproof bashad vali tir nakhorde bashad
                        if (the_game.the_players[the_game.find_the_max()].shield) {
                            the_game.the_players[the_game.find_the_max()].shield = false;

                        }
                        else {
                            the_game.the_players[the_game.find_the_max()].is_alive = false;
                            the_game.the_player_voote_has_special_role(the_game.the_players[the_game.find_the_max()]);
                        }

                    } else {
                        the_game.the_players[the_game.find_the_max()].is_alive = false;
                        the_game.the_player_voote_has_special_role(the_game.the_players[the_game.find_the_max()]);

                    }
                }


            }
            Player[] players = new Player[2];
            // agar khoste ha 2 nafar bashand
            if (the_game.how_many_max() == 2) {
                players = the_game.the_names_of_killed();
                // agar yeki az khoste ha save bashad
                if (players[0].saved_by_doctor) {

                    // agar  khoste digari bulletproof bashad
                    if (players[1].role.equals("bulletproof")) {
                        if (players[1].shield) {
                            players[1].shield = false;
                        }

                        else {
                            players[1].is_alive = false;
                            the_game.the_player_voote_has_special_role(players[1]);
                        }

                    } else {
                        players[1].is_alive = false;
                        the_game.the_player_voote_has_special_role(players[1]);

                    }
                } else if (players[1].saved_by_doctor) {
                    if (players[0].role.equals("bulletproof")) {
                        if (players[0].shield) {

                            players[0].shield = false;
                        } else {
                            players[0].is_alive = false;
                            the_game.the_player_voote_has_special_role(players[0]);

                        }

                    } else {
                        players[0].is_alive = false;
                        the_game.the_player_voote_has_special_role(players[0]);

                    }

                }

            }
// agar  khoste ha 3 nafar bashand
            if (the_game.how_many_max() == 3) {
                System.out.println(ANSI_YELLOW + "MAFIA TRIED TO KILL MULTIPLE TARGETS ");
            }

            // agar koshte zende bemanad print mishavd alive vagarne killed va hazf az bazi
            if (the_game.how_many_max() == 1) {
                System.out.println(ANSI_BRIGHT_YELLOW + " MAFIA TRIED TO KILL " + the_game.the_players[the_game.find_the_max()].name);
                if (the_game.the_players[the_game.find_the_max()].is_alive)
                    System.out.println(ANSI_BRIGHT_GREEN + the_game.the_players[the_game.find_the_max()].name + " IS ALIVE ");
                else {
                    System.out.println(ANSI_BRIGHT_RED + the_game.the_players[the_game.find_the_max()].name + " IS DEAD ");
                    if (the_game.the_players[the_game.find_the_max()].is_villager)
                        villager--;
                    if(the_game.the_players[the_game.find_the_max()].role.equals("informer"))
                    {
                        System.out.println(ANSI_BRIGHT_RED + the_game.the_players[the_game.find_the_max()].name + " IS INFOREMER");
                        the_game.informer_job();

                    }
                }
            }


            if (the_game.how_many_max() == 2) {
                if (players[0].is_alive && !players[1].is_alive) {
                    System.out.println(ANSI_BRIGHT_YELLOW + " MAFIA TRIED TO KILL " + players[0].name + " AND " + players[1].name);
                    System.out.println(ANSI_BRIGHT_RED + players[1].name + " IS KILLED ");
                    if (players[1].is_villager)
                        villager--;
                }
                if(players[1].role.equals("informer"))
                {
                    System.out.println(ANSI_BRIGHT_RED + players[1].name + " IS INFOREMER");
                    the_game.informer_job();

                }
                if (!players[0].is_alive && players[1].is_alive) {
                    System.out.println(ANSI_BRIGHT_YELLOW + " MAFIA TRIED TO KILL " + players[1].name + " AND " + players[0].name);
                    System.out.println(ANSI_BRIGHT_RED + players[0].name + " IS KILLED ");
                    if (players[0].is_villager)
                        villager--;
                    if(players[0].role.equals("informer"))
                    {
                        System.out.println(ANSI_BRIGHT_RED + players[0].name + " IS INFOREMER");
                        the_game.informer_job();

                    }

                }
                if (players[0].is_alive && players[1].is_alive) {
                    System.out.println(ANSI_BRIGHT_YELLOW + " MAFIA TRIED TO KILL " + players[0].name + " AND " + players[1].name + " THEY BOTH ALIVE");

                }
                the_game.change_the_list_of_players(players);

            }

            // bakhsh silencer
            if (the_game.has_the_silenced()) {
                System.out.println(ANSI_BRIGHT_YELLOW + the_game.return_silenced() + " IS SILENCED");
            } else if (!the_game.has_the_silenced()) {
                System.out.println(ANSI_BRIGHT_YELLOW + "NOBODY SILENCED");
            }


            the_game.reset_voting_number();
            if (the_mafias >= villager) {
                break;
            }
            the_game.reset_the_saved();

            the_night.number++;
        }

        if (the_game.joker.won) {
            System.out.println(ANSI_BRIGHT_YELLOW + "JOKER WON!!");

        } else if (the_mafias >= villager) {
            System.out.println(ANSI_RED + "MAFIA WON!!");

        } else if (the_mafias == 0) {
            System.out.println(ANSI_BRIGHT_GREEN + "VILLAGER WON!!");

        }

    }

}
