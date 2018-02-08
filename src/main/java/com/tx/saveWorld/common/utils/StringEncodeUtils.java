package com.tx.saveWorld.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 将编号根据特殊规则进行编码和解码
 * 
 * @ClassName: StringEncodeUtil
 * @Description:
 * @author W.J
 * @date Mar 27, 2014 8:19:43 AM
 */
public class StringEncodeUtils {

	static List<String> src = new ArrayList<String>();

    static List<String> out = new ArrayList<String>();

	static List<String> letters = new ArrayList<String>();

	static String initialize = "685739";
	static {
		for (int i = 0; i < 10; i++) {
			src.add(i + "");
		}
		out.add(6 + "");
		out.add(5 + "");
		out.add(0 + "");
		out.add(4 + "");
		out.add(7 + "");
		out.add(3 + "");
		out.add(8 + "");
		out.add(9 + "");
		out.add(2 + "");
		out.add(1 + "");
		letters.add("b");
		letters.add("x");
		letters.add("c");
		letters.add("d");
		letters.add("w");
		letters.add("g");
		letters.add("h");
		letters.add("e");
		letters.add("j");
		letters.add("f");
	}

	public static void main(String[] args) {
		Long in = (long) 649;
		String en = encrypt(in);
		System.out.println("en:" + en);
		String de = "";
		try {
			de = decrypt("");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("de:" + de);
	}

	/**
	 * 将指定的字符进行特殊规则进行编码
	 * 
	 * @param str
	 * @return
	 */
	public static String encrypt(Long value) {
		if (value == null)
			return null;
		String str = value.toString();
		String letter = getLetter(str);
		str = initialize + str;
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			String subChar = str.substring(i, i + 1);
			if(StringUtils.isEmpty(subChar)){
				continue;
			}
			int index = src.indexOf(subChar);
			if(index < 0){//错误返回-1
				continue;
			}
			result.append(out.get(index));
		}
		return letter + result.toString();
	}

	/**
	 * 根据特殊规则将字符串解码
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String str) throws Exception {
		if (StringUtils.isEmpty(str))
			return null;
		String letter = str.replaceAll("\\d+", "");
		String number = str.replace(letter, "");
		StringBuffer letNumber = new StringBuffer();
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < letter.length(); i++) {
			String subChar = letter.substring(i, i + 1);
			if(StringUtils.isEmpty(subChar)){
				continue;
			}
			int index = letters.indexOf(subChar);
			if(index < 0){//错误返回-1
				continue;
			}
			letNumber.append(src.get(index));
		}
		for (int i = 0; i < number.length(); i++) {
			String subChar2 = number.substring(i, i + 1);
			if(StringUtils.isEmpty(subChar2)){
				continue;
			}
			int index2 = out.indexOf(subChar2);
			if(index2 < 0){//错误返回-1
				continue;
			}
			result.append(src.get(index2));
		}
		String letNumberStr = letNumber.toString();
		String resultStr = result.toString();
		if(StringUtils.isEmpty(letNumberStr) || StringUtils.isEmpty(resultStr)){
			throw new Exception("the decoding null [result:" + resultStr + "]");
		}
		// 获取到字符串相对应的数字进行比较是否相同，如果不相同那么抛出异常
		int letterLeng = Integer.parseInt(letNumberStr.substring(0, 1));
		if(resultStr.length() < letNumberStr.length()){
			throw new Exception("the decoding error [result:" + resultStr + "]");
		}
		String lett = resultStr.substring(0, letNumberStr.length());
		if (lett.equalsIgnoreCase(letNumberStr)) {
			resultStr = resultStr.substring(letter.length(), resultStr.length());
		}
		else {
			throw new Exception("the decoding fails [result:" + resultStr + "]");
		}
		// 判断是否解码后的值相同
		if(letNumberStr.length() < letterLeng){
			throw new Exception("the decoding error [letNumberStr:" + letNumberStr + "]");
		}
		String id = letNumberStr.substring(letterLeng, letNumberStr.length());
		if (id.equals(resultStr)) {
			return resultStr;
		}
		else {
			throw new Exception("the value after decoding isn't same [id:" + id + "] [result:" + resultStr + "]");
		}
	}

	/**
	 * 根据UUID获取到随机数字，在将数字转换成规定的字母
	 * 
	 * @return
	 */
	public static String getLetter(String str) {
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < uuidStr.length(); i++) {
			String n = uuidStr.substring(i, i + 1);
			if (isNumeric(n)) {
				sb.append(n);
			}
		}
		String num = sb.toString();
		if (num != null && num.length() >= 8) {
			initialize = "9" + num.substring(0, 8) + str;
		}
		else {
			initialize = (num.length() + 1) + num + str;
		}

		StringBuffer letter = new StringBuffer();
		for (int i = 0; i < initialize.length(); i++) {
			String subChar = initialize.substring(i, i + 1);
			if(StringUtils.isEmpty(subChar)){
				continue;
			}
			int index = src.indexOf(subChar);
			if(index < 0){//错误返回-1
				continue;
			}
			letter.append(letters.get(index));
		}
		return letter.toString();
	}

	/**
	 * 判断是否是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			int chr = str.charAt(i);
			if (chr < 48 || chr > 57)
				return false;
		}
		return true;
	}
}
