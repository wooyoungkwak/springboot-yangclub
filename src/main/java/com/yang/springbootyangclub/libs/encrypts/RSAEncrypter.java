package com.yang.springbootyangclub.libs.encrypts;

import com.yang.springbootyangclub.libs.exceptions.YoungException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPublicKeySpec;

/**
 * RSA 암호화 with Base64
 *
 * @author 한승룡
 * @since 2017-03-07
 */
public class RSAEncrypter {

	private PublicKey publicKey = null;
	private PrivateKey privateKey = null;

	private String publicKeyModulus = null;
	private String publicKeyExponent = null;

	/**
	 * RSA 키쌍 생성
	 *
	 * @param nbit
	 */
	public RSAEncrypter(int nbit) {
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(nbit);

			KeyPair keyPair = keyPairGenerator.generateKeyPair();

			this.publicKey = keyPair.getPublic();
			this.privateKey = keyPair.getPrivate();

			RSAPublicKeySpec rsaPublicKeySpec = KeyFactory.getInstance("RSA").getKeySpec(publicKey, RSAPublicKeySpec.class);

			this.publicKeyModulus = rsaPublicKeySpec.getModulus().toString(16);
			this.publicKeyExponent = rsaPublicKeySpec.getPublicExponent().toString(16);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * RSA 키쌍 생성
	 */
	public RSAEncrypter() {
		this(1024);
	}

	/**
	 * RSA Encrypt
	 *
	 * @param publicKey
	 * @param value
	 * @return
	 */
	public static String encrypt(PublicKey publicKey, String value) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
//		Cipher cipher = Cipher.getInstance("RSA");
//		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//
//		byte[] encryptedBytes = cipher.doFinal(value.getBytes("UTF-8"));
//
//		return Base64Encoder.encode(encryptedBytes);

		// 간헐적으로 오류가 발생하여 BigInteger 가 아닌 Base64 로 인코딩하는 것으로 변경
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		byte[] encryptedBytes = cipher.doFinal(value.getBytes("UTF-8"));

		return (new BigInteger(encryptedBytes)).toString(16);
	}

	/**
	 * RSA Decrypt
	 *
	 * @param privateKey
	 * @param value
	 * @return
	 */
	public static String decrypt(PrivateKey privateKey, String value) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, YoungException {
//		Cipher cipher = Cipher.getInstance("RSA");
//		cipher.init(Cipher.DECRYPT_MODE, privateKey);
//
//		byte[] encryptedBytes = Base64Encoder.decode(value);
//
//		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
//
//		return new String(decryptedBytes, "UTF-8");

		// 간헐적으로 오류가 발생하여 BigInteger 가 아닌 Base64 로 인코딩하는 것으로 변경
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		byte[] encryptedBytes;
		if (value == null || value.length() % 2 != 0) {
			encryptedBytes = new byte[]{};
		} else {
			encryptedBytes = new byte[value.length() / 2];
			for (int i = 0; i < value.length(); i += 2) {
				byte byteValue = (byte) Integer.parseInt(value.substring(i, i + 2), 16);
				encryptedBytes[(int) Math.floor(i / (double) 2)] = byteValue;
			}
		}

		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

		return new String(decryptedBytes, "UTF-8");
	}

	/**
	 * 공개키 반환
	 *
	 * @return
	 */
	public PublicKey getPublicKey() {
		return publicKey;
	}

	/**
	 * 개인키 반환
	 *
	 * @return
	 */
	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	/**
	 * 공개키 Modulus 반환
	 *
	 * @return
	 */
	public String getPublicKeyModulus() {
		return publicKeyModulus;
	}

	/**
	 * 공개키 Exponent 반환
	 *
	 * @return
	 */
	public String getPublicKeyExponent() {
		return publicKeyExponent;
	}

}
