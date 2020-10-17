package Model;

public enum TicketInfo {
    PRICE001("vn001",399000),
    PRICE002("vn002",36000),
    PRICE003("vn003",99000),
    PRICE004("vn004",49000),
    PRICE005("vn005",109000),
    PRICE006("vn006",99000),
    PRICE007("vn007",89000),
    PRICE008("vn008",69000),
    PRICE009("vn009",99000),
    PRICE010("vn010",1109000)
    ;
    private String flightCode;
    private double ticketPrice;

    TicketInfo(String flightCode, double ticketPrice) {
        this.flightCode = flightCode;
        this.ticketPrice = ticketPrice;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
