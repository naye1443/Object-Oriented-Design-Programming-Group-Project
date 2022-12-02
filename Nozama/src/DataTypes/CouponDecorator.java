package DataTypes;

/**
 * @author: Jamar
 * Abstract class used by AddFive and AddTen classes to wrap discount(s) on ICoupon objects.
 */
public abstract class CouponDecorator implements ICoupon {
    public CouponDecorator(ICoupon newCart) {
        this.cart = newCart;
    }

    @Override
    public String getDescription() {
        return this.cart.getDescription();
    }

    @Override
    public float AddFivePercentCoupon() {
        return this.cart.AddFivePercentCoupon();
    }

    @Override
    public float AddTenPercentCoupon() {
        return this.cart.AddTenPercentCoupon();
    }
    protected ICoupon cart;
}
