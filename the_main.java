/*  THE GIT ADDRESS
https://github.com/IHesamI/Mafia_verson.0.1
*/

import java.util.*;
import java.util.regex.*;

public class the_main {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BRIGHT_BLACK = "\u001B[90m";
    public static final String ANSI_BRIGHT_RED = "\u001B[91m";
    public static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BRIGHT_BLUE = "\u001B[94m";
    public static final String ANSI_BRIGHT_PURPLE = "\u001B[95m";
    public static final String ANSI_BRIGHT_CYAN = "\u001B[96m";
    public static final String ANSI_BRIGHT_WHITE = "\u001B[97m";
    public static final String[] FOREGROUNDS = {
            ANSI_BLACK, ANSI_RED, ANSI_GREEN, ANSI_YELLOW,
            ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN, ANSI_WHITE,
            ANSI_BRIGHT_BLACK, ANSI_BRIGHT_RED, ANSI_BRIGHT_GREEN, ANSI_BRIGHT_YELLOW,
            ANSI_BRIGHT_BLUE, ANSI_BRIGHT_PURPLE, ANSI_BRIGHT_CYAN, ANSI_BRIGHT_WHITE
    };
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
    public static final String[] BACKGROUNDS = {
            ANSI_BG_BLACK, ANSI_BG_RED, ANSI_BG_GREEN, ANSI_BG_YELLOW,
            ANSI_BG_BLUE, ANSI_BG_PURPLE, ANSI_BG_CYAN, ANSI_BG_WHITE,
            ANSI_BRIGHT_BG_BLACK, ANSI_BRIGHT_BG_RED, ANSI_BRIGHT_BG_GREEN, ANSI_BRIGHT_BG_YELLOW,
            ANSI_BRIGHT_BG_BLUE, ANSI_BRIGHT_BG_PURPLE, ANSI_BRIGHT_BG_CYAN, ANSI_BRIGHT_BG_WHITE};


