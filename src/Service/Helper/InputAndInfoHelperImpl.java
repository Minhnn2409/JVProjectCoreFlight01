package Service.Helper;

import Model.FlightsInfor;
import java.util.*;

public class InputAndInfoHelperImpl implements InputAndInfoHelper {

    @Override
    public String inputString(String msg) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println(msg);
        String str = scanner1.nextLine();
        return str;
    }

    @Override
    public void infoString(String msg, String str) {
        System.out.println(msg + str);
    }

    @Override
    public int inputIntNum(String msg, String err) {
        int num = 0;
        do {
            try{
                Scanner scanner2 = new Scanner(System.in);
                System.out.println(msg);
                num = scanner2.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println(err);
            }
        }while (true);
        return num;
    }

    @Override
    public void infoIntNum(String msg, int num) {
        System.out.println(msg + num);
    }

    @Override
    public double inputDoubleNum(String msg, String err) {
        double doubleNum = 0;
        do {
            try{
                Scanner scanner3 = new Scanner(System.in);
                System.out.println(msg);
                doubleNum = scanner3.nextDouble();
                break;
            }catch (InputMismatchException e){
                System.out.println(err);
            }
        }while (true);
        return doubleNum;
    }

    @Override
    public void infoDoubleNum(String msg, double doubleNum) {
        System.out.println(msg + doubleNum);
    }

    @Override
    public FlightsInfor findEqualString() {
        InputAndInfoHelper inputAndInfoHelper1 = new InputAndInfoHelperImpl();
        do {
//            int check = 1;
            String flightCode = inputAndInfoHelper1.inputString("Mời nhập mã chuyến bay: ");
            flightCode = inputAndInfoHelper1.standardLizeString(flightCode);
            for (FlightsInfor flightsInfors : FlightsInfor.values()){
                if(flightsInfors.getFlightCode().equals(flightCode)){
                    System.out.println("Chuyến bay bạn cần tìm: ");
                    System.out.format("+---------+---------------------------+--------------------+-----------------------+--------------------------+-----------------------+%n");
                    System.out.format("| Số hiệu |        Điểm khởi hành     |      Điểm đến      |     Giờ khởi hành     |         Giờ đến          |     Đơn vị cung cấp   |%n");
                    System.out.format("+---------+---------------------------+--------------------+-----------------------+--------------------------+-----------------------+%n");
                    System.out.format("| " + flightsInfors.getFlightCode() + "           " + flightsInfors.getDeparture() + "                     " + flightsInfors.getDestination()
                            + "             " + flightsInfors.getFlightDepartureTime()+ "         " +flightsInfors.getFlightReachingTime() + "             " + flightsInfors.getProviderUnit() +"%n");
                    System.out.format("+---------+---------------------------+--------------------+-----------------------+--------------------------+-----------------------+%n");
                    return flightsInfors;
                }
            }
            System.out.println("Không có chuyến bay nào phù hợp, mời nhập lại");
        }while (true);
    }

    @Override
    public String standardLizeString(String str) {
        String newStr = str.trim().toLowerCase();
        while (newStr.contains("  ")){
            newStr = newStr.replace("  ", "");
        }
        return newStr;
    }
}
