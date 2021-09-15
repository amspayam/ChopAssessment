package co.chop.assessment.room.entity.conversation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "conversations"
)
data class ConversationEntity(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "userId") var userId: Int,
    @ColumnInfo(name = "message") var message: String,
    @ColumnInfo(name = "type") var type: ConversationTypeEnum
)