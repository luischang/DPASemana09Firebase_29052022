package dev.lchang.dpasemana09firebase.ui.fragments.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="customer")
data class CustomerEntity(
 @ColumnInfo(name="first_name") val firstName: String?,
 @ColumnInfo(name="last_name") val lastName: String?,
 @ColumnInfo(name="phone") val phone: String?
 ){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") var customerId: Int = 0

}