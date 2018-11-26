package me.shkschneider.viewmodellivedatacoroutines.data

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    var login: String
)

@Dao
interface Users : BaseDao<User> {

    @Query("SELECT * FROM User")
    fun getAll(): List<User>

}
