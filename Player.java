public  class Player {
    String name , voted, role ;
    int voting_numbers;
    boolean is_alive;
    boolean is_villager;
    boolean has_specific_roled;
    boolean is_silenced;
    boolean is_joker;
    boolean saved_by_doctor=false;
    boolean shot_by_mafia=false;
    public Player(){}

    public  Player (String name){
        this.name=name;
    }

    public  void change_the_class(Player player){};
}


