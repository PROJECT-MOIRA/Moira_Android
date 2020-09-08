package com.dgsw.hackathon.moira.util

import java.security.MessageDigest

object Utils {

    fun encryptSHA512(target: String): String {

        val encryptedPassword = StringBuilder()
        val messageDigest = MessageDigest.getInstance("SHA-512")
        messageDigest.update(target.toByteArray())

        messageDigest.digest().forEach {
            var sb = StringBuilder(Integer.toHexString(it.toInt()))
            while (sb.length < 2) { sb.insert(0, "0") }
            sb = StringBuilder(sb.substring(sb.length - 2))
            encryptedPassword.append(sb)
        }
        return encryptedPassword.toString()
    }
}