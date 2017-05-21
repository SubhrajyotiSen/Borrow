package com.subhrajyoti.borrow.addItem;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.subhrajyoti.borrow.db.AppDatabase;
import com.subhrajyoti.borrow.db.BorrowModel;


public class AddBorrowViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddBorrowViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

    }

    public void addBorrow(final BorrowModel borrowModel) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                appDatabase.itemAndPersonModel().addBorrow(borrowModel);

            }
        });
        thread.start();
    }
}
