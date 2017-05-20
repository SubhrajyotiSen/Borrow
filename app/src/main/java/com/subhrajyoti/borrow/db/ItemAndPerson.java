package com.subhrajyoti.borrow.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

@Entity
public class ItemAndPerson {

    @PrimaryKey(autoGenerate = true)
    public int id;

    private String itemName;
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;
    @TypeConverters(DateConverter.class)
    private Date borrowDate;

    public ItemAndPerson(int id, String itemName, String firstName, String lastName, Date borrowDate) {
        this.id = id;
        this.itemName = itemName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowDate = borrowDate;
    }

    public String getItemName() {
        return itemName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }
}
