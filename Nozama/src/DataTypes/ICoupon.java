package DataTypes;

/**
 * @author: Jamar
 * AddCoupon is an interface for Cart and CouponDecorator class.
 */
public interface ICoupon {
    String getDescription();
    float AddFivePercentCoupon();
    float AddTenPercentCoupon();
}
