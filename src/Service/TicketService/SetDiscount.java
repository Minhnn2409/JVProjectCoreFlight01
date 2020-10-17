package Service.TicketService;

import Model.Discount;
import Service.Helper.InputAndInfoHelper;
import Service.Helper.InputAndInfoHelperImpl;

public class SetDiscount implements ISetDiscount{
    @Override
    public double priceByDiscount(double initialPrice) {
        Discount[] discounts = Discount.values();
        InputAndInfoHelper inputAndInfoHelper = new InputAndInfoHelperImpl();
        String inputDiscountCode = inputAndInfoHelper.inputString("Mời nhập mã giảm giá(nếu có): ");
        for (Discount discount : discounts){
            if(inputAndInfoHelper.standardLizeString(inputDiscountCode).equals(discount.getDiscountCode())){
                return (initialPrice*discount.getRateDiscount());
            }
        }
        return initialPrice;
    }
}
