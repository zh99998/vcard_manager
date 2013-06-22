package edu.sdkd.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static String getCurrentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		return formatter.format(curDate);
	}

}
