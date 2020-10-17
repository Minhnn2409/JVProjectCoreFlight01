package Service.TicketService;

import Model.FlightsInfor;
import Model.TicketInfo;

public interface ISetTicket {
    void showTicketInfo();
    double calculateTicketByAge(TicketInfo ticket);
    double calculateTicketByLuggage(TicketInfo ticket, int luggageNum, double luggageWeight);
    double calculateTicketBySeatType(TicketInfo ticket, String seatType);
    TicketInfo findTicket(FlightsInfor flightsInfor);
    double calculateSumOfTicket(TicketInfo ticketGetByFlight);
}
