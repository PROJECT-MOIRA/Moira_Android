package com.dgsw.hackathon.moira.request

import com.dgsw.hackathon.moira.util.Utils
import java.security.NoSuchAlgorithmException

class RegisterRequest(id : String, pw: String, name: String, grade: String, contact: String, email: String) {
    lateinit var id: String
    lateinit var pw: String
    lateinit var name: String
    lateinit var grade: String
    lateinit var contact: String
    lateinit var email: String

    init {
        try {
            this.id = id
            this.pw = Utils.encryptSHA512(pw)
            this.name = name
            this.grade = grade
            this.contact = contact
            this.email = email
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
    }
}