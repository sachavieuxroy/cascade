package google.android.com.cascade;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

public class Niveau3Activity extends AppCompatActivity {
    private Boolean isChecked ;
    private Button Niveau1Button = null;
    private Button Niveau2Button = null;
    private Button Niveau3Button = null;

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
        setContentView(R.layout.niveau3_layout);

    }

}
