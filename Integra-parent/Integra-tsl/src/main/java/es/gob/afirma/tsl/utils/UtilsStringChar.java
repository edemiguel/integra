// Copyright (C) 2012-15 MINHAP, Gobierno de España
// This program is licensed and may be used, modified and redistributed under the terms
// of the European Public License (EUPL), either version 1.1 or (at your
// option) any later version as soon as they are approved by the European Commission.
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
// or implied. See the License for the specific language governing permissions and
// more details.
// You should have received a copy of the EUPL1.1 license
// along with this program; if not, you may find it at
// http://joinup.ec.europa.eu/software/page/eupl/licence-eupl

/** 
 * <b>File:</b><p>es.gob.afirma.tsl.utils.UtilsStringChar.java.</p>
 * <b>Description:</b><p>Class that provides functionality for managing strings and characters.</p>
 * <b>Project:</b><p>Library for the integration with the services of @Firma, eVisor and TS@.</p>
 * <b>Date:</b><p>10/10/2020.</p>
 * @author Gobierno de España.
 * @version 1.0, 10/10/2020.
 */
package es.gob.afirma.tsl.utils;


/** 
 * <p>Class that provides functionality for managing strings and characters.</p>
 * <b>Project:</b><p>Library for the integration with the services of @Firma, eVisor and TS@.</p>
 * @version 1.0, 10/10/2020.
 */
public final class UtilsStringChar {
    /**
	 * Constructor method for the class UtilsStringChar.java.
	 */
	private UtilsStringChar() {
		super();
	}

	/**
	 * Constant attribute that represents the string to identify the empty string.
	 */
	public static final String EMPTY_STRING = "";

	/**
	 * Constant attribute that represents the char to identify the blank space character.
	 */
	public static final char SPECIAL_BLANK_SPACE = ' ';

	/**
	 * Constant attribute that represents the string to identify the blank space character.
	 */
	public static final String SPECIAL_BLANK_SPACE_STRING = String.valueOf(SPECIAL_BLANK_SPACE);

	/**
	 * Constant attribute that represents the string to identify the line separator character in this system.
	 */
	public static final String SPECIAL_SYSTEM_LINE_SEPARATOR_STRING = System.lineSeparator();

	/**
	 * Constant attribute that represents the char to identify the line break character.
	 */
	public static final char SPECIAL_LINE_BREAK = '\n';

	/**
	 * Constant attribute that represents the string to identify the line break character.
	 */
	public static final String SPECIAL_LINE_BREAK_STRING = String.valueOf(SPECIAL_LINE_BREAK);

	/**
	 * Constant attribute that represents the char to identify the line start character.
	 */
	public static final char SPECIAL_LINE_START = '\r';

	/**
	 * Constant attribute that represents the string to identify the line start character.
	 */
	public static final String SPECIAL_LINE_START_STRING = String.valueOf(SPECIAL_LINE_START);

	/**
	 * Constant attribute that represents the char to identify the tabulation character.
	 */
	public static final char SPECIAL_TABULATION = '\t';

