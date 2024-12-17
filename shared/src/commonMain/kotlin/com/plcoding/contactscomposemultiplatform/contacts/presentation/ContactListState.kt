package com.plcoding.contactscomposemultiplatform.contacts.presentation

import com.plcoding.contactscomposemultiplatform.contacts.presentation.uiModels.ContactUiModel


data class ContactListState(
    val contacts: List<ContactUiModel> = emptyList(),
    val recentlyAddedContactDomainModels: List<ContactUiModel> = emptyList(),
    val selectedContactDomainModel: ContactUiModel? = null,
    val isAddContactSheetOpen: Boolean = false,
    val isSelectedContactSheetOpen: Boolean = false,
    val firstNameError: String? = null,
    val lastNameError: String? = null,
    val emailError: String? = null,
    val phoneNumberError: String? = null,

    )
