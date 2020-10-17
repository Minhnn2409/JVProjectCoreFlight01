package Main;

import Model.Customer;
import Model.FlightsInfor;
import Model.TicketInfo;
import Service.CustomerEditService.CustomerEdit;
import Service.CustomerEditService.CustomerEditImpl;
import Service.CustomerService.ISetCustomer;
import Service.CustomerService.SetCustomerImpl;
import Service.Helper.InputAndInfoHelper;
import Service.Helper.InputAndInfoHelperImpl;
import Service.TicketService.ISetDiscount;
import Service.TicketService.ISetTicket;
import Service.TicketService.SetDiscount;
import Service.TicketService.SetTicket;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String leftAlignFormat = "| %-3d | %-30s |%n";
        do {
            System.out.format("+-----+----------------------------------+%n");
            System.out.format("| Số  |           Lựa chọn               |%n");
            System.out.format("+-----+----------------------------------+%n");
            System.out.format("|  1  |   Xem thông tin các chuyến bay   +%n");
            System.out.format("|  2  | Tìm kiếm số hiệu máy bay của bạn +%n");
            System.out.format("+-----+----------------------------------+%n");

            InputAndInfoHelper inputAndInfoHelper = new InputAndInfoHelperImpl();
            ISetCustomer setCustomer = new SetCustomerImpl();
            int yourOption = inputAndInfoHelper.inputIntNum("Mời bạn nhập lựa chọn: ", "Lựa chọn cần là số");


            if (yourOption == 1) {
                System.out.println("********* Bạn đang xem thông tin các chuyến bay *********");
                System.out.println("*********     Danh sách các chuyến bay hiện tại    *********");
                FlightsInfor[] flightsInfors = FlightsInfor.values();
                System.out.format("+---------+---------------------------+--------------------+-----------------------+--------------------------+-----------------------+%n");
                System.out.format("| Số hiệu |        Điểm khởi hành     |      Điểm đến      |     Giờ khởi hành     |         Giờ đến          |     Đơn vị cung cấp   |%n");
                System.out.format("+---------+---------------------------+--------------------+-----------------------+--------------------------+-----------------------+%n");
                for (FlightsInfor flightsInfor : flightsInfors) {
                    System.out.format("|  " + flightsInfor.getFlightCode() + "  |      " + flightsInfor.getDeparture() + "                  "
                            + flightsInfor.getDestination() + "              " + flightsInfor.getFlightDepartureTime() + "           "
                            + flightsInfor.getFlightReachingTime() + "        " + flightsInfor.getProviderUnit() + "       " + "%n");
                }
                System.out.println();
                System.out.println("-------------------------- Mời bạn tiếp tục lựa chọn! --------------------------");
                System.out.println();
            } else if (yourOption == 2) {
                ISetTicket setTicket = new SetTicket();
                ISetDiscount setDiscount = new SetDiscount();
                CustomerEdit customerEdit = new CustomerEditImpl();

                //Show Flight Information
                FlightsInfor flightsInforCode = inputAndInfoHelper.findEqualString();
                System.out.println();
                System.out.println();
                System.out.println("************ Chúc mừng bạn đã tìm được chuyến bay của mình!!! ************");
                System.out.println();
                System.out.println();

                //Input Customer Information
                System.out.println("Bạn có muốn đặt vé vừa tìm không? Nhấn \"enter\" để tiếp tục hoặc \"no\" để thoát!");
                String selectOpt = inputAndInfoHelper.inputString("Mời nhập lựa chọn: ");
                if(inputAndInfoHelper.standardLizeString(selectOpt).equals("no")){
                    System.out.println();
                    System.out.println("*************** Cảm ơn bạn đã dùng dịch vụ! ***************");
                    break;
                }
                Set<Customer> customerSet = setCustomer.inputCustomerSet();
                setCustomer.infoCustomerSet(customerSet);

                //Edit Customer

                System.out.println("Bạn có muốn sửa thông tin của bạn trên vé. Nhấn \'yes\' để tiếp tục");
                String editNextOpt = inputAndInfoHelper.inputString("Mời bạn nhập lựa chọn: ");
                if(inputAndInfoHelper.standardLizeString(editNextOpt).equals("yes")){
                    customerSet = customerEdit.editCustomerSet(customerSet);
                    setCustomer.infoCustomerSet(customerSet);
                }

                System.out.println("Bạn có muốn xoá thông tin của bạn trên vé. Nhấn \'yes\' để tiếp tục");
                String deleteNextOpt = inputAndInfoHelper.inputString("Mời bạn nhập lựa chọn: ");
                if(inputAndInfoHelper.standardLizeString(deleteNextOpt).equals("yes")){
                    customerEdit.deleteCustomer(customerSet);
                    setCustomer.infoCustomerSet(customerSet);
                }

                // Payment Section
                String payOpt = inputAndInfoHelper.inputString("Bạn có muốn thanh toán luôn vé mới đặt?" +
                        " Nhập \"no\" nếu muốn thoát");
                if(inputAndInfoHelper.standardLizeString(payOpt).equals("no")){
                    System.out.println("Cảm ơn bạn đã dùng dịch vụ!");
                    break;
                }
                setTicket.showTicketInfo();
                TicketInfo ticketInfoPrice = setTicket.findTicket(flightsInforCode);
                System.out.format("+-------------------------------------------------------------------------+%n");
                System.out.println("       Tổng chi phí quý khách cần thành toán: "
                        + setDiscount.priceByDiscount(setTicket.calculateSumOfTicket(ticketInfoPrice)) + "VND");
                System.out.println();
                System.out.format("+---------------------------------------------------------------------------------" +
                        "-----------------------------------------------------------------+%n");
                System.out.println("Vui lòng thanh toán số tiền trên, quý khách sẽ sớm được phản hồi sớm nhất. " +
                        "Cảm ơn bạn đã đặt vé! Chúc bạn có chuyến đi vui vẻ!");
                System.out.format("+---------------------------------------------------------------------------------" +
                        "-----------------------------------------------------------------+%n");
                break;
            }
        }while (true);
    }
}
