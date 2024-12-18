package com.plcoding.contactscomposemultiplatform.contacts.domain

import kotlinx.coroutines.flow.Flow

interface ContactDataSource {
    fun getContacts(): Flow<List<ContactDomainModel>>
    fun getRecentContacts(amount: Int): Flow<List<ContactDomainModel>>
    suspend fun insertFunction(contact: ContactDomainModel) // As this is an action, we don't get a stream of updates hence it needs to be async
    suspend fun deleteContact(id: Long)
}