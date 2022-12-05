package DataTypes;

/**
 * Abstract class used by AddFive and AddTen classes to wrap discount(s) on ICoupon objects. Implements ICoupon Interface
 * @author: Jamar
 */
public abstract class CouponDecorator implements ICoupon {
    public abstract float getTotal();
}
