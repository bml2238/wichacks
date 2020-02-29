package mechanics;

public class Store {
    private Player player;

    public void purchaseItem(Item item){
        if (player.isConfidentEnough(item.selfEffect)){
            player.changeSelfEsteem(item.selfEffect);
        }
        else {
            player.changeSelfEsteem(-item.selfEffect);
            player.changeRespect(-item.repEffect);
        }
        player.changeMoney(-item.price);
    }
}
