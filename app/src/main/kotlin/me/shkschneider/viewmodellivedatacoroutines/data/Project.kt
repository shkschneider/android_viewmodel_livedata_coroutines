package me.shkschneider.viewmodellivedatacoroutines.data

import java.util.UUID

data class Project(
    val id: UUID = UUID.randomUUID(),
    val name: String
)