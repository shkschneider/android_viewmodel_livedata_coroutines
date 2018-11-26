package me.shkschneider.viewmodellivedatacoroutines.data

import java.util.UUID

data class Notification(
    val id: UUID = UUID.randomUUID(),
    val msg: String
)