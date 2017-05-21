package com.subhrajyoti.borrow.listItems;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.subhrajyoti.borrow.db.AppDatabase;
import com.subhrajyoti.borrow.db.BorrowModel;

import java.util.List;


public class BorrowedListViewModel extends AndroidViewModel {

    private final LiveData<List<BorrowModel>> itemAndPersonList;

    private AppDatabase appDatabase;

    public BorrowedListViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

        itemAndPersonList = appDatabase.itemAndPersonModel().getAllBorrowedItems();
    }


    public LiveData<List<BorrowModel>> getItemAndPersonList() {
        return itemAndPersonList;
    }
}
