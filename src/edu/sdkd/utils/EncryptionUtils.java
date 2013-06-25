package edu.sdkd.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class EncryptionUtils {
	public static String md5(String message) {
		try {
			MessageDigest mdDigest = MessageDigest.getInstance("md5");
			byte[] md5 = mdDigest.digest(message.getBytes());

			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
