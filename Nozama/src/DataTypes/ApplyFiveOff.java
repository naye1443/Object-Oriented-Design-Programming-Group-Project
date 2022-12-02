package DataTypes;

/**
 * @author: Jamar
 * Applies 5% off total cart cost.
 */
public class ApplyFiveOff extends CouponDecorator{
    public ApplyFiveOff(ICoupon newCart) {
        super(newCart);
        System.out.println("Applying %5 off");
    }
    public float AddTenPercentCoupon() {
        return (float) (this.cart.AddFivePercentCoupon() - (this.cart.AddFivePercentCoupon() * 0.05));
    }
}
