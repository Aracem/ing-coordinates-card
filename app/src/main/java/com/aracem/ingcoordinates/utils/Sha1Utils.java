
package com.aracem.ingcoordinates.utils;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * @author Marcos Trujillo
 */
public class Sha1Utils {

    final static String TAG = "SHA1Utils";

    /**
     * @return SHA-1 of a char[]
     */
    public static byte[] generateSHA1(char chars[]) {
        return generateSHA1(new String(chars));
    }

    /**
     * @return SHA-1 of a String
     */
    public static byte[] generateSHA1(String str) {
        return generateSHA1(str.getBytes());
    }

    /**
     * Encodes a Strings into a SHA1
     * 
     * @param str
     * @return String SH1 of the str or empty string
     */
    public static String generateSHA1toString(String str) {
        try {
            byte[] datos = generateSHA1(str.getBytes());
            return byteArrayToHexString(datos);
        } catch (Exception e) {
            Logger.e("Error generating SHA1. " + e.getMessage());
            return "";
        }
    }

    /**
     * This function generates a SHA1 byte[] from another byte[].
     * 
     * @param bytes
     * @return
     */
    public static byte[] generateSHA1(byte[] bytes) {
        byte[] encryted = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(bytes);
            encryted = digest.digest();

        } catch (Exception e) {
            Logger.e("Error generating SHA1. " + e.getMessage());
        }
        return encryted;
    }

    /**
     * This function encodes byte[] into a hex
     * 
     * @param b
     * @return
     */
    public static String byteArrayToHexString(byte[] b) {
        if (b == null)
            return null;

        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * Encodes a Hex String into a byte[]
     * 
     * @param s
     * @return
     */
    public static byte[] hexStringToByteArray(String s) {
        if (s == null)
            return null;

        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(s.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
    }

    /**
     * Compares two bytes[]
     * 
     * @param b1
     * @param b2
     * @return
     */
    public static boolean compareByteArrays(byte[] b1, byte[] b2) {
        return b1 != null && b2 != null && Arrays.equals(b1, b2);
    }

    /**
     * Compares two Strings.
     * 
     * @param s1
     * @param s2
     * @return
     */
    public static boolean compareHexString(String s1, String s2) {
        return s1 != null && s2 != null && s1.equalsIgnoreCase(s2);
    }

}
