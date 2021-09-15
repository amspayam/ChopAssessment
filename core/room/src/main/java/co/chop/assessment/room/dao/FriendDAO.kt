package co.chop.assessment.room.dao

import androidx.room.*
import co.chop.assessment.room.entity.friend.FriendEntity
import co.chop.assessment.room.entity.friend.FriendUpdate

@Dao
interface FriendDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllFriends(friends: List<FriendEntity>)

    @Query("SELECT * FROM friend")
    suspend fun getFriends(): List<FriendEntity>

    @Update(entity = FriendEntity::class)
    suspend fun updateFriend(friend: FriendUpdate)

}