package orp.ardnahcimor.invidao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import orp.ardnahcimor.invidao.contracts.WigContract;
import orp.ardnahcimor.invidao.database.InviDaoDatabase;
import orp.ardnahcimor.invidao.database.concretes.WigDbConcrete;
import orp.ardnahcimor.invidao.database.model.Wig;


public class MainActivity extends AppCompatActivity implements WigContract.View {

    TextView textView;

    InviPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        insert();
//
//        List<Wig> wigs = fetch();
//
//        updateTextWigs(wigs);


    }

    private void init(){
        textView = findViewById(R.id.text);

        presenter = new InviPresenter(this);
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showWigs(List<Wig> wigs) {
        updateTextWigs(wigs);
    }

    @Override
    public void showWig(Wig wig) {
       // updateTextWig(wig);
    }

    private boolean insert(){
        try {
            long l = 10L;
            while (l > 0L)
//                InviDaoDatabase.getInstance().getDaoSession().insertOrReplace(new Wig(l--,"wig_name", "wig_gender", "wig_subType", "wig_info", "wing_type"));
                presenter.saveWig(new Wig(l--,"wig_name", "wig_gender", "wig_subType", "wig_info", "wing_type"));
            presenter.loadWigs();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private void updateTextWig(Wig wig){
        try{
            textView.setText(wig.toString() + "\n" + textView.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private List<Wig> fetch(){
        try{
            return InviDaoDatabase.getInstance().getDaoSession().getWigDao().loadAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private void updateTextWigs(List<Wig> wigs){
        try{
            for (Wig wig: wigs) {
                textView.setText(wig.toString() + "\n" + textView.getText());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
