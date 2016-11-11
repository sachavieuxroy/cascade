package google.android.com.cascade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ChoisireUnNiveauActivity extends AppCompatActivity implements ToggleButton.OnClickListener {
    private Boolean isChecked ;
    private ToggleButton btn_niveah1 = null;
    private ToggleButton btn_niveah2 = null;
    private ToggleButton btn_niveah3 = null;
    private Button nextbutton = null;

    private TextView MsgTextView = null;
    private TextView SummaryTextView = null;

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.QuitButton:
                finish();
                return true;
            case R.id.SoundButton:
                isChecked = !item.isChecked();
                item.setChecked(isChecked);
                if (isChecked == true) {
                    item.setIcon(R.drawable.ic_minimal_speaker_icon_2);
                }else{
                    item.setIcon(R.drawable.ic_minimal_disabled__speaker_icon_2);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choisire_un_niveau);


        btn_niveah1 = (ToggleButton) findViewById(R.id.btn_niveau1);
        btn_niveah2 = (ToggleButton) findViewById(R.id.btn_niveau2);
        btn_niveah3 = (ToggleButton) findViewById(R.id.btn_niveau3);
        MsgTextView = (TextView) findViewById(R.id.MessagetextView);
        SummaryTextView = (TextView) findViewById(R.id.SummaryTextView);
        nextbutton = (Button) findViewById(R.id.nextbutton);

        btn_niveah1.setOnClickListener(this);
        btn_niveah2.setOnClickListener(this);
        btn_niveah3.setOnClickListener(this);
        nextbutton.setOnClickListener(this);

        SummaryTextView.setText(Html.fromHtml(getResources().getString(R.string.summary_txt)));

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_niveau1) {
            setNiveau1MsgTxt(true);
        }else if (v.getId() == R.id.btn_niveau2){
            setNiveau2MsgTxt(true);
        }else if (v.getId() == R.id.btn_niveau3) {
            setNiveau3MsgTxt(true);
        }

        if (v.getId() == R.id.nextbutton) {
            if (btn_niveah1.isChecked()== false && btn_niveah2.isChecked()==false && btn_niveah3.isChecked()==false) {
                Toast.makeText(this, "Le Niveau n'est pas selectioner.", Toast.LENGTH_SHORT).show();
                return;
            }else{
                if (btn_niveah1.isChecked()) {
                    Intent i = new Intent(this,Niveau1Activity.class);
                    finish();
                    startActivity(i);
                }
            }
        }

    }


    private void setMsgTextView() {
        if(btn_niveah1.isChecked()){
            MsgTextView.setText("Travail avec une regle simple niveau.");
        }
        if(btn_niveah2.isChecked()){
            MsgTextView.setText("Travail avec une regle double niveau");
        }
        if(btn_niveah3.isChecked()){
            MsgTextView.setText("Attention! Ne peut etre utilise qu'apres Niveau 1 et Niveau2");
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        setMsgTextView();
    }

    private void setNiveau1MsgTxt (Boolean checked) {
        btn_niveah1.setChecked(checked);
        btn_niveah2.setChecked(!btn_niveah1.isChecked());
        btn_niveah3.setChecked(!btn_niveah1.isChecked());
        setMsgTextView();
    }

    private void setNiveau2MsgTxt (Boolean checked) {
        btn_niveah2.setChecked(checked);
        btn_niveah1.setChecked(!btn_niveah2.isChecked());
        btn_niveah3.setChecked(!btn_niveah2.isChecked());
        setMsgTextView();
    }


    private void setNiveau3MsgTxt (Boolean checked) {
        btn_niveah3.setChecked(checked);
        btn_niveah1.setChecked(!btn_niveah3.isChecked());
        btn_niveah2.setChecked(!btn_niveah3.isChecked());
        setMsgTextView();
    }
}
