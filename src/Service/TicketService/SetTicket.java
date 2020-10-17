package Service.TicketService;

import Model.Customer;
import Model.FlightsInfor;
import Model.LuggageInfo;
import Model.TicketInfo;
import Service.Helper.InputAndInfoHelper;
import Service.Helper.InputAndInfoHelperImpl;


public class SetTicket implements ISetTicket{
    @Override
    public void showTicketInfo() {
        LuggageInfo[] luggageInfos = LuggageInfo.values();
        System.out.println("---------------------- Bảng giá hành lý ----------------------" );
        System.out.println();
        System.out.println();
        System.out.format("+----------------------------------+----------------------------------+%n");
        System.out.format("|         Cân nặng hành lý         |          Phụ phí hành lý         |%n");
        System.out.format("+----------------------------------+----------------------------------+%n");
        for(LuggageInfo luggageInfo : luggageInfos){
            System.out.format("|           " + luggageInfo.getLuggageWeight() + " kg" + "                      "
                    +   luggageInfo.getLuggageFee() + " kg"  + "%n");
            System.out.format("+----------------------------------+----------------------------------+%n");
        }
        System.out.println();
    }

    @Override
    public double calculateTicketByAge(TicketInfo ticket) {
        Customer customer = new Customer();
        if(customer.getAge() < 2){
            return -(0.9*ticket.getTicketPrice());
        }
        else if (customer.getAge() >= 2 && customer.getAge()< 12){
            return -(ticket.getTicketPrice()*0.25);
        }
        return 0;
    }

    @Override
    public double calculateTicketByLuggage(TicketInfo ticket, int luggageNum, double luggageWeight) {
        LuggageInfo[] luggageInfos = LuggageInfo.values();
        for (LuggageInfo luggageInfo : luggageInfos){
            if(luggageInfo.getLuggageWeight() == luggageWeight){
                if(luggageNum > 0){
                    return (luggageNum*luggageInfo.getLuggageFee());
                }
                else{
                    return (luggageInfo.getLuggageFee());
                }
            }
        }
        return 0;
    }

    @Override
    public double calculateTicketBySeatType(TicketInfo ticket, String seatType) {
        InputAndInfoHelper inputAndInfoHelper = new InputAndInfoHelperImpl();
        if (inputAndInfoHelper.standardLizeString(seatType).equals("yes")) {
            return (ticket.getTicketPrice()*3);
        }
        return 0;
    }

    @Override
    public TicketInfo findTicket(FlightsInfor flightsInfor) {
        TicketInfo[] ticketInfos = TicketInfo.values();
        for (TicketInfo ticketInfo : ticketInfos){
            if(ticketInfo.getFlightCode().equals(flightsInfor.getFlightCode())){
                return ticketInfo;
            }
        }
        return null;
    }

    @Override
    public double calculateSumOfTicket(TicketInfo ticketGetByFlight) {
        InputAndInfoHelper inputAndInfoHelper = new InputAndInfoHelperImpl();
        int luggageNum = inputAndInfoHelper.inputIntNum("Mời nhập số hành lý: ", "Số hành lý phải là số");
        double luggageWeight = inputAndInfoHelper.inputDoubleNum("Mời nhập cân nặng hành lý: ", "Cân nặng hành lý phải là số");
        String seatType = inputAndInfoHelper.inputString("Bạn có đặt vé hạng thương gia? Nếu có vui lòng ấn \"yes\"");

        double priceByLuggage = calculateTicketByLuggage(ticketGetByFlight, luggageNum, luggageWeight);
        double priceByAge = calculateTicketByAge(ticketGetByFlight);
        double priceBySeatType = calculateTicketBySeatType(ticketGetByFlight, seatType);
        return (ticketGetByFlight.getTicketPrice() + priceByAge + priceByLuggage + priceBySeatType);
    }
}
