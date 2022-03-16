package rc.course_enrollment.model.practice;

import java.util.Arrays;
import java.util.List;

public class Cashier {

    private static  final List<String>accepetedCurrencies = Arrays.asList("EUR", "GBP");

    public static double validateTransaction(String currency , double amount){

        if(currencyIsAccepted(currency) && amountIsValid(amount)){
            return  amount;
        }
        return  -1;
    }

    private static boolean currencyIsAccepted(String currency){
        if(!accepetedCurrencies.contains(currency)){
            throw  new IllegalArgumentException("Currency "+ currency +"not within accepted range");
        }
        return true;
    }

    private static  boolean amountIsValid(double amount){
   if(amount < 0){
       throw new InvalidAmount("Amount must be greater than 0");
   }
   return true;

    }
}
