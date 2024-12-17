package com.plcoding.contactscomposemultiplatform.contacts.domain

data class ContactDomainModel(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val photoBytes: ByteArray?
)
