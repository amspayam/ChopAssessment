package co.chope.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.chope.room.entity.conversation.ConversationEntity

@Dao
interface ConversationDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConversations(conversation: List<ConversationEntity>)

    @Query("SELECT * FROM conversations WHERE userId =:idUser")
    suspend fun getAll(idUser: Int): List<ConversationEntity>

}