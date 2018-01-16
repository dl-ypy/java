/**
 * date:2017��6��12��16:11:18
 * target:Base64�����ּ��ܽ��ܷ�ʽ��
 * @author ypy
 * conclusion��
 *     ��ΪBase64�ļ����㷨���ǹ����ģ�����һ�㲻�á�
 *     Ӧ�ó�����e-mail����Կ��֤���ļ���
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
		System.out.println("jdk���ܣ�" + new String(encodeBytes));
		
		byte[] decodeBytes = java.util.Base64.getDecoder().decode(encodeBytes);
		System.out.println("jdk���ܣ�" + new String(decodeBytes));
	}

	public static void commonsCodesBase64() {
		byte[] encodeBytes = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
		System.out.println("commonsCodec���ܣ�" + new String(encodeBytes));
		
		byte[] decodeBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encodeBytes);
		System.out.println("commonsCodec���ܣ�" + new String(decodeBytes));
	}
	
	public static void bouncyCastleBase64() {
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println("bouncyCastle���ܣ�" + new String(encodeBytes));
		
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println("bouncyCastle���ܣ�" + new String(decodeBytes));
	}
}
/*
 ***************1.8JDK***************
jdk���ܣ�eXB5IHNlY3VyaXR5IGJhc2U2NA==
jdk���ܣ�ypy security base64
commonsCodec���ܣ�eXB5IHNlY3VyaXR5IGJhc2U2NA==
commonsCodec���ܣ�ypy security base64
bouncyCastle���ܣ�eXB5IHNlY3VyaXR5IGJhc2U2NA==
bouncyCastle���ܣ�ypy security base64
*/