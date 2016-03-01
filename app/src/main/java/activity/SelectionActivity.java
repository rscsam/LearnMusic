package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import com.learn_music.sylan.learnmusic.R;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Set Your Preferences");

        Button startPracticeBttn = (Button) findViewById(R.id.start_practice_button);
        startPracticeBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox alto = (CheckBox) findViewById(R.id.alto_clef_cb);
                CheckBox bass = (CheckBox) findViewById(R.id.bass_clef_cb);
                CheckBox treble = (CheckBox) findViewById(R.id.treble_clef_cb);
                RadioGroup speeds = (RadioGroup) findViewById(R.id.speed_selection_rg);

                Intent startPractice = new Intent(SelectionActivity.this, PracticeActivity.class);
                startPractice.putExtra("sylan.alto", alto.isChecked());
                startPractice.putExtra("sylan.bass", bass.isChecked());
                startPractice.putExtra("sylan.treble", treble.isChecked());
                startPractice.putExtra("sylan.speed", speeds.getCheckedRadioButtonId());
                startActivity(startPractice);
            }
        });
    }
}