package com.subhrajyoti.borrow.addItem;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.subhrajyoti.borrow.db.AppDatabase;
import com.subhrajyoti.borrow.db.ItemAndPerson;


public class AddBorrowViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddBorrowViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getInMemoryDatabase(this.getApplication());

    }

    public void addBorrow(final ItemAndPerson itemAndPerson) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                appDatabase.itemAndPersonModel().addBorrow(itemAndPerson);

            }
        });
        thread.start();
    }
}
