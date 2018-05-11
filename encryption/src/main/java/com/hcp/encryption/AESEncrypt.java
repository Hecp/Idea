package com.hcp.encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AES加密
 * Created by Administrator on 2016/5/25.
 */
public class AESEncrypt {

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param password 加密密钥
     * @return 加密后的内容
     */
    public static byte[] encrypt(String content, String password){
        try {
            KeyGenerator key = KeyGenerator.getInstance("AES");
            key.init(128, new SecureRandom(password.getBytes()));

            SecretKey secretKey = key.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");

            Cipher cipher = Cipher.getInstance("AES");  // 创建密码器
            byte[] bytes = content.getBytes("UTF-8");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);  // 初始化
            return cipher.doFinal(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content 需要解密的内容
     * @param password 解密密钥
     * @return 解密后的byte数组
     */
    public static byte[] decrypt(byte[] content, String password){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(password.getBytes()));

            SecretKey secretKey = keyGenerator.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");

            Cipher cipher = Cipher.getInstance("AES");  // 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return cipher.doFinal(content);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {

        String content = "加密测试";
        String password = "123";

        byte[] encryptResult = encrypt(content, password);
        try {
            String encryptResultStr = new String(encryptResult, "UTF-8");
            System.out.println(new String(decrypt(encryptResultStr.getBytes("UTF-8"), password)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
