package com.iii.pos.common;

@SuppressWarnings("javadoc")
public class Cache {

	// Lưu giữ dữ liệu tên đăng nhập
	private static String CacheUserData = "";
	private static String CacheUserPass = "";
	private static boolean isLogin = false;

	private static String[] CacheSettings;
	
	public static boolean getLoginState(){
		return isLogin;
	}
	public static void setLoginState(boolean _isLogin){
		isLogin = _isLogin;
	}

	public static String getCacheUserData() {
		return CacheUserData;
	}

	public static void setCacheUserData(String dataInput) {
		CacheUserData = dataInput;
	}

	public static String getCacheUserPass() {
		return CacheUserPass;
	}

	public static void setCacheUserPass(String cacheUserPass) {
		CacheUserPass = cacheUserPass;
	}

}
