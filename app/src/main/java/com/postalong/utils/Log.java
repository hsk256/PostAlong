package com.postalong.utils;

/**
 * 自定义日志：带开关
 * 
 * @author carmack
 * 
 */
public class Log {

	private final static boolean DEBUG = true;

	public static void i(String key, String value) {
		if (DEBUG) {
			android.util.Log.i(key, value);
		}

	}

	public static void e(String key, String value) {
		if (DEBUG) {
			android.util.Log.e(key, value);
		}

	}

	public static void d(String key, String value) {
		if (DEBUG) {
			android.util.Log.d(key, value);
		}

	}
}
