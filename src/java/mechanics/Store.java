package mechanics;

public class Store {
    private Player player;
    private Business business;

    public void purchasePersonalItem(Item item){
        if (player.isConfidentEnough(item.selfEffect)){
            player.changeSelfEsteem(item.selfEffect);
        }
        else {
            player.changeSelfEsteem(-item.selfEffect);
            player.changeRespect(-item.repEffect);
        }
        player.changeMoney(-item.price);
    }

    public void purchaseItemForBusiness (Item item){
        // if respect is high enough it adds experience to the business
        // otherwise it negatively impacts the business
        if (player.getRespect() > item.repEffect){
            player.changeRespect(item.repEffect);
        }
        else {
            //
            player.changeRespect(-item.repEffect);

        }
        // decrease from business funds
    }
}
