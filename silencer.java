public class silencer extends Player{
   public boolean job_done=false;
    public void change_the_class(Player player){
        super.name=player.name;
        super.role= player.role;
        super.has_specific_roled=true;
        super.is_villager=false;
        super.is_alive=true;

    }

}
