package Model;

public enum Discount {
    DISCOUNT01("sale10", 0.9),
    DISCOUNT02("sale20", 0.8),
    DISCOUNT03("sale50", 0.5),
    DISCOUNT04("sale100", 0),
    ;
    private String discountCode;
    private double rateDiscount;

    Discount(String discountCode, double rateDiscount) {
        this.discountCode = discountCode;
        this.rateDiscount = rateDiscount;
    }

    public double getRateDiscount() {
        return rateDiscount;
    }

    public void setRateDiscount(double rateDiscount) {
        this.rateDiscount = rateDiscount;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
}
