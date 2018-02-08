package com.tx.saveWorld.common.utils;

import com.tx.saveWorld.common.constant.MarkConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class StringTools {

	public static void main(String[] args) {
		System.out.println(splitStr("wwwwwwwwwwwwwwwwwwwwwwwwwww232222321",5));
		System.out.println(getFilterMobile("13699452222"));
		System.out.println(getFilterTel("0832-2255412"));
		System.out.println(propertyToFieldName("adBssSSsss"));
		System.out.println(buildAddCode(11,22,44,55));
		System.out.println(convertLong("2233232,232323244,54444",",").toString());
	}

	/**
	 * 截取字符串,后面用...代替
	 * @param str
	 * @param length
     * @return
     */
	public static String splitStr(String str,int length){
		if(StringUtils.isBlank(str)){
			return null;
		}
		if(str.length() > length){
			str = str.substring(0, length) + "...";
		}
		return str;
	}

	/**
	 * 手机号加密
	 * @param mobile
	 * @return
     */
	public static String getFilterMobile(String mobile) {
		if (StringUtils.isNotBlank(mobile)) {
			return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
		}
		return mobile;
	}

	/**
	 * 电话号码加密
	 * @param tel
	 * @return
     */
	public static String getFilterTel(String tel) {
		if (StringUtils.isNotBlank(tel)) {
			return tel.replaceAll("(\\d*\\d)\\d{4}", "$1****");
		}
		return tel;
	}


	public static String deleteEmptyChar(String str) {
		if (str==null||str.length()==0) {
			return str;
		}
		return str.replaceAll("\\s","");
	}

	/**
	 * 将String aaBc 转为 aa_bc的格式的数据库字段名
	 *
	 * @param str
	 * @return
	 */
	public static String propertyToFieldName(String str) {
		if (StringUtils.isEmpty(str)) {
			return str;
		}
		if (str.charAt(0) > 'A' && str.charAt(0) < 'Z') {
			return str;
		}
		if (Character.isUpperCase(str.charAt(0))) {
			str = Character.toString(Character.toLowerCase(str.charAt(0))) + str.substring(1);
		}
		for (int i = 1; i < str.length(); i++) {
			char a = str.charAt(i);
			if (a >= 'A' && a <= 'Z') {
				if (str.charAt(i - 1) != '_') {
					str = str.replace(a + "", ("_" + a).toLowerCase());
					i++;
				}
				continue;
			}
		}
		return str;
	}


	public static String buildAddCode(Integer province,Integer city,Integer county,Integer towns){
		StringBuffer addressCode = new StringBuffer();
		Assert.notNull(province,"省不能为空");
		addressCode.append(province).append(MarkConstant.VERTICAL_LINE);
		Assert.notNull(province,"市不能为空");
		addressCode.append(city).append(MarkConstant.VERTICAL_LINE);
		Assert.notNull(province,"县/乡不能为空");
		addressCode.append(county).append(MarkConstant.VERTICAL_LINE);
		if(towns == null){
			return addressCode.toString();
		}
		addressCode.append(towns).append(MarkConstant.VERTICAL_LINE);
		return addressCode.toString();
	}

	public static List<Long> convertLong(String strings, String regex){
		if(StringUtils.isBlank(strings) || StringUtils.isBlank(regex)){
			return null;
		}
		String[] stringArr = strings.split(regex);
		List<Long> list = new ArrayList<>();
		for(String string : stringArr){
			list.add(Long.parseLong(string));
		}
		return list;
	}
}
