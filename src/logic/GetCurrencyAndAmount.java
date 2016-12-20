package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;

import configuration.AlertMsg;
import javafx.scene.control.Alert.AlertType;

public class GetCurrencyAndAmount {

	AlertMsg alertMsg = new AlertMsg();
	private static List<String> listCurrencies = (List<String>) Arrays.asList("USD", "EUR", "GBP", "CHF", "XAU", "TEST");

	public String getCurrencyExchangeBSH() {

		// Declaration of variables
		String urlBankaShqip = "https://www.bankofalbania.org/web/kursi_i_kembimit_2014_1.php";
		String utf8 = "UTF-8";
		URL bankaShqipURL = null;
		URLConnection yc = null;;
		BufferedReader in = null;
		String inputLine = null;
		StringBuilder a = new StringBuilder();
		
		try {
			bankaShqipURL = new URL(urlBankaShqip);
		} catch (MalformedURLException e) {
			
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "Website " + urlBankaShqip + " nuk mund te gjendet\n" + null, ExceptionUtils.getStackTrace(e));
		}
		
		try {
			yc = bankaShqipURL.openConnection();
		} catch (IOException e) {
			
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "Website " + urlBankaShqip + " nuk mund te gjendet\n" + null, ExceptionUtils.getStackTrace(e));
		}
		
		try {
			in = new BufferedReader(new InputStreamReader( yc.getInputStream(), utf8));
		} catch (UnsupportedEncodingException e) {
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", "UnsupportedEncodingException " + utf8 + " \n" + null, ExceptionUtils.getStackTrace(e));
		} catch (IOException e) {
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", null, ExceptionUtils.getStackTrace(e));
		}
		
		try {
			while ((inputLine = in.readLine()) != null)
				a.append(inputLine);
			
			in.close();
			
		} catch (IOException e) {
			alertMsg.alertMsg(AlertType.ERROR, "Asycuda Converter", null, ExceptionUtils.getStackTrace(e));
		}

		return a.toString();
	}

	public String getCurrency(String currencyString, String currencyExchange) {

		currencyExchange = currencyExchange.substring(currencyExchange.indexOf("<TD nowrap>" + currencyString + "</TD>            <td align=\"right\" nowrap>") + 56);
		currencyExchange = currencyExchange.substring(0, currencyExchange.indexOf("</td>"));
		
		if(currencyExchange.length() > 30) {
			
			System.err.println("***** ERROR *****\n "
					+ "THE CURRENCY: " + currencyString + " HAS VALUE: " + currencyExchange);
			
			return "0";
		} else {
			return currencyExchange;
		}
	}
	
	public BigDecimal calcAmountNationalCurr(String amountForegCurr, String currCode, String currencyExchangeRoot) {

		String currString = "";
		BigDecimal amountNationalCurr = null;
		
		if(currCode == null) {
			System.err.println("***** ERROR *****\n "
					+ "SOMETHING WRONG WITH AMOUNT\n "
					+ "currCode: " + currCode);
			
			return BigDecimal.ZERO;
		}
		
		if(amountForegCurr == null) {
			System.err.println("***** ERROR *****\n "
					+ "SOMETHING WRONG WITH AMOUNT\n "
					+ "amountForegCurr: " + amountForegCurr);
			
			return BigDecimal.ZERO;
		}
		
		if(currCode.equalsIgnoreCase("EUR")) {

			GetCurrencyAndAmount currency = new GetCurrencyAndAmount();
			String currencyExchange = currencyExchangeRoot;
			
			currString = currency.getCurrency(currCode, currencyExchange);
		}
		
		if(!currString.equals("")) {
			BigDecimal amountForegCurrDec = new BigDecimal(amountForegCurr);
			BigDecimal currStringDec = new BigDecimal(currString);
			
			amountNationalCurr = amountForegCurrDec.multiply(currStringDec);
			
			// One decimal place
			amountNationalCurr = amountNationalCurr.setScale(0, RoundingMode.UP);
			amountNationalCurr = amountNationalCurr.setScale(1, RoundingMode.UP);
		} else {
			
			System.err.println("***** ERROR *****\n "
					+ "SOMETHING WRONG WITH AMOUNT ");
			
			return BigDecimal.ZERO;
		}

		return amountNationalCurr;
	}
	
}
