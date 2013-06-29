package edu.sdkd.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import edu.sdkd.bean.CardInfoBean;
import edu.sdkd.domain.Card;

public class Utils {
	// 得到当前时间
	public static String getCurrentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// String date = "2013-05-23";
		// Date date = formatter.parse("date");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		return formatter.format(curDate);
	}

	// 读配置文件
	public static Properties readProperties(String filename) {
		InputStream inputStream = null;
		Properties properties = null;
		try {
			inputStream = Utils.class.getClassLoader().getResourceAsStream(filename);
			properties = new Properties();
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	// JSON转成字符串
	public static String JSON2Str(Map<String, Map<Card, CardInfoBean>> jsonMap) {
		StringBuilder jsonString = new StringBuilder();
		jsonString.append('[');
		for (Map.Entry<String, Map<Card, CardInfoBean>> mapEntry : jsonMap.entrySet()) {
			jsonString.append('{').append('"').append("key").append('"').append(" : ").append('"').append(mapEntry.getKey())
					.append('"').append(',').append('"').append("values").append('"').append(" : ").append('[');
			for (Entry<Card, CardInfoBean> entry : mapEntry.getValue().entrySet()) {
				jsonString.append('{').append('"').append("key").append('"').append(':').append('"').append(
						entry.getValue().getFN()).append('"').append(',').append('"').append("id").append('"').append(" : ")
						.append('"').append(entry.getKey().getId()).append('"').append('}').append(',');
			}
			jsonString.append(']').append('}').append(',');
		}
		jsonString.append(']');
		return jsonString.toString();
	}
}
