package me.shkschneider.viewmodellivedatacoroutines.data

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "Notification")
data class Notification(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    var msg: String
)

@Dao
interface Notifications : BaseDao<Notification> {

    @Query("SELECT * FROM Notification")
    fun getAll(): List<Notification>

}
