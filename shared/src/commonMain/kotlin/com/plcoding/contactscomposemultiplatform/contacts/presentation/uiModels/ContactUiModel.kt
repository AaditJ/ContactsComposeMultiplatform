package com.plcoding.contactscomposemultiplatform.contacts.presentation.uiModels

data class ContactUiModel(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val photoBytes: ByteArray?
)
