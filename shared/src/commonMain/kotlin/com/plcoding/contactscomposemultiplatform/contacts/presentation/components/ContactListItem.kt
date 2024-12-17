package com.plcoding.contactscomposemultiplatform.contacts.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.contactscomposemultiplatform.contacts.presentation.uiModels.ContactUiModel

@Composable
fun ContactListItem(
    contact: ContactUiModel,
    modiifer: Modifier = Modifier,
) {
    Row(
        modifier = modiifer, verticalAlignment = Alignment.CenterVertically
    ) {
        ContactPhoto(
            contact = contact, modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(16.dp))
        Text(
            "${contact.firstName} ${contact.lastName}", modifier = Modifier.weight(1f)
        )
    }

}