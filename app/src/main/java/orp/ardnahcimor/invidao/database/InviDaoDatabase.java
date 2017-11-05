package orp.ardnahcimor.invidao.database;

import android.content.Context;
import android.support.annotation.NonNull;

import org.greenrobot.greendao.database.Database;

import orp.ardnahcimor.invidao.database.model.DaoMaster;
import orp.ardnahcimor.invidao.database.model.DaoSession;

/**
 * Created by romichandra on 11/5/17.
 */

public class InviDaoDatabase {

    private static DaoSession mDaoSession;
    public static final boolean ENCRYPTED = true;

    private InviDaoDatabase() {
    }

    private static class Singleton {
        private static final InviDaoDatabase singleInstance = new InviDaoDatabase();
    }

    public static InviDaoDatabase getInstance() {
        return Singleton.singleInstance;
    }

    public void init(Context context) {
        init(context, "invi_dao.db");
    }

    public void init(@NonNull Context context, @NonNull String dbName) {
        InviDbOpenHelper helper = new InviDbOpenHelper(context.getApplicationContext(), ENCRYPTED ? "encrypted" + dbName : dbName );
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("invi-invisible") : helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        if (null == mDaoSession) {
            throw new NullPointerException("invi db has not been initialized");
        }
        return mDaoSession;
    }
}