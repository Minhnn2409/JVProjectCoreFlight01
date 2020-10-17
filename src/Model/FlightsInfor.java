package Model;

public enum FlightsInfor {
    FlIGHT01("vn001","Hanoi","HoChiMinh","11/10/2020 10:00","11/10/2020 13:00","VietjetAir"),
    FlIGHT02("vn002","DaNang","HoChiMinh","12/10/2020 14:00","12/10/2020 16:00","VietnamAirLine"),
    FlIGHT03("vn003","HoChiMinh","Hue","15/10/2020 20:00","15/10/2020 21:00","BambooAirLine"),
    FlIGHT04("vn004","Vinh","DaNang","21/10/2020 18:30","21/10/2020 20:00","VietjetAir"),
    FlIGHT05("vn005","PhuQuoc","Hanoi","18/10/2020 20:30","18/10/2020 21:30","VietnamAirLine"),
    FlIGHT06("vn006","HoChiMinh","ThanhHoa","20/10/2020 09:00","20/10/2020 10:30","VietjetAir"),
    FlIGHT07("vn007","HaNoi","NhaTrang","19/10/2020 11:20","19/10/2020 13:00","BambooAirLine"),
    FlIGHT08("vn008","HoChiMinh","QuyNhon","16/10/2020 15:30","16/10/2020 17:00","VietjetAir"),
    FlIGHT09("vn009","ThanhHoa","HoChiMinh","15/10/2020 22:30","16/10/2020 00:00","VietnamAirLine"),
    FlIGHT10("vn010","DongHoi","HoChiMinh","17/10/2020 16:00","17/10/2020 18:00","VietnamAirLine");


    private String flightCode;
    private String departure;
    private String destination;
    private String flightDepartureTime;
    private String flightReachingTime;
    private String providerUnit;

    FlightsInfor(String flightCode, String departure, String destination, String flightDepartureTime, String flightReachingTime, String providerUnit) {
        this.flightCode = flightCode;
        this.departure = departure;
        this.destination = destination;
        this.flightDepartureTime = flightDepartureTime;
        this.flightReachingTime = flightReachingTime;
        this.providerUnit = providerUnit;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightDepartureTime() {
        return flightDepartureTime;
    }

    public String getFlightReachingTime() {
        return flightReachingTime;
    }

    public String getProviderUnit() {
        return providerUnit;
    }
}
