package com.yang.springbootyangclub.libs.encrypts;

import com.yang.springbootyangclub.libs.exceptions.YoungException;

/**
 * package name : com.yang.springbootyangclub.libs.encrypt
 * Date : 2023-08-15
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */
public class EncryptUtil {

    /**
     * 암호화
     *  - Cipher Algorithm : AES
     *
     * @param key
     * @param iv
     * @param value 암호화할 데이터
     */
    public static String encrypt(String key, String iv, String value) {
        String result = null;
        try {
            GeneralEncrypter generalEncrypter = new GeneralEncrypter(CipherAlgorithm.AES, key, iv);
            result = generalEncrypter.encrypt( value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    /**
     * 복호화
     *  - Cipher Algorithm : AES
     *
     * @param key
     * @param iv
     * @param value 복호화할 암호 데이터
     */
    public static String decrypt(String key, String iv, String value) {
        String result = null;
        try {
            GeneralEncrypter generalEncrypter = new GeneralEncrypter(CipherAlgorithm.AES, key, iv);
            result = generalEncrypter.decrypt( value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    /**
     * 암호화
     *  - Cipher Algorithm : AES
     *
     * @param value 암호화할 데이터
     */
    public static String encrypt(String value) {
        String result = null;
        try {
            GeneralEncrypter generalEncrypter = new GeneralEncrypter(CipherAlgorithm.AES);
            result = generalEncrypter.encrypt( value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    /**
     * 복호화
     *  - Cipher Algorithm : AES
     *
     * @param value 복호화할 암호 데이터
     */
    public static String decrypt(String value) {
        String result = null;
        try {
            GeneralEncrypter generalEncrypter = new GeneralEncrypter(CipherAlgorithm.AES);
            result = generalEncrypter.decrypt( value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    /**
     * 암호화
     *  - Cipher Algorithm : SHA512
     *
     * @param value  암호화할 데이터
     */
    public static String encryptSHA512(String value) {
        try {
            GeneralEncrypter encrypter = new GeneralEncrypter();
            return encrypter.encryptSHA512(value);
        } catch (YoungException e) {
            throw new RuntimeException(e);
        }
    }

}
