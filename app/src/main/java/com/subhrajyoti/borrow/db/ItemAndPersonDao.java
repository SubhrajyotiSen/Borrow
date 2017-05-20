package com.subhrajyoti.borrow.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
@TypeConverters(DateConverter.class)
public interface ItemAndPersonDao {

    @Query("select * from ItemAndPerson")
    LiveData<List<ItemAndPerson>> getAllBorrowedItems();

    @Query("select * from ItemAndPerson where id = :id")
    ItemAndPerson getItembyId(String id);


    @Query("select * from ItemAndPerson where itemName like :itemName")
    List<ItemAndPerson> getItemsByName(String itemName);

    @Insert(onConflict = REPLACE)
    void addBorrow(ItemAndPerson itemAndPerson);


}
