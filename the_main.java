import java.util.*;
import  java.util.regex.*;
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
        String order;
        Game the_game ;
        Scanner getin = new Scanner(System.in);
        System.out.println(ANSI_BLUE + "WELCOME TO MAFAI");
        System.out.println(ANSI_BLUE + "FOR MAKING A GAME ENTER create_game");
        order = getin.next();
        while (!order.equals("create_game"))
        {
            System.out.println(ANSI_RED + "WRONG ORDER NO GAME CREATED, TRY AGAIN");
            order=getin.next();

        }
        the_game=new Game();

        String the_names=getin.nextLine();
        String [] names=the_names.split(" ");
        {
            System.out.println(ANSI_BLUE+"THE GAME SUCCESSFULLY WAS CREATED");

        }
        the_game.setThe_players(names);
        for(int i=0;i<the_game.the_players.length;i++)
            System.out.print(the_game.the_players[i].name+" ");

        System.out.println(ANSI_BLUE + "FOR ASSIGN ROLES ENTER : assign_role");
        order=getin.next();
        while (!order.equals("assign_role"))
        {
            System.out.println(ANSI_RED + "WRONG ORDER , TRY AGAIN");
            order=getin.next();

        }

            int i=0;
            while (i<the_game.the_players.length)
            {
                String name=getin.next();
                String ROLE=getin.next();
                if(the_game.has_that_name(name)&& the_game.has_the_role(ROLE))
                {
                    the_game.set_role(name,ROLE);
                    i++;
                }

                else  the_game.set_role(name,ROLE);
            }
            for( i=0;i<the_game.the_players.length;i++)
            {   if(the_game.the_players[i].is_villager)
                System.out.println(ANSI_BLUE+the_game.the_players[i].name+" "+ ANSI_GREEN +the_game.the_players[i].role);
                    else System.out.println(ANSI_BLUE+the_game.the_players[i].name+" "+ ANSI_RED +the_game.the_players[i].role);

            }




    }

}