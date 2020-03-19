package org.myProject.My_Contact_App.utility;

public class StringUtility {
	//This class contains utility method related to string operations
	public static String toCommaSeparatedString(Object[] words) {
		StringBuilder sb= new StringBuilder();
		for(Object word: words) {
			sb.append(word).append(",");
		}
		if(sb.length()>0) {
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
}	
