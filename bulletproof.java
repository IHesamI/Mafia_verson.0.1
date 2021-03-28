public class bulletproof extends Player{
    private boolean is_shiled=true;

    public void change_the_class(Player player){
        super.name=player.name;
        super.role= player.role;
        super.has_specific_roled=true;
        super.is_villager=true;
        super.is_alive=true;

    }
    public void change_the_shiled(){
        is_shiled=false;
    }
    public Boolean getIS(){
        return is_shiled;
    }
}