	/**
	 * Constant attribute that represents the string to identify the tabulation character.
	 */
	public static final String SPECIAL_TABULATION_STRING = String.valueOf(SPECIAL_TABULATION);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>#</code>.
	 */
	public static final char SYMBOL_PAD = '#';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>#</code>.
	 */
	public static final String SYMBOL_PAD_STRING = String.valueOf(SYMBOL_PAD);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>&</code>.
	 */
	public static final char SYMBOL_AMPERSAND = '&';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>&</code>.
	 */
	public static final String SYMBOL_AMPERSAND_STRING = String.valueOf(SYMBOL_AMPERSAND);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>:</code>.
	 */
	public static final char SYMBOL_COLON = ':';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>:</code>.
	 */
	public static final String SYMBOL_COLON_STRING = String.valueOf(SYMBOL_COLON);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>;</code>.
	 */
	public static final char SYMBOL_SEMICOLON = ';';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>;</code>.
	 */
	public static final String SYMBOL_SEMICOLON_STRING = String.valueOf(SYMBOL_SEMICOLON);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>=</code>.
	 */
	public static final char SYMBOL_EQUAL = '=';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>=</code>.
	 */
	public static final String SYMBOL_EQUAL_STRING = String.valueOf(SYMBOL_EQUAL);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>-</code>.
	 */
	public static final char SYMBOL_HYPHEN = '-';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>-</code>.
	 */
	public static final String SYMBOL_HYPHEN_STRING = String.valueOf(SYMBOL_HYPHEN);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>,</code>.
	 */
	public static final char SYMBOL_COMMA = ',';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>,</code>.
	 */
	public static final String SYMBOL_COMMA_STRING = String.valueOf(SYMBOL_COMMA);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>.</code>.
	 */
	public static final char SYMBOL_DOT = '.';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>.</code>.
	 */
	public static final String SYMBOL_DOT_STRING = String.valueOf(SYMBOL_DOT);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>/</code>.
	 */
	public static final char SYMBOL_SLASH = '/';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>/</code>.
	 */
	public static final String SYMBOL_SLASH_STRING = String.valueOf(SYMBOL_SLASH);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>?</code>.
	 */
	public static final char SYMBOL_QUESTION_MARK = '?';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>?</code>.
	 */
	public static final String SYMBOL_QUESTION_MARK_STRING = String.valueOf(SYMBOL_QUESTION_MARK);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>\</code>.
	 */
	public static final char SYMBOL_ESCAPED_BACKSLASH = '\\';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>\</code>.
	 */
	public static final String SYMBOL_ESCAPED_BACKSLASH_STRING = String.valueOf(SYMBOL_ESCAPED_BACKSLASH);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>[</code>.
	 */
	public static final char SYMBOL_OPEN_SQUARE_BRACKET = '[';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>[</code>.
	 */
	public static final String SYMBOL_OPEN_SQUARE_BRACKET_STRING = String.valueOf(SYMBOL_OPEN_SQUARE_BRACKET);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>]</code>.
	 */
	public static final char SYMBOL_CLOSE_SQUARE_BRACKET = ']';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>]</code>.
	 */
	public static final String SYMBOL_CLOSE_SQUARE_BRACKET_STRING = String.valueOf(SYMBOL_CLOSE_SQUARE_BRACKET);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>(</code>.
	 */
	public static final char SYMBOL_OPEN_BRACKET = '(';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>(</code>.
	 */
	public static final String SYMBOL_OPEN_BRACKET_STRING = String.valueOf(SYMBOL_OPEN_BRACKET);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>)</code>.
	 */
	public static final char SYMBOL_CLOSE_BRACKET = ')';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>)</code>.
	 */
	public static final String SYMBOL_CLOSE_BRACKET_STRING = String.valueOf(SYMBOL_CLOSE_BRACKET);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>*</code>.
	 */
	public static final char SYMBOL_ASTERISK = '*';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>*</code>.
	 */
	public static final String SYMBOL_ASTERISK_STRING = String.valueOf(SYMBOL_ASTERISK);

	/**
	 * Constant attribute that represents the char to identify the symbol: <code>|</code>.
	 */
	public static final char SYMBOL_PIPE = '|';

	/**
	 * Constant attribute that represents the string to identify the symbol: <code>|</code>.
	 */
	public static final String SYMBOL_PIPE_STRING = String.valueOf(SYMBOL_PIPE);

	/**
	 * Constant attribute that represents the array with all the characters defined as constants in this class.
	 */
	public static final char[ ] CHARACTERS_SET_TO_VALIDATORS = new char[ ] { UtilsStringChar.SPECIAL_LINE_BREAK, UtilsStringChar.SPECIAL_LINE_START, UtilsStringChar.SPECIAL_TABULATION, UtilsStringChar.SYMBOL_PAD, UtilsStringChar.SYMBOL_COLON, UtilsStringChar.SYMBOL_SEMICOLON, UtilsStringChar.SYMBOL_EQUAL };

	/**
	 * Constant attribute that represents the token '0'.
	 */
	private static final char TOKEN_ZERO = '0';

	/**
	 * Method that checks whether a string is null or empty.
	 * @param str Parameter that represents the string to process.
	 * @return a boolean with <code>true</code> value whether the string is null or empty, or <code>false</code> value in another case.
	 */
	public static boolean isNullOrEmpty(String str) {

		if (str == null || str.isEmpty()) {

			return true;

		}
		return false;
	}

	/**
	 * Method that checks whether a string is null or empty after to apply the method {@link String#trim()} on.
	 * @param str Parameter that represents the string to process.
	 * @return a boolean with <code>true</code> value whether the string is null or empty, or <code>false</code> value in another case.
	 */
	public static boolean isNullOrEmptyTrim(String str) {

		if (str == null || str.trim().isEmpty()) {

			return true;

		}

		return false;

	}

