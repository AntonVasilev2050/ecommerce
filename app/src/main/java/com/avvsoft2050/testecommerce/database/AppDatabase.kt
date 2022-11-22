package com.avvsoft2050.testecommerce.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.avvsoft2050.testecommerce.entity.*

@Database(
    entities = [HomeStore::class, BestSeller::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration().build()
                db = instance
                return instance
            }
        }
    }

    abstract fun homeStoreDao(): HomeStoreDao
    abstract fun bestSellerDao(): BestSellerDao
//    abstract fun orderDao(): OrderDao
//    abstract fun productDetailsDao(): ProductDetailsDao
}