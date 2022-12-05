package DataTypes;

/**
 * @author Jamar
 * Applies 5% off total cart cost.
 */
public class ApplyFiveOff extends CouponDecorator{

    ICoupon cart;

    /**
     * Grabs instance of the cart object
     * @param cart
     */
    public ApplyFiveOff(ICoupon cart)
    {
        this.cart = cart;
    }

    /**
     * Does 5% coupon calculation
     * @return Total = Carts total - (carts total * 0.05)
     */
    @Override
    public float getTotal() {
        return (float) (cart.getTotal() - cart.getTotal() * 0.05);
    }


//    public ApplyFiveOff(ICoupon newCart) {
//        super(newCart);
//        System.out.println("Applying %5 off");
//    }
//    public float AddFivePercentCoupon() {
//        return (float) (this.cart.AddFivePercentCoupon() - (this.cart.AddFivePercentCoupon() * 0.05));
//    }
//
}
