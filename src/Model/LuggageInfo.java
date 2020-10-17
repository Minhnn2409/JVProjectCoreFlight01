package Model;

public enum LuggageInfo {
    LUGGAGE01(15,155000),
    LUGGAGE02(20,175000),
    LUGGAGE03(25,235000),
    LUGGAGE04(30,335000),
    LUGGAGE05(35,385000),
    LUGGAGE06(40,435000);
    private double luggageWeight;
    private double luggageFee;

    LuggageInfo(double luggageWeight, double luggageFee) {
        this.luggageWeight = luggageWeight;
        this.luggageFee = luggageFee;
    }

    public double getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public double getLuggageFee() {
        return luggageFee;
    }

    public void setLuggageFee(double luggageFee) {
        this.luggageFee = luggageFee;
    }
}
