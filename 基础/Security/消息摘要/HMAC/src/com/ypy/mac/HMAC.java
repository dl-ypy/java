package com.ypy.mac;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
/**
 * date:2017年6月18日09:41:54
 * target:消息摘要之Hmac加密。
 * @author ypy
 */
public class HMAC {
	private static String src = "ypy security mac";
	public static void main(String[] args) {
		jdkHmacMD2();
		bcHmacMD5();
	}

	public static void jdkHmacMD2() {
		try {
			KeyGenerator keyenerator = KeyGenerator.getInstance("HmacMD5");
			SecretKey secretKey = keyenerator.generateKey();//产生密钥
			//byte[] key = secretKey.getEncoded();//可自己获得密钥
			byte[] key = null;
			try {
				//也可以使用自定义的加密
				key = Hex.decodeHex(new char[]{'a','a','a','a','a','a','a','a'});
			} catch (DecoderException e) {
				e.printStackTrace();
			}
			
			SecretKey restoreSecretKey = new SecretKeySpec(key, "HmacMD5");//还原密钥
			Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
			mac.init(restoreSecretKey);
			byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());//执行摘要
			System.out.println("jdk hmacMD5加密：" + Hex.encodeHexString(hmacMD5Bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
	}
	
	public static void bcHmacMD5() {
		HMac hmac = new HMac(new MD5Digest());
		hmac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaa")));
		hmac.update(src.getBytes(), 0, src.getBytes().length);
		
		byte[] hmacMD5Bytes = new byte[hmac.getMacSize()];//执行摘要
		hmac.doFinal(hmacMD5Bytes, 0);
		
		System.out.println("bc hmacMD5加密：" + Hex.encodeHexString(hmacMD5Bytes));
	}
}
/*
 **************JDK1.8运行结果***************
jdk hmacMD5加密：5bb486c15d40598e4e00511d9bf4f666
bc hmacMD5加密：5bb486c15d40598e4e00511d9bf4f666
 */