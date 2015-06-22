package com.bhavit.pnrexpress.util;

import java.util.HashMap;
import java.util.Hashtable;

public class AppConstants {

	public static Hashtable<String, String> quotas = new Hashtable<String, String>();
	
	public static Hashtable<String, String> getQuotas() {
		
	
		quotas.put("GENERAL", "GN");
		quotas.put("TATKAL", "CK");
		quotas.put("LADIES QUOTA", "LD");
		quotas.put("DEFENCE QUOTA", "DF");
		quotas.put("FOREIGN TOURIST", "FT");
		quotas.put("DUTY PASS QUOTA", "DP");
		quotas.put("HANDICAPPED QUOTA", "HP");
		quotas.put("PARLIAMENT HOUSE QUOTA", "PH");
		quotas.put("LOWER BERTH QUOTA", "SS");
		quotas.put("YUVA QUOTA", "YU");
		
		return quotas;
	}
	
	
	public static String getQuotaValue(String key){

		return quotas.get(key);
		
	}
	
}
