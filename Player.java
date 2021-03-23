public  class Player {
    String name , voted, role ;
    int voting_numbers;
    boolean is_alive;
    boolean is_villager;
    boolean has_specific_roled;
    public Player(){}

    public  Player (String name){
        this.name=name;
    }
    public  void change_the_class(Player player){};
}


