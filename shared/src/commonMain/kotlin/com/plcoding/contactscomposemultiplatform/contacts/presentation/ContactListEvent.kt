package com.plcoding.contactscomposemultiplatform.contacts.presentation

import com.plcoding.contactscomposemultiplatform.contacts.presentation.uiModels.ContactUiModel

sealed interface ContactListEvent {
    object OnAddNewContactClick : ContactListEvent
    object DismissContact : ContactListEvent
    data class OnFirstNameChanged(val value: String) : ContactListEvent
    data class OnLastNameChanged(val value: String) : ContactListEvent
    data class OnEmailChanged(val value: String) : ContactListEvent
    data class OnPhoneNumberChanged(val value: String) : ContactListEvent
    data class OnPhotoPicked(val bytes: ByteArray) : ContactListEvent
    object OnAddPhotoClicked: ContactListEvent
    data class SelectContact(val contact: ContactUiModel): ContactListEvent
    data class EditContact(val contact: ContactUiModel): ContactListEvent
    object DeleteContact: ContactListEvent
}