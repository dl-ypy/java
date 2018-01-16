package com.ypy.md;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
/**
 * date:2017��6��16��20:26:01
 * target:��ϢժҪ֮MD���ܡ�
 * @author ypy
 * conclusion��
 *     Ӧ�÷����������������ϢժҪ��
 */
public class MD {
	private static String src = "ypy security md";
	public static void main(String[] args) {
		jdkMD5();
		jdkMD2();
		bcMD4();
		bcMD5();
		ccMD5();
		ccMD2();
	}

	public static void jdkMD5() {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] md5Bytes = md.digest(src.getBytes());
			System.out.println("JDK MD5���ܣ�" + Hex.encodeHexString(md5Bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static void jdkMD2() {
		try {
			MessageDigest md = MessageDigest.getInstance("MD2");
			byte[] md2Bytes = md.digest(src.getBytes());
			System.out.println("JDK MD2���ܣ�" + Hex.encodeHexString(md2Bytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static void bcMD4() {
		Digest digest = new MD4Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] md4Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md4Bytes, 0);
		System.out.println("BC MD4���ܣ�" + Hex.encodeHexString(md4Bytes));
	}
	
	public static void bcMD5() {
		Digest digest = new MD5Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] md5Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md5Bytes, 0);
		System.out.println("BC MD5���ܣ�" + Hex.encodeHexString(md5Bytes));
	}
	
	public static void ccMD5() {
		System.out.println("CC MD5���ܣ�" + DigestUtils.md5Hex(src.getBytes()));
	}
	
	public static void ccMD2() {
		System.out.println("CC MD2���ܣ�" + DigestUtils.md2Hex(src.getBytes()));
	}
}
/*
 **************JDK1.8���н��***************
 JDK MD5���ܣ�f1d91cd3019692532febc4df91d046e5
JDK MD2���ܣ�1f677d2ff1b08336967f9d9cfdf87a1d
BC MD4���ܣ�a0702484d300bdc9b009e55f799fad78
BC MD5���ܣ�f1d91cd3019692532febc4df91d046e5
CC MD5���ܣ�f1d91cd3019692532febc4df91d046e5
CC MD2���ܣ�1f677d2ff1b08336967f9d9cfdf87a1d
 */
