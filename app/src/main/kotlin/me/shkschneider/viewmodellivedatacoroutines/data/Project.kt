package me.shkschneider.viewmodellivedatacoroutines.data

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "Project")
data class Project(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    var name: String
)

@Dao
interface Projects : BaseDao<Project> {

    @Query("SELECT * FROM Project")
    fun getAll(): List<Project>

}
