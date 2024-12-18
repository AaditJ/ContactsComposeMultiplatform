package com.plcoding.contactscomposemultiplatform.contacts.data

import com.plcoding.contactscomposemultiplatform.contacts.domain.ContactDataSource
import com.plcoding.contactscomposemultiplatform.contacts.domain.ContactDomainModel
import com.plcoding.contactscomposemultiplatform.database.ContactDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightContactDataSource(
    db: ContactDatabase
): ContactDataSource {

    private val queries = db.contactQueries

    override fun getContacts(): Flow<List<ContactDomainModel>> {
        return queries
            .getContacts()
            .asFlow()
            .mapToList()
            .map { contactEntities ->
                contactEntities.map{ contactEntity ->
                    contactEntity.toContact()
                }
            }
    }

    override fun getRecentContacts(amount: Int): Flow<List<ContactDomainModel>> {
        return queries
            .getRecentContacts(amount.toLong())
            .asFlow()
            .mapToList()
            .map { contactEntities ->
                contactEntities.map{ contactEntity ->
                    contactEntity.toContact()
                }
            }
    }

    override suspend fun insertFunction(contact: ContactDomainModel) {
        queries
            .insertContactEntity(
                id = contact.id,
                firstName = contact.firstName,
                lastName = contact.lastName,
                email = contact.email,
                phoneNumber = contact.phoneNumber,
                createdAt = Clock.System.now().toEpochMilliseconds(),
                imagePath = null
            )
    }

    override suspend fun deleteContact(id: Long) {
        queries.deleteContact(id)
    }
}