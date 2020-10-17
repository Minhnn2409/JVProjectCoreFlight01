package Service.Helper;


import Model.FlightsInfor;
import Model.TicketInfo;



public interface InputAndInfoHelper {
    String inputString(String msg);
    void infoString(String msg, String str);
    int inputIntNum(String msg, String err);
    void infoIntNum(String msg, int num);
    double inputDoubleNum(String msg, String err);
    void infoDoubleNum(String msg, double doubleNum);
    FlightsInfor findEqualString();
    String standardLizeString(String str);

}
