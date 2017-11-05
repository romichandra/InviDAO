package orp.ardnahcimor.invidao.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

import orp.ardnahcimor.invidao.database.model.DaoMaster;

/**
 * Created by romichandra on 11/5/17.
 */

public class InviDbOpenHelper extends DaoMaster.OpenHelper {

    public InviDbOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        switch (oldVersion) {
            default:
                break;
        }
    }
}
