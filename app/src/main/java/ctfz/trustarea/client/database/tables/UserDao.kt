package ctfz.trustarea.client.database.tables

import androidx.room.*
import ctfz.trustarea.client.database.data.UserDBEntity


@Dao
interface UserDao  {

    @Query("SELECT * FROM ${UserDBEntity.TABLE_NAME} WHERE user_name LIKE :user_name LIMIT 1")
    fun getUser(user_name: String): UserDBEntity?

    @Query("SELECT * FROM ${UserDBEntity.TABLE_NAME}")
    fun getUsers(): List<UserDBEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<UserDBEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserDBEntity)

    @Delete
    fun deleteUser(user: UserDBEntity)

}