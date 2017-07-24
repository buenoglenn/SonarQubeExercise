package demo;

public class CurrencyUtil {
	public static final String DOLLAR_SYMBOL = "$";

	protected static boolean isCurrency(Object fieldData) {
		return validateIfCurrency(fieldData);
	}

	protected static String getNumericPart(Object fieldData) {
		return getNumberPart(getFieldData(fieldData));
	}

	protected static String getDollarPart(Object fieldData) {
		String possibleDollarCharacter = getPossibleDollarCharacter(getFieldData(fieldData));
		return possibleDollarCharacter.equals(DOLLAR_SYMBOL)?possibleDollarCharacter:"";
	}
	
	private static String getPossibleDollarCharacter(String fieldDataAsString) {
		String firstCharacter = getFirst(fieldDataAsString);
		String secondCharacter = getSecond(fieldDataAsString);

		String prefixToTest = firstCharacter;

		if ("-".equals(prefixToTest)) {
			prefixToTest = secondCharacter;
		}
		return prefixToTest;
	}

	private static String getFirst(String numberAsString) {
		return numberAsString.substring(0, 1);
	}

	private static String getSecond(String numberAsString) {
		return numberAsString.substring(1, 2);
	}

	private static boolean hasDollarPrefix(String fieldDataAsString) {
		String prefixToTest = getPossibleDollarCharacter(fieldDataAsString);
		return DOLLAR_SYMBOL.equalsIgnoreCase(prefixToTest);
	}

	/*
	private static boolean validateIfNumeric(String numberPart) {
		return NumberUtils.isNumber(numberPart);
	}
	*/

	private static boolean validateIfCurrency(Object fieldData) {
		if (fieldData == null) {
			return false;
		}
		if (!(fieldData instanceof String)) {
			return false;
		}

		String fieldDataAsString = getFieldData(fieldData);
		if (fieldDataAsString.length() < 2) {
			return false;
		}

		/*
		String numberPart = getNumberPart(fieldDataAsString);
		if (!validateIfNumeric(numberPart)) {
			return false;
		}
		*/

		if (!hasDollarPrefix(fieldDataAsString)) {
			return false;
		}
		return true;
	}

	private static String getNumberPart(String fieldDataAsString) {
		String signum = fieldDataAsString.startsWith("-")?"-":"";
		return signum + fieldDataAsString.substring(fieldDataAsString.indexOf(DOLLAR_SYMBOL) + 1, fieldDataAsString.length());
	}

	private static String getFieldData(Object fieldData) {
		return (String) fieldData;
	}

	/**
	 * Testing field;
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		testCurrency("$101.01");
		testCurrency("-$101.01");
		testCurrency("101.01");
		testCurrency("a101.01");
		testCurrency("$101.01a");
		testCurrency("a101.ba");
		testCurrency("a101");
	}

	private static void testCurrency(String aString) {
		System.out.println(aString + " = " + isCurrency(aString));
	}
}
