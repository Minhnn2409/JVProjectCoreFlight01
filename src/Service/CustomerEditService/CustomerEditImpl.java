package Service.CustomerEditService;

import Model.Customer;
import Service.CustomerService.ISetCustomer;
import Service.CustomerService.SetCustomerImpl;
import Service.Helper.InputAndInfoHelper;
import Service.Helper.InputAndInfoHelperImpl;

import java.util.Iterator;
import java.util.Set;

public class CustomerEditImpl implements CustomerEdit{
    @Override
    public Set<Customer> editCustomerSet(Set<Customer> customerSet) {
        InputAndInfoHelper inputAndInfoHelper = new InputAndInfoHelperImpl();
        ISetCustomer setCustomer = new SetCustomerImpl();
        int editCustomerCode = inputAndInfoHelper.inputIntNum("Mời nhập số CMT khách hàng cần thay đổi thông tin: ", "số CMT phải là số");
        for (Customer customer : customerSet){
            if(editCustomerCode == customer.getCustomerNumber()){
                customerSet.remove(customer);
                Customer newCustomer = setCustomer.inputCustomer();
                customerSet.add(newCustomer);
                String keepEditingCustomer = inputAndInfoHelper.inputString("Bạn có muốn tiếp tục sửa đổi thông tin? Nhấn \'no\' để thoát");
                if(inputAndInfoHelper.standardLizeString(keepEditingCustomer).equals("no")){
                    break;
                }
            }
        }
        return customerSet;
    }

    @Override
    public void deleteCustomer(Set<Customer> customerSet) {
        Iterator<Customer> customerIterator = customerSet.iterator();
        InputAndInfoHelper inputAndInfoHelper = new InputAndInfoHelperImpl();
        int editCustomerCode = inputAndInfoHelper.inputIntNum("Mời nhập số CMT khách hàng cần thay đổi thông tin: ", "số CMT phải là số");
        while (customerIterator.hasNext()){
            Customer customer = customerIterator.next();
            if(editCustomerCode == customer.getCustomerNumber()){
                customerIterator.remove();
            }
            String keepDeletingCustomer = inputAndInfoHelper.inputString("Bạn có muốn tiếp tục xoá thông tin? Nhấn \'no\' để thoát");
            if(inputAndInfoHelper.standardLizeString(keepDeletingCustomer).equals("no")){
                break;
            }
        }
    }
}


