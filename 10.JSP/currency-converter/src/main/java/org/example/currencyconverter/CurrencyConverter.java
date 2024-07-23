package org.example.currencyconverter;

public class CurrencyConverter {
    public static double Converter(String firstCurrency, String secondCurrency, String amountCurrency) {
        Double fNumber = Double.valueOf(firstCurrency);
        Double sNumber = Double.valueOf(secondCurrency);
        Double amount = Double.valueOf(amountCurrency);
        Double rate = fNumber / sNumber;
        return rate * amount;
    }
}
