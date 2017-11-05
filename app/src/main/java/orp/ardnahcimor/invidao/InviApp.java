package orp.ardnahcimor.invidao;

import android.app.Application;

import orp.ardnahcimor.invidao.model.DaoMaster;
import orp.ardnahcimor.invidao.model.DaoSession;
import orp.ardnahcimor.invidao.model.Wig;

/**
 * Created by romichandra on 11/5/17.
 */

public class InviApp extends Application{

    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession = new DaoMaster(
                new InviDbOpenHelper(this, "invi_dao.db").getWritableDb()).newSession();

    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
