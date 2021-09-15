package co.chop.assessment.repository.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import co.chop.assessment.base.extension.GsonUtils.toListByGson
import co.chop.assessment.repository.R
import co.chop.assessment.room.dao.FriendDAO
import co.chop.assessment.room.entity.friend.FriendEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DatabaseBuilder {

    class DatabaseCallbackImpl(
        private val context: Context
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                CoroutineScope(Dispatchers.Main).launch {
                    val friendDao = database.friendDao()
                    prePopulateDatabase(friendDao)
                }
            }
        }

        private suspend fun prePopulateDatabase(friendDao: FriendDAO) {
            val jsonString = context.resources.openRawResource(R.raw.friends).bufferedReader().use {
                it.readText()
            }
            val list: List<FriendEntity> = jsonString.toListByGson()
            friendDao.insertAllFriends(list)
        }
    }

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getInstance(
            context: Context
        ): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = buildRoomDB(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildRoomDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "chop-data-base"
            )
                .fallbackToDestructiveMigration()
                .addCallback(DatabaseCallbackImpl(context.applicationContext))
                .build()

    }

}