package com.tirmizee.commons;

/**
 * @author tirmizee
 *
 */
public class StringUtils{
	
	public static boolean equals(String str1 , String str2 , String...strs) {
		boolean isEquals = equals(str1, str2);
		for (int i = 1,length = strs.length; isEquals && i < length; i++) {
			isEquals &= equals(strs[0], strs[i]);
		}
		return isEquals;
	}
	
	public static boolean equals(String str1 , String str2) {
		return (str1 == null) ? (str2 == null) : str1.equals(str2);
	}

}
