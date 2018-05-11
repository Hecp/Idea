/**
 * replace temp with query(以查询取代临时变更)
 * Created by hcp on 2017/8/9.
 */
public class RepalceTemp {


    public double getPrice(int quantity, int itemPrice){
        return getBasePrice(quantity, itemPrice) * getDiscountFactor(quantity, itemPrice);
    }

    private double getDiscountFactor(int quantity, int itemPrice) {
        double discountFactor;
        if (getBasePrice(quantity, itemPrice) > 100){
            discountFactor = 0.95;
        }else{
            discountFactor = 0.98;
        }
        return discountFactor;
    }

    private int getBasePrice(int quantity, int itemPrice) {
        return quantity * itemPrice;
    }
}
