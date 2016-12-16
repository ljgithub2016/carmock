package com.ihavecar.carmock.config;


import java.util.ResourceBundle;

/**
 * 全局配置类
 */
public class Global {
	static String profile = "placeholder";
	
	static ResourceBundle resourceBundle = ResourceBundle.getBundle(profile);
	
    public static ResourceBundle getConfig(){
        return resourceBundle;
    }
	
	public static String getString(String paraName){
		return resourceBundle.getString(paraName);
	}
	
	public static int getInt(String paraName){
		return Integer.valueOf(resourceBundle.getString(paraName));
	}
	
	
	public static void main(String[] args) {
		System.out.println(getString("car.count"));
	}
}