    public static void main(String[] arg) {
        int the_mafias = 0, villager = 0;
        String order;
        Game the_game;
        Scanner getin = new Scanner(System.in);
        System.out.println(ANSI_BLUE + "WELCOME TO MAFAI");
        System.out.println(ANSI_BLUE + "FOR MAKING A GAME ENTER create_game");
        order = getin.next();
        while (!order.equals("create_game")) {
            System.out.println(ANSI_RED + "WRONG ORDER NO GAME CREATED, TRY AGAIN");
            order = getin.next();

        }
        the_game = new Game();

        String the_names = getin.nextLine();
        String[] names = the_names.split(" ");
        {
            System.out.println(ANSI_BLUE + "THE GAME SUCCESSFULLY WAS CREATED");

        }
        the_game.setThe_players(names);

        System.out.println(ANSI_BLUE + "FOR ASSIGN ROLES ENTER : assign_role");
        order = getin.next();
        while (!order.equals("assign_role")) {
            System.out.println(ANSI_RED + "WRONG ORDER , TRY AGAIN");
            order = getin.next();

        }

        int i = 0;
        while (i < the_game.the_players.length) {
            String name = getin.next();
            String ROLE = getin.next();
            if (the_game.has_that_name(name) && the_game.has_the_role(ROLE)) {
                the_game.set_role(name, ROLE);
                i++;
            } else the_game.set_role(name, ROLE);
        }

        for (int j = 0; j < the_game.the_players.length; j++) {
            if (the_game.the_players[j].is_villager)
                villager++;
            else if (!the_game.the_players[j].is_villager && !the_game.the_players[j].is_joker)
                the_mafias++;
        }
        System.out.println(ANSI_BLUE + " TO START THE GAME ENTER start_game");
        order = getin.next();
        while (!order.equals("start_game")) {
            System.out.println(ANSI_RED + "WRONG ORDER ,TRY AGAIN");
            order = getin.next();
        }
        for (i = 0; i < the_game.the_players.length; i++) {
            if (the_game.the_players[i].is_villager)
                System.out.println(ANSI_BLUE + the_game.the_players[i].name + " " + ANSI_GREEN + the_game.the_players[i].role);
            else
                System.out.println(ANSI_BLUE + the_game.the_players[i].name + " " + ANSI_RED + the_game.the_players[i].role);

        }
        System.out.println("Villagers = " + villager + ", mafias= " + the_mafias);

        while (!the_game.joker.won && the_mafias < villager) {
            System.out.println(the_DAY.name + " [" + the_DAY.number + "]");
            i = 0;
            while (i < the_game.the_players.length) {
                String voter = getin.next();
                String votee = getin.next();
                if (the_game.has_that_name(voter) && !the_game.Is_silenced(voter)) {
                    if (the_game.has_that_name(votee) && the_game.Is_Votee_alive(votee)) {
                        System.out.println(ANSI_BLUE + "FOUND");
                        the_game.increase_the_votee(votee);
                        i++;
                    } else if (!the_game.has_that_name(votee)) {
                        System.out.println(ANSI_RED + "USER NOT FOUND, TRY AGAIN");
                    } else {
                        System.out.println(ANSI_RED + "VOTEE ALREADY DEAD , CHOOSE ANOTHER ONE");
                    }
                } else if (!the_game.has_that_name(voter)) {
                    System.out.println(ANSI_RED + "USER NOT FOUND, TRY AGAIN");
                } else if (the_game.Is_silenced(voter)) {
                    System.out.println(ANSI_RED + "VOTER IS SILENCED, NEXT PERSON MUST CHOOSE");
                    i++;
                }
                System.out.println(ANSI_BLUE + i + " PLAYERS VOTE CORRECTLY");


            }


            System.out.println(ANSI_BLUE + "TO END THE VOTAION ENTER : end_vote");
            order = getin.next();
            while (!order.equals("end_vote")) {
                System.out.println(ANSI_RED + "WRONG ORDER ,TRY AGAIN");
                order = getin.next();
            }
            if (the_game.player_should_be_deleted()) {
                the_game.the_players[the_game.find_the_max()].is_alive = false;
                if (the_game.the_players[the_game.find_the_max()].is_villager)
                    villager--;
                else if (!the_game.the_players[the_game.find_the_max()].is_villager && !the_game.the_players[the_game.find_the_max()].is_joker)
                    the_mafias--;

                else {
                    the_game.joker.won = true;
                    System.out.println(ANSI_BRIGHT_YELLOW + "JOKER WON!!");
                    break;
                }

            }
            if (the_mafias >= villager) {
                System.out.println(ANSI_RED + "MAFIA WON!!");
                break;
            }
            if (the_mafias == 0) {
                System.out.println(ANSI_BRIGHT_GREEN + "VILLAGER WON!!");
                break;
            } else {
                System.out.println(ANSI_BRIGHT_YELLOW + "NOBODY DIED");
            }
            the_DAY.number++;
            the_game.reset_voting_number();
            System.out.println(ANSI_BLUE + the_night.name + " [" + the_night.number + "]");
            boolean mafia_done = false, doctor_done = false, detedctive_done = false, silebcer_done = false;
            while (!mafia_done || !doctor_done /*|| !silebcer_done*/|| !detedctive_done ) {
                System.out.println(ANSI_BLUE + "CHOOSE AN ORDER");

                if (!mafia_done)
                    System.out.println(ANSI_BLUE + "1- MAFIA ELECTION");
                else if (mafia_done)
                    System.out.println(ANSI_RED + "1- MAFIA ELECTION");

                if (!doctor_done)
                    System.out.println(ANSI_BLUE + "2- DOCTOR SAVING");
                else if (doctor_done)
                    System.out.println(ANSI_RED + "2- DOCTOR SAVING");

                if (!detedctive_done)
                    System.out.println(ANSI_BLUE + "3- DETECTIVE SEARCH");
                else if (detedctive_done)
                    System.out.println(ANSI_RED + "3- DETECTIVE SEARCH");

              /*  if (!silebcer_done)
                    System.out.println(ANSI_BLUE + "4- SILENCER");
                if (silebcer_done)
                    System.out.println(ANSI_RED + "4- SILENCER");*/
                int order_1 = getin.nextInt();
                switch (order_1) {
                    case (1):

                        the_game.doctor_job();
                        mafia_done = true;

                        break;
                    case (2):
                        doctor_done = true;
                        break;
                    case (3):
                        detedctive_done = true;
                        break;
                  /*  default:
                        silebcer_done = true;
                        break;*/
                }

            }
        }


    }

}