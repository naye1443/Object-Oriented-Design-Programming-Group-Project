package DataTypes;

/**
 * @author: Jamar
 * Applies 10% off total cart cost.
 */
public class ApplyTenOff extends CouponDecorator{

    ICoupon cart;

    public ApplyTenOff(ICoupon cart)
    {
        this.cart = cart;
    }

    @Override
    public float getTotal() {
        return (float) (cart.getTotal() - cart.getTotal() * 0.1);
    }


//    public ApplyTenOff(ICoupon newCart) {
//        super(newCart);
//        System.out.println("Applying %10 off");
//    }
//    public float AddTenPercentCoupon() {
//        return (float) (this.cart.AddTenPercentCoupon() - (this.cart.AddTenPercentCoupon() * 0.10));
//    }
}
