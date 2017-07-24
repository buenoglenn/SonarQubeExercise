package demo;

import org.apache.commons.lang.NumberUtils;

public class Price {
	private String originalValue;
	private String symbol;
	private Double value;
	private boolean isPrice = false;

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static Price createFrom(String value) {
		return new Price(value);
	}

	public static Price createFrom(String symbol, String value) {
		if (NumberUtils.isNumber(value)) {
			double doubleValue = Double.valueOf(value);
			if (doubleValue < 0) {
				String priceString = "-" + symbol + Math.abs(doubleValue);
//				System.out.println("created " + priceString);
				return new Price(priceString);				
			} else {
				String priceString = symbol + doubleValue;
//				System.out.println("created " + priceString);
				return new Price(priceString);
			}
		} else { 
			return new Price(value);
		}
	}

	private Price(String value) {
		super();
		this.originalValue = value;
		if (CurrencyUtil.isCurrency(value)) {
			this.symbol = CurrencyUtil.getDollarPart(value);
			this.value = Double.valueOf(CurrencyUtil.getNumericPart(value));
			this.isPrice = true;
		} else {
			this.symbol = CurrencyUtil.DOLLAR_SYMBOL;
			this.value = 0D;
		}
	}

	public String getSymbol() {
		return symbol;
	}

	public Double getValue() {
		return value;
	}

	public boolean isPrice() {
		return isPrice;
	}

	/**
	 * gets the currency format as String
	 * 
	 * $100.01 -$100.01
	 * 
	 */
	@Override
	public String toString() {
		if (this.isPrice) {
			Double absoluteValue = Math.abs(value);

			String stringFormat = symbol.concat(absoluteValue.toString());

			if (value < 0) {
				stringFormat = "-".concat(stringFormat);
			}

			return stringFormat;
		} else {
			return originalValue;
		}
	}

	public static void main(String[] args) {
//		test("101.10");
//		test("$101.10");
//		test("-$101.10");
//		test("101.10");
		testDouble("$", "1.12");
		testDouble("$", "-1.12");
		testDouble("P", "1.12");
		testDouble("P", "1.12a");
		testDouble("P", "-1.12a");
	}

	private static void testDouble(String symbol, String value) {
		Price price = Price.createFrom(symbol, value);
		System.out.println(price.isPrice + " symbol: " + symbol + " value: " + value + " = " + price);
	}

	private static void test(String value) {
		Price price = Price.createFrom(value);
		System.out.println(price.isPrice + " " + value + " = " + price);
	}

}
