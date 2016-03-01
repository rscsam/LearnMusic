package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.learn_music.sylan.learnmusic.R;

import model.StringNumberBinder;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Results");

        TextView scoreTV = (TextView) findViewById(R.id.score_tv);
        TextView passTV = (TextView) findViewById(R.id.pass_tv);
        TextView missTV = (TextView) findViewById(R.id.miss_tv);
        TextView timeTV = (TextView) findViewById(R.id.time_taken_tv);

        Intent prev = getIntent();
        Bundle extras = prev.getExtras();
        scoreTV.setText(new StringNumberBinder("Score", extras.getInt("sylan.score")).toString());
        passTV.setText(new StringNumberBinder("Passed", extras.getInt("sylan.passCount")).toString());
        missTV.setText(new StringNumberBinder("Missed", extras.getInt("sylan.missed")).toString());
        timeTV.setText(new StringNumberBinder("Time Taken", extras.getInt("sylan.timeTaken")).toString());
    }

}
