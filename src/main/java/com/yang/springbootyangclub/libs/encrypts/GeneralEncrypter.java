package com.yang.springbootyangclub.libs.encrypts;

import com.yang.springbootyangclub.libs.exceptions.YoungException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

/**
 * StringEncrypter
 *
 * @author JO Hyeong-ryeol
 */
public class GeneralEncrypter {
	private Cipher rijndael;
	private SecretKeySpec key;
	private IvParameterSpec initalVector;

	private final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
	private String strKey = "ENCRYPT_KEY";
	private String strInitialVector = "ENCRYPT_IV";

	private CipherAlgorithm cipherAlgorithm = CipherAlgorithm.AES;

	/**
	 * Creates a StringEncrypter instance. 기본키와 벡터 사용
	 *
	 * @throws Exception
	 */
	public GeneralEncrypter() throws YoungException{
		initialize();
	}

	public GeneralEncrypter(CipherAlgorithm ALGORITHM) throws YoungException{
		cipherAlgorithm = ALGORITHM;
		initialize();
	}

	/**
	 * Creates a StringEncrypter instance.
	 *
	 * @param key           A key string which is converted into UTF-8 and hashed by MD5. Null or an empty string is not allowed.
	 * @param initialVector An initial vector string which is converted into UTF-8 and hashed by MD5. Null or an empty string is not allowed.
	 * @throws Exception
	 */
	public GeneralEncrypter(CipherAlgorithm ALGORITHM, String key, String initialVector) throws YoungException {
		this.strKey = key;
		this.strInitialVector = initialVector;
		cipherAlgorithm = ALGORITHM;
		initialize();
	}

	private void initialize() throws YoungException{
		try {
			// Create a AES algorithm.
			this.rijndael = Cipher.getInstance(TRANSFORMATION);
			// Initialize an encryption key and an initial vector.
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			this.key = new SecretKeySpec(md5.digest(strKey.getBytes("UTF8")), cipherAlgorithm.name());
			this.initalVector = new IvParameterSpec(md5.digest(strInitialVector.getBytes("UTF8")));
		} catch (Exception e) {
			throw new YoungException(e);
		}
	}

	/**
	 * Encrypts a string.
	 *
	 * @param value A string to encrypt. It is converted into UTF-8 before being encrypted. Null is regarded as an empty string.
	 * @return An encrypted string.
	 * @throws Exception
	 */
	public String encrypt(String value) throws YoungException {
		if (value == null) {
			value = "";
		}

		try {
			// Initialize the cryptography algorithm.
			this.rijndael.init(Cipher.ENCRYPT_MODE, this.key, this.initalVector);

			// Get a UTF-8 byte array from a unicode string.
			byte[] utf8Value = value.getBytes("UTF8");

			// Encrypt the UTF-8 byte array.
			byte[] encryptedValue = this.rijndael.doFinal(utf8Value);

			// Return a base64 encoded string of the encrypted byte array.
			return Base64Encoder.encode(encryptedValue);
		} catch (Exception e) {
			throw new YoungException(e);
		}
	}

	/**
	 * Decrypts a string which is encrypted with the same key and initial vector.
	 *
	 * @param value A string to decrypt. It must be a string encrypted with the same key and initial vector. Null or an empty string is not allowed.
	 * @return A decrypted string
	 * @throws Exception
	 */
	public String decrypt(String value) throws YoungException {
		if (value == null || value.equals("")) {
			return null;
		}

		try {
			// Initialize the cryptography algorithm.
			this.rijndael.init(Cipher.DECRYPT_MODE, this.key, this.initalVector);

			// Get an encrypted byte array from a base64 encoded string.
			byte[] encryptedValue = Base64Encoder.decode(value);

			// Decrypt the byte array.
			byte[] decryptedValue = this.rijndael.doFinal(encryptedValue);

			// Return a string converted from the UTF-8 byte array.
			return new String(decryptedValue, "UTF8");
		} catch (Exception e) {
			throw new YoungException(e);
		}
	}



	/**
	 * SHA 512 encrypt
	 *
	 * @param value
	 * @return
	 */
	public String encryptSHA512(String value) throws YoungException{
		try {
			String generatedPassword = null;
			MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
			byte[] bytes = sha512.digest(value.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
			return generatedPassword;
		} catch (Exception e) {
			throw new YoungException(e);
		}
	}

}
