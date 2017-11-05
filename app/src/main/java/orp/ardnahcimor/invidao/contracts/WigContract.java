package orp.ardnahcimor.invidao.contracts;

import java.util.List;

import orp.ardnahcimor.invidao.database.model.Wig;

/**
 * Created by romichandra on 11/5/17.
 */

public class WigContract {

    public interface Presenter {
        void loadWigs();
        void saveWig(Wig wig);
        long getCountDb();
        void ObserveSavedWig(Wig wig);
    }

    public interface View {
        void showError(String errorMsg);
        void showWigs(List<Wig> wigs);
        void showWig(Wig wig);
    }
}
