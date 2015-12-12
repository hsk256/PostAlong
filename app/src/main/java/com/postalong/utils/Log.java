package com.postalong.utils;

/**
 * 自定义日志：带开关
 * 
 * @author heshaokang
 * 
 */
public class Log {

	private final static boolean DEBUG = true;

	public static void i(String key, String value) {
		if (DEBUG) {
			try {
				android.util.Log.i(key, value);
			}catch (NullPointerException e) {
				e.printStackTrace();
			}

		}

	}

	public static void e(String key, String value) {
		if (DEBUG) {
			try {
				android.util.Log.e(key, value);
			}catch (NullPointerException e) {
				e.printStackTrace();
			}

		}

	}

	public static void d(String key, String value) {
		if (DEBUG) {
			try {
				android.util.Log.d(key, value);
			}catch (NullPointerException e) {
				e.printStackTrace();
			}

		}

	}
}
