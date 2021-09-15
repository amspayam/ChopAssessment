package co.chope.room.entity.conversation

import androidx.room.TypeConverter

class ConversationTypeConverter {

    @TypeConverter
    fun fromConversationType(conversationTypeEnum: ConversationTypeEnum): String {
        return conversationTypeEnum.name
    }

    @TypeConverter
    fun toConversationType(conversationTypeEnum: String): ConversationTypeEnum {
        return ConversationTypeEnum.valueOf(conversationTypeEnum)
    }

}