package Service.CustomerService;

import Model.Customer;
import Service.Helper.InputAndInfoHelper;
import Service.Helper.InputAndInfoHelperImpl;

import java.util.HashSet;
import java.util.Set;

public class SetCustomerImpl implements ISetCustomer{
    @Override
    public Customer inputCustomer() {
        InputAndInfoHelper inputAndInfoHelper = new InputAndInfoHelperImpl();
        Customer customer = new Customer();
        customer.setCustomerNumber(inputAndInfoHelper.inputIntNum("Mời nhập số CMT", "Mã khách hàng là số, Mời nhập lại!"));
        customer.setCustomerName(inputAndInfoHelper.inputString("Mời nhập tên khách hàng: "));
        customer.setAge(inputAndInfoHelper.inputIntNum("Mời nhập tuổi: ", "Tuổi phải là số, mời nhập lại!"));
        customer.setGender(inputAndInfoHelper.inputString("Mời nhập giới tính: "));
        customer.setNationality(inputAndInfoHelper.inputString("Mời nhập quốc tịch: "));
        customer.setCustomerAddress(inputAndInfoHelper.inputString("Mời nhập địa chỉ: "));
        customer.setCustomerEmail(inputAndInfoHelper.inputString("Mời nhập địa chỉ email: "));
        customer.setPhoneNumber(inputAndInfoHelper.inputString("Mời nhập số điện thoại: "));
        return customer;
    }

    @Override
    public void infoCustomer(Customer customer) {
        InputAndInfoHelper inputAndInfoHelper = new InputAndInfoHelperImpl();
        inputAndInfoHelper.infoIntNum("Số CMT: ", customer.getCustomerNumber());
        inputAndInfoHelper.infoString("Tên khách hàng: ", customer.getCustomerName());
        inputAndInfoHelper.infoIntNum("Tuổi của khách hàng: ", customer.getAge());
        inputAndInfoHelper.infoString("Giới tính của khách hàng: ", customer.getGender());
        inputAndInfoHelper.infoString("Quốc tịch của khách hàng: ", customer.getNationality());
        inputAndInfoHelper.infoString("Địa chỉ khách hàng: ", customer.getCustomerAddress());
        inputAndInfoHelper.infoString("Email của khách hàng: ", customer.getCustomerEmail());
        inputAndInfoHelper.infoString("Số điện thoại của khách hàng: ", customer.getPhoneNumber());
        System.out.println("----------------------------------------------------------------------------");
    }

    @Override
    public Set<Customer> inputCustomerSet() {
        InputAndInfoHelper inputAndInfoHelper = new InputAndInfoHelperImpl();
        Set<Customer> customerSet = new HashSet<Customer>();
        while (true){
            Customer customer = inputCustomer();
            customerSet.add(customer);
            System.out.println("Cảm ơn bạn đã đặt vé. Bạn có muốn tiếp tục nhập thêm vé? Nhấn \"No\" nếu muốn thoát.");
            String opt = inputAndInfoHelper.inputString("Mời nhập lựa chọn: ");
            if(inputAndInfoHelper.standardLizeString(opt).equals("no")){
                break;
            }
        }
        return customerSet;
    }

    @Override
    public void infoCustomerSet(Set<Customer> customerSet) {
        System.out.println();
        System.out.println("--------------------- Thông tin danh sách vé đã đặt: ---------------------");
        System.out.println();
        for (Customer customer : customerSet){
            infoCustomer(customer);
        }
        System.out.println();
    }
}
