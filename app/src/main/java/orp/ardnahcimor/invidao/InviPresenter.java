package orp.ardnahcimor.invidao;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import orp.ardnahcimor.invidao.contracts.WigContract;
import orp.ardnahcimor.invidao.database.abstracts.WigDbAbstract;
import orp.ardnahcimor.invidao.database.concretes.WigDbConcrete;
import orp.ardnahcimor.invidao.database.model.Wig;

/**
 * Created by romichandra on 11/5/17.
 */

public class InviPresenter implements WigContract.Presenter {

    @NonNull
    private WigContract.View mWigView;

    private WigDbAbstract mWigDb;

    public InviPresenter(WigContract.View mWigView) {
        mWigDb = new WigDbConcrete();
        this.mWigView = mWigView;
    }

    @Override
    public void loadWigs() {
        mWigDb.getAllWigs().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(
                new Consumer<Subscription>() {
                    @Override
                    public void accept(Subscription subscription) throws Exception {

                    }
                }
        ).subscribe(new Consumer<List<Wig>>() {
                        @Override
                        public void accept(List<Wig> wigs) throws Exception {
                            mWigView.showWigs(wigs);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            mWigView.showError(throwable.getMessage());
                        }
                    });
    }

    /*
    * not implemented
    * */
    @Override
    public void ObserveSavedWig(Wig wig) {
        ReplaySubject<Wig> wigSubject = ReplaySubject.create();
        wigSubject.subscribe(new Consumer<Wig>() {
            @Override
            public void accept(Wig wig) throws Exception {
                mWigView.showWig(wig);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mWigView.showError(throwable.getMessage());
            }
        });

    }

    @Override
    public void saveWig(Wig wig) {
        mWigDb.saveWig(wig);
    }

    @Override
    public long getCountDb() {
        return mWigDb.getTotalWigCount();
    }
}
