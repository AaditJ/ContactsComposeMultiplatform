package com.plcoding.contactscomposemultiplatform.contacts.data

import com.plcoding.contactscomposemultiplatform.contacts.domain.ContactDomainModel
import database.ContactEntity

fun ContactEntity.toContact(): ContactDomainModel {
    return ContactDomainModel(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phoneNumber = phoneNumber,
        photoBytes = null
    )
}