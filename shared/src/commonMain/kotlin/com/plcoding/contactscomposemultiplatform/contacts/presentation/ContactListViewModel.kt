package com.plcoding.contactscomposemultiplatform.contacts.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.plcoding.contactscomposemultiplatform.contacts.presentation.uiModels.ContactUiModel
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContactListViewModel: ViewModel() {

    private val _state = MutableStateFlow(ContactListState(
        contacts = contacts
    ))
    val state = _state.asStateFlow()

    var newContact: ContactUiModel? by mutableStateOf(null)
        private set

    fun onEvent(event: ContactListEvent){
//        when(event){
//            is ContactListEvent.AddNewContact -> {
//                newContact = event.contact
//            }
//            is ContactListEvent.ContactAdded -> {
//                newContact = null
//                _state.value = _state.value.copy(
//                    contacts = _state.value.contacts + event.contact
//                )
//            }
        }

}

private val contacts = (1..50).map{
    ContactUiModel(
        id = it.toLong(),
        firstName = "First Name $it",
        lastName = "Last Name $it",
        email = "test@test$it.com",
        phoneNumber = "1234567890",
        photoBytes = null
    )
}