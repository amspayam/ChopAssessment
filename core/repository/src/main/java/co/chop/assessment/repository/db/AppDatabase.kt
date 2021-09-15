package co.chop.assessment.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import co.chop.assessment.room.dao.ConversationDAO
import co.chop.assessment.room.dao.FriendDAO
import co.chop.assessment.room.entity.conversation.ConversationEntity
import co.chop.assessment.room.entity.conversation.ConversationTypeConverter
import co.chop.assessment.room.entity.friend.FriendEntity

@Database(entities = [FriendEntity::class, ConversationEntity::class], version = 1)
@TypeConverters(ConversationTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun conversationDao(): ConversationDAO

    abstract fun friendDao(): FriendDAO

}