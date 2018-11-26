package me.shkschneider.viewmodellivedatacoroutines.data

import java.util.UUID

data class User(
    val id: UUID = UUID.randomUUID(),
    val login: String
)