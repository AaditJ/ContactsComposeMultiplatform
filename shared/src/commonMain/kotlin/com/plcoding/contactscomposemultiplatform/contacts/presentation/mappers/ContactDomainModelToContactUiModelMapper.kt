package com.plcoding.contactscomposemultiplatform.contacts.presentation.mappers

import com.plcoding.contactscomposemultiplatform.contacts.domain.ContactDomainModel
import com.plcoding.contactscomposemultiplatform.contacts.presentation.uiModels.ContactUiModel

class ContactDomainModelToContactUiModelMapper {
    fun mapToPresentation(domainModel: ContactDomainModel): ContactUiModel {
        return ContactUiModel(
            id = domainModel.id,
            firstName = domainModel.firstName,
            lastName = domainModel.lastName,
            email = domainModel.email,
            phoneNumber = domainModel.phoneNumber,
            photoBytes = domainModel.photoBytes
        )
    }
}