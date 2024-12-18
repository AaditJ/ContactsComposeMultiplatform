package com.plcoding.contactscomposemultiplatform.contacts.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.plcoding.contactscomposemultiplatform.contacts.domain.ContactDataSource
import com.plcoding.contactscomposemultiplatform.contacts.presentation.mappers.mapToPresentation
import com.plcoding.contactscomposemultiplatform.contacts.presentation.uiModels.ContactUiModel
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ContactListViewModel(
    private val contactDataSource: ContactDataSource
) : ViewModel() {

    private val _state = MutableStateFlow(ContactListState())
    val state = combine(
        _state, contactDataSource.getContacts(), contactDataSource.getRecentContacts(20)
    ) { state, contacts, recentContacts ->
        state.copy(contacts = contacts.map {
            it.mapToPresentation()
        }, recentlyAddedContactUIModels = recentContacts.map {
            it.mapToPresentation()
        })
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), ContactListState())

    var newContact: ContactUiModel? by mutableStateOf(null)
        private set

    fun onEvent(event: ContactListEvent) {
        when (event) {
            ContactListEvent.DeleteContact -> {

                viewModelScope.launch {
                    _state.value.selectedContactUIModel?.id?.let { id ->
                        _state.update {
                            it.copy(
                                isSelectedContactSheetOpen = false
                            )
                        }
                        contactDataSource.deleteContact(id)
                        delay(300L) // To allow for animation delay, other ways of doing this as well
                        _state.update {
                            it.copy(
                                selectedContactUIModel = null
                            )
                        }
                    }
                }
            }

            ContactListEvent.DismissContact -> {
                viewModelScope.launch {
                    _state.update {
                        it.copy(
                            isSelectedContactSheetOpen = false,
                            isAddContactSheetOpen = false,
                            firstNameError = null,
                            lastNameError = null,
                            emailError = null,
                            phoneNumberError = null,
                        )
                    }
                    delay(300L)
                    newContact = null
                    _state.update{
                        it.copy(
                            selectedContactUIModel = null
                        )
                    }
                }
            }
            is ContactListEvent.EditContact -> {
                _state.update {
                    it.copy(
                        selectedContactUIModel = null,
                        isAddContactSheetOpen = true,
                        isSelectedContactSheetOpen = false,
                    )
                }
                newContact = event.contact
            }
            ContactListEvent.OnAddNewContactClick -> {
                _state.update {
                    it.copy(
                        isAddContactSheetOpen = true
                    )
                }
                newContact = ContactUiModel(
                    id = null,
                    firstName = "",
                    lastName = "",
                    email = "",
                    phoneNumber = "",
                    photoBytes = null
                )
            }
            ContactListEvent.OnAddPhotoClicked -> TODO()
            is ContactListEvent.OnEmailChanged -> TODO()
            is ContactListEvent.OnFirstNameChanged -> TODO()
            is ContactListEvent.OnLastNameChanged -> TODO()
            is ContactListEvent.OnPhoneNumberChanged -> TODO()
            is ContactListEvent.OnPhotoPicked -> TODO()
            is ContactListEvent.SelectContact -> TODO()
        }

    }

}
