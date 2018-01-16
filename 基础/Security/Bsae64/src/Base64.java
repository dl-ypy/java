/**
 * date:2017年6月12日16:11:18
 * target:Base64的三种加密解密方式。
 * @author ypy
 * conclusion：
 *     因为Base64的加密算法都是公开的，所以一般不用。
 *     应用场景：e-mail、密钥、证书文件。
 */
public class Base64 {
	public static String src = "ypy security base64";
	public static void main(String[] args) {
		jdkBase64();
		commonsCodesBase64();
		bouncyCastleBase64();
	}
	
	public static void jdkBase64() {
		byte[] encodeBytes = java.util.Base64.getEncoder().encode(src.getBytes());
		System.out.println("jdk加密：" + new String(encodeBytes));
		
		byte[] decodeBytes = java.util.Base64.getDecoder().decode(encodeBytes);
		System.out.println("jdk解密：" + new String(decodeBytes));
	}

	public static void commonsCodesBase64() {
		byte[] encodeBytes = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
		System.out.println("commonsCodec加密：" + new String(encodeBytes));
		
		byte[] decodeBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encodeBytes);
		System.out.println("commonsCodec解密：" + new String(decodeBytes));
	}
	
	public static void bouncyCastleBase64() {
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println("bouncyCastle加密：" + new String(encodeBytes));
		
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println("bouncyCastle解密：" + new String(decodeBytes));
	}
}
/*
 ***************1.8JDK***************
jdk加密：eXB5IHNlY3VyaXR5IGJhc2U2NA==
jdk解密：ypy security base64
commonsCodec加密：eXB5IHNlY3VyaXR5IGJhc2U2NA==
commonsCodec解密：ypy security base64
bouncyCastle加密：eXB5IHNlY3VyaXR5IGJhc2U2NA==
bouncyCastle解密：ypy security base64
*/