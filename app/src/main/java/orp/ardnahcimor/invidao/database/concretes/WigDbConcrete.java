package orp.ardnahcimor.invidao.database.concretes;

import android.support.annotation.NonNull;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import orp.ardnahcimor.invidao.database.InviDaoDatabase;
import orp.ardnahcimor.invidao.database.abstracts.WigDbAbstract;
import orp.ardnahcimor.invidao.database.model.Wig;
import orp.ardnahcimor.invidao.database.model.WigDao;

/**
 * Created by romichandra on 11/5/17.
 */

public class WigDbConcrete implements WigDbAbstract {

    private WigDao getWigDao() {
        return InviDaoDatabase.getInstance().getDaoSession().getWigDao();
    }

    @Override
    public Flowable<List<Wig>> getAllWigs() {
        try{
            return Flowable.fromCallable(new Callable<List<Wig>>() {
                @Override
                public List<Wig> call() throws Exception {
                    return getWigDao().loadAll();
                }
            });
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public Observable<Wig> getWigById(final long id) {
        try{
            return Observable.fromCallable(new Callable<Wig>() {
                @Override
                public Wig call() throws Exception {
                    return getWigDao().load(id);
                }
            });
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public void saveWig(@NonNull Wig wig) {
        getWigDao().save(wig);
    }

    @Override
    public void deleteWig(long id) {
        getWigDao().deleteByKey(id);
    }

    @Override
    public long getTotalWigCount() {
        return getWigDao().count();
    }
}
