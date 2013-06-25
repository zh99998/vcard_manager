package edu.sdkd.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Utils {
	//得到当前时间
	public static String getCurrentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		String date = "2013-05-23";
//		Date date = formatter.parse("date");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		return formatter.format(curDate);
	}

	//读配置文件
	public static Properties readProperties(String filename){
		InputStream inputStream=null;
		Properties properties = null;
		try {
			inputStream = Utils.class.getClassLoader().getResourceAsStream(filename);
			properties = new Properties();
			properties.load(inputStream);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
