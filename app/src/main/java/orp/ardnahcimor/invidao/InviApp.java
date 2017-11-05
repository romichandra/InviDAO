package orp.ardnahcimor.invidao;

import android.app.Application;

import orp.ardnahcimor.invidao.database.InviDaoDatabase;

/**
 * Created by romichandra on 11/5/17.
 */

public class InviApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        InviDaoDatabase.getInstance().init(this);
    }
}
