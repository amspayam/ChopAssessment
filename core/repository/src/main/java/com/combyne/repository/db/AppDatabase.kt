package com.combyne.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import co.chope.room.dao.ConversationDAO
import co.chope.room.entity.conversation.ConversationEntity
import co.chope.room.entity.conversation.ConversationTypeConverter
import co.chope.room.entity.friend.FriendDAO
import co.chope.room.entity.friend.FriendEntity

@Database(entities = [FriendEntity::class, ConversationEntity::class], version = 1)
@TypeConverters(ConversationTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun conversationDao(): ConversationDAO

    abstract fun friendDao(): FriendDAO

}