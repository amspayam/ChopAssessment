package co.chope.room.entity.friend

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FriendDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllFriends(friends: List<FriendEntity>)

    @Query("SELECT * FROM friend")
    suspend fun getFriends(): List<FriendEntity>

}