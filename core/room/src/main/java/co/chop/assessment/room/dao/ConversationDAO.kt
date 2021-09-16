package co.chop.assessment.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.chop.assessment.room.entity.conversation.ConversationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConversationDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConversations(conversation: List<ConversationEntity>)

    @Query("SELECT * FROM conversations WHERE userId =:idUser")
    fun getAll(idUser: Int): Flow<List<ConversationEntity>>

}