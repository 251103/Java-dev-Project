package project;
import java.util.*;
  					// Task 4 CurrencyConvertor
public class CurrencyConvertor {
	private static final Map<String, String> countryToCurrency = new HashMap<>();
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        countryToCurrency.put("United States", "USD");
        countryToCurrency.put("European Union", "EUR");
        countryToCurrency.put("United Kingdom", "GBP");
        countryToCurrency.put("India", "INR");
        countryToCurrency.put("Australia", "AUD");
        countryToCurrency.put("Canada", "CAD");
        countryToCurrency.put("Singapore", "SGD");
        countryToCurrency.put("Switzerland", "CHF");
        countryToCurrency.put("Malaysia", "MYR");
        countryToCurrency.put("Japan", "JPY");
        countryToCurrency.put("China", "CNY");
        countryToCurrency.put("Hong Kong", "HKD");
        countryToCurrency.put("New Zealand", "NZD");
        countryToCurrency.put("Sweden", "SEK");
        countryToCurrency.put("South Korea", "KRW");
        countryToCurrency.put("South Africa", "ZAR");
        countryToCurrency.put("Turkey", "TRY");
        countryToCurrency.put("Russia", "RUB");
        countryToCurrency.put("Brazil", "BRL");
        countryToCurrency.put("Mexico", "MXN");

        exchangeRates.put("USD", 1.0);     
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.0);
        exchangeRates.put("AUD", 1.35);
        exchangeRates.put("CAD", 1.25);
        exchangeRates.put("SGD", 1.35);
        exchangeRates.put("CHF", 0.92);
        exchangeRates.put("MYR", 4.15);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("CNY", 6.47);
        exchangeRates.put("HKD", 7.78);
        exchangeRates.put("NZD", 1.45);
        exchangeRates.put("SEK", 8.62);
        exchangeRates.put("KRW", 1150.0);
        exchangeRates.put("ZAR", 14.5);
        exchangeRates.put("TRY", 8.6);
        exchangeRates.put("RUB", 72.5);
        exchangeRates.put("BRL", 5.2);
        exchangeRates.put("MXN", 20.0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the country from which you want to convert (e.g., India, Japan): ");
        String baseCountry = scanner.nextLine();
        System.out.print("Enter the amount in " + baseCountry + ": ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter the country to which you want to convert (e.g., Japan, India): ");
        String targetCountry = scanner.nextLine();

        String baseCurrency = countryToCurrency.get(baseCountry);
        String targetCurrency = countryToCurrency.get(targetCountry);

        if (baseCurrency != null && targetCurrency != null) {
            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
            if (exchangeRate != -1) {
                double convertedAmount = amount * exchangeRate;
                System.out.printf("%.2f %s in %s is %.2f %s\n", amount, baseCurrency, targetCountry, convertedAmount, targetCurrency);
            } else {
                System.out.println("Failed to retrieve exchange rate.");
            }
        } else {
            System.out.println("One or both countries are not supported.");
        }

        scanner.close();
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        if (exchangeRates.containsKey(baseCurrency) && exchangeRates.containsKey(targetCurrency)) {
            double baseRate = exchangeRates.get(baseCurrency);
            double targetRate = exchangeRates.get(targetCurrency);
            return targetRate / baseRate;
        } else {
            System.out.println("One or both currency codes are invalid.");
            return -1;
        }
    }
}
