package com.example.encryptionfunctionalities

import android.util.Base64
import android.util.Log
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

class EncryptionManager() {

    private val secretKey = "00112233445566778899AABBCCDDEEFF"

    fun encrypt(plainText: String): String {
        try {
            val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
            cipher.init(Cipher.ENCRYPT_MODE, generateSecretKey())
            val encryptedBytes = cipher.doFinal(plainText.toByteArray())
            val encryptedText = Base64.encodeToString(encryptedBytes, Base64.DEFAULT)
            Log.d("EncryptionManager", "Encrypt Result: $encryptedText")
            return encryptedText
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }

    fun decrypt(encryptedText: String): String {
        try {
            val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
            cipher.init(Cipher.DECRYPT_MODE, generateSecretKey())
            val encryptedBytes = Base64.decode(encryptedText, Base64.DEFAULT)
            val decryptedBytes = cipher.doFinal(encryptedBytes)
            val decryptedText = String(decryptedBytes)
            Log.d("EncryptionManager", "Decrypt Result: $decryptedText")
            return decryptedText
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }

    private fun generateSecretKey(): SecretKey {
        return SecretKeySpec(secretKey.toByteArray(), "AES")
    }
}