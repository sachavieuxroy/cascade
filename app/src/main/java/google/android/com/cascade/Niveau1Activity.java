package google.android.com.cascade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Niveau1Activity extends AppCompatActivity {
    private Boolean isChecked ;
    private ToggleButton btn_lechantierradio = null;
    private ToggleButton btn_lapatisserieradio = null;
    private TextView MsgTextView = null;
    private ImageView InfoImageView = null;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this,ChoisireUnNiveauActivity.class);
        finish();
        startActivity(i);
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
        setContentView(R.layout.niveau1_layout);

        btn_lechantierradio = (ToggleButton) findViewById(R.id.btn_lechantierradio);
        btn_lapatisserieradio = (ToggleButton) findViewById(R.id.btn_lapatisserieradio);
        MsgTextView = (TextView) findViewById(R.id.MsgTextView);
        InfoImageView = (ImageView) findViewById(R.id.InfoImageView);

    }

    public void onToggle(View view) {
        if (view.getId() == R.id.btn_lapatisserieradio) {
            setCheckedLeChantier(!btn_lapatisserieradio.isChecked());
        }else{
            setCheckedLePatisserie(!btn_lechantierradio.isChecked());
        }
    }

    private void setMsgTextView() {
        if(btn_lechantierradio.isChecked()){
            MsgTextView.setText(R.string.lechantier_help_txt);
            InfoImageView.setImageResource(R.drawable.lechantierpic);
        }
        if(btn_lapatisserieradio.isChecked()){
            MsgTextView.setText(R.string.lapatisserie_help_txt);
            InfoImageView.setImageResource(R.drawable.lapatisserie);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        setMsgTextView();
    }

    private void setCheckedLeChantier (Boolean checked) {
        btn_lechantierradio.setChecked(checked);
        setMsgTextView();
    }

    private void setCheckedLePatisserie (Boolean checked) {
        btn_lapatisserieradio.setChecked(checked);
        setMsgTextView();
    }


}
