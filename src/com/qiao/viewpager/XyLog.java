package com.qiao.viewpager;

import android.util.Log;

/**
 * Log Show
 * @author 乔彬
 * @version 1.0.0
 */
public class XyLog {
	/** 是否打印日志的标识（true：打印日志，false：不打印日志， */
	public static final boolean IS_DEBUG = true;
	/** 日志标签 */
	public static String LOG_TAG = "zxxk_xueyi 1.0.0";

	/**
	 * 打印“verbose级别”的日志内容
	 * @param tag 日志的标签名
	 * @param msg 日志信息
	 */
	public static void v(String tag, String msg) {
		if (IS_DEBUG) {
			Log.v(tag, msg);
		}
	}

	/**
	 * 打印“info级别”的日志内容
	 * @param tag 日志的标签名
	 * @param msg 日志信息
	 */
	public static void i(String tag, String msg) {
		if (IS_DEBUG) {
			Log.i(tag, msg);
		}
	}

	/**
	 * 打印“debug级别”的日志内容
	 * @param tag 日志的标签名
	 * @param msg 日志信息
	 */
	public static void d(String tag, String msg) {
		if (IS_DEBUG) {
			Log.d(tag, msg);
		}
	}

	/**
	 * 打印“warn级别”的日志内容
	 * @param tag 日志的标签名
	 * @param msg 日志信息
	 */
	public static void w(String tag, String msg) {
		if (IS_DEBUG) {
			Log.w(tag, msg);
		}
	}

	/**
	 * 打印“error级别”的日志内容
	 * @param tag 日志的标签名
	 * @param msg 日志信息
	 */
	public static void e(String tag, String msg) {
		if (IS_DEBUG) {
			Log.e(tag, msg);
		}
	}

	/**
	 * 打印“任意自定义”的日志内容
	 * @param msg 日志信息
	 */
	public static void print(String msg) {
		if (IS_DEBUG) {
			System.out.println(msg);
		}
	}
	
	public static void print1(String msg){
		//System.out.println(msg);
	}
	
}

