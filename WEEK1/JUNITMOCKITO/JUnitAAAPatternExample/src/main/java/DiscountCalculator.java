public class DiscountCalculator {

    public double calculateDiscount(double amount, double discountPercent) {

        return amount - (amount * discountPercent / 100);

    }

}