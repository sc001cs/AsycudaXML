package modules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetCurrency {

	private static List<String> listCurrencies = (List<String>) Arrays.asList("USD", "EUR", "GBP", "CHF", "XAU", "TEST");
	
	public static void main(String[] args) throws IOException  {

		GetCurrency currency = new GetCurrency();

		String currencyExchange = currency.getCurrencyExchange();
		
		for(String currencyString : listCurrencies) {
			
			String currString = currency.getCurrency(currencyString, currencyExchange);
			System.out.println("LEK to " + currencyString + ": " + currString);
			
		}
		
	}

	public String getCurrencyExchange() throws IOException {

		URL bankaShqipURL = new URL("https://www.bankofalbania.org/web/kursi_i_kembimit_2014_1.php");
		URLConnection yc = bankaShqipURL.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuilder a = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			a.append(inputLine);
		in.close();

		return a.toString();
	}

	public String getCurrency(String currencyString, String currencyExchange) {

		currencyExchange = currencyExchange.substring(currencyExchange.indexOf("<TD nowrap>" + currencyString + "</TD>            <td align=\"right\" nowrap>") + 56);
		currencyExchange = currencyExchange.substring(0, currencyExchange.indexOf("</td>"));
		
		if(currencyExchange.length() > 30)
			return "0";
		else
			return currencyExchange;
		
	}
	
}
