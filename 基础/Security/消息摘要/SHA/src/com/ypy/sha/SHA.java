package com.ypy.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
/**
 * date:2017年6月18日09:09:28
 * target:消息摘要之SHA加密。
 * @author ypy
 * conclusion：
 *     发送方与接收方的消息摘要。
 */
public class SHA {
	private static String src = "ypy security sha";
	public static void main(String[] args) {
		jdkSHA1();
		bcSHA1();
		bcSHA224();
		ccSHA1();
	}
	
	public static void jdkSHA1() {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(src.getBytes());
			System.out.println("jdk sha-1加密:" + Hex.encodeHexString(md.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static void bcSHA1() {
		Digest digest = new SHA1Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] sha1Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha1Bytes, 0);
		System.out.println("bc sha-1加密：" + Hex.encodeHexString(sha1Bytes));
	}
	
	public static void bcSHA224() {
		Digest digest = new SHA224Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] sha224Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha224Bytes, 0);
		System.out.println("bc sha-224加密：" + Hex.encodeHexString(sha224Bytes));
	}
	
	public static void ccSHA1() {
		System.out.println("cc sha1-1加密：" + DigestUtils.sha1Hex(src.getBytes()));
		System.out.println("cc sha1-2加密：" + DigestUtils.sha1Hex(src));
	}
}
/*
 **************JDK1.8运行结果***************
jdk sha-1加密:fa41ed43743f5494355a92d2b383e439028b3065
bc sha-1加密：fa41ed43743f5494355a92d2b383e439028b3065
bc sha-224加密：32890d0fcb14557cc87ddb872f40344bf73f507e0933e88e839001a0
cc sha1-1加密：fa41ed43743f5494355a92d2b383e439028b3065
cc sha1-2加密：fa41ed43743f5494355a92d2b383e439028b3065
 */