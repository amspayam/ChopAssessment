package co.chop.assessment.room.entity.friend

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "friend"
)
data class FriendEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,
    @ColumnInfo(name = "username")
    var username: String,
    @ColumnInfo(name = "lastMessage")
    var lastMessage: String?
)
