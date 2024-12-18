package com.plcoding.contactscomposemultiplatform.contacts.presentation.mappers

import com.plcoding.contactscomposemultiplatform.contacts.domain.ContactDomainModel
import com.plcoding.contactscomposemultiplatform.contacts.presentation.uiModels.ContactUiModel

fun ContactDomainModel.mapToPresentation(): ContactUiModel {
    return ContactUiModel(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phoneNumber = phoneNumber,
        photoBytes = photoBytes
    )
}