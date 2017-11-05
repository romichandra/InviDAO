package orp.ardnahcimor.invidao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import orp.ardnahcimor.invidao.model.Wig;


public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        insert();

        List<Wig> wigs = fetch();

        updateTextWigs(wigs);
    }

    private void init(){
        textView = findViewById(R.id.text);
    }

    private boolean insert(){
        try {
            long l = 10L;
            while (l > 0L)
                ((InviApp)getApplication()).getDaoSession().insertOrReplace(new Wig(l--,"wig_name", "wig_gender", "wig_subType", "wig_info", "wing_type"));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private List<Wig> fetch(){
        try{
            return ((InviApp)getApplication()).getDaoSession().getWigDao().loadAll();
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
