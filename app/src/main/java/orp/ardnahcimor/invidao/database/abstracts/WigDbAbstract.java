package orp.ardnahcimor.invidao.database.abstracts;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import orp.ardnahcimor.invidao.database.model.Wig;

/**
 * Created by romichandra on 11/5/17.
 */

public interface WigDbAbstract {

    Flowable<List<Wig>> getAllWigs();

    Observable<Wig> getWigById(long id);

    void saveWig(@NonNull Wig wig);

    void deleteWig(long id);

    long getTotalWigCount();

}