	/**
	 * Method that checks whether a string contains some of the characters contained in {@link #CHARACTERS_SET_TO_VALIDATORS} (true) or not (false).
	 * @param str Parameter that represents the string to process.
	 * @return a boolean that indicates whether a string contains some of the characters contained in {@link #CHARACTERS_SET_TO_VALIDATORS}
	 * (true) or not (false).
	 */
	public static boolean containsSomeOfTheCharacterSet(String str) {

		return containsSomeOfTheCharacterSetInTheSet(str, UtilsStringChar.CHARACTERS_SET_TO_VALIDATORS);

	}

	/**
	 * Method that checks whether a string contains some of the characters contained in certain characters array (true) or not (false).
	 * @param str Parameter that represents the string to process.
	 * @param characterSet Parameter that represents the characters array to process.
	 * @return a boolean that indicates whether a string contains some of the characters contained in certain characters array
	 * (true) or not (false).
	 */
	public static boolean containsSomeOfTheCharacterSetInTheSet(String str, char[ ] characterSet) {

		// Si la cadena de entrada es nula o vacía, devolvemos false.
		if (UtilsStringChar.isNullOrEmpty(str)) {
			return false;
		}

		// Si el conjunto de caracteres es nulo o vacío, devolvemos true.
		if (characterSet == null || characterSet.length == 0) {
			return true;
		}

		// Recorremos todos los caracteres y comprobamos si alguno está
		// contenido
		// en la cadena que se recibe como parámetro.
		for (int index = 0; index < characterSet.length; index++) {

			char actualChar = characterSet[index];
			if (str.indexOf(actualChar) >= 0) {

				return true;

			}

		}

		// Si llegamos aquí, es que no contiene ninguno de los caracteres.
		return false;

	}

//	/**
//	 * Method that converts a byte array to a hexadecimal string.
//	 * @param data Parameter that represents the byte array to convert.
//	 * @param separate Parameter that indicates if to separate each two bytes with {@link #SYMBOL_HYPHEN} (true) or not (false).
//	 * @return an string with hexadecimal format.
//	 */
//	public static String convertByteArrayToHex(byte[ ] data, boolean separate) {
//		char[ ] c = Hex.encodeHex(data);
//		if (c == null || c.length == 0) {
//			return null;
//		}
//		StringBuilder resultSB = new StringBuilder();
//		byte numChars = 0;
//		if (c.length % 2 != 0) {
//			resultSB.append(TOKEN_ZERO);
//			numChars++;
//		}
//		for (int i = 0; i < c.length; i++) {
//			resultSB.append(c[i]);
//			if (separate) {
//				numChars++;
//				if (numChars % 2 == 0 && i < c.length - 1) {
//					resultSB.append(UtilsStringChar.SYMBOL_HYPHEN);
//				}
//			}
//		}
//		String result = resultSB.toString();
//		cleanStringBuilder(resultSB);
//		return result;
//	}

	/**
	 * To free resources, this method sets the length of the input {@link StringBuilder} to
	 * zero and then trim it.
	 * @param sb String builder to clean. If it is <code>null</code>, this method do nothing.
	 */
	public static void cleanStringBuilder(StringBuilder sb) {

		if (sb != null) {
			sb.setLength(0);
			sb.trimToSize();
		}

	}

	/**
	 * Removes all the blanks from the input string.
	 * It is considered how blanks: {@link UtilsStringChar#SPECIAL_BLANK_SPACE_STRING}, {@link UtilsStringChar#SPECIAL_LINE_BREAK_STRING},
	 * {@link UtilsStringChar#SPECIAL_LINE_START_STRING} and {@link UtilsStringChar#SPECIAL_TABULATION_STRING}.
	 * @param string String from what removes the blanks.
	 * @return a empty string if the input parameter is <code>null</code>, otherwise, the same input
	 * string after removes the blanks.
	 */
	public static String removeBlanksFromString(String string) {

		String result = EMPTY_STRING;

		// Si la cadena a tratar no es nula...
		if (string != null) {

			// Eliminamos los espacios por delante y detrás.
			result = string.trim();
			// Eliminamos los saltos de línea.
			result = result.replaceAll(SPECIAL_LINE_BREAK_STRING, EMPTY_STRING);
			// Eliminamos los indicadores de nueva línea.
			result = result.replaceAll(SPECIAL_LINE_START_STRING, EMPTY_STRING);
			// Eliminamos las tabulaciones.
			result = result.replaceAll(SPECIAL_TABULATION_STRING, EMPTY_STRING);
			// Eliminamos los espacios en blanco.
			result = result.replaceAll(SPECIAL_BLANK_SPACE_STRING, EMPTY_STRING);

		}

		return result;

	}
}
