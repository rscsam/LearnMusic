package activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.learn_music.sylan.learnmusic.R;

import control.DataManager;
import model.StringNumberBinder;

import model.Note;

public class PracticeActivity extends AppCompatActivity {

    private Note[] notes;
    private int score;
    private int passCount;
    private int missed;
    private StringNumberBinder scoreKeeper;
    private StringNumberBinder passKeeper;

    private TextView timerTV;
    private CountDownTimer timer;
    private int speed;
    private boolean timerStarted;
    private int timeTaken;

    private Note currentNote;
    private int turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Practice Reading Music");

        Intent startedFromSelection = getIntent();
        Bundle extras = startedFromSelection.getExtras();
        boolean treble = extras.getBoolean("sylan.treble");
        boolean bass = extras.getBoolean("sylan.bass");
        boolean alto = extras.getBoolean("sylan.tenor");
        int speedRef = extras.getInt("sylan.speed");
        if (speedRef == R.id.fast_rb) {
            speed = 4000;
        } else if (speedRef == R.id.slow_rb) {
            speed = 12000;
        } else if (speedRef == R.id.medium_rb) {
            speed = 8000;
        } else {
            speed = R.id.notime_rb;
        }
        notes = new Note[trebleNotes().length];
        notes = trebleNotes();
        score = 0;
        passCount = 0;
        missed = 0;
        scoreKeeper = new StringNumberBinder("Score", score);
        passKeeper = new StringNumberBinder("Passes Used", passCount);

        timerTV = (TextView) findViewById(R.id.timer_text);
        timeTaken = 0;
        turn = 0;
        generateNextNote();
    }

    private Note[] trebleNotes() {
        Note[] trebleNotes = new Note[7];
        trebleNotes[0] = new Note("A", R.drawable.a);
        trebleNotes[1] = new Note("B", R.drawable.b);
        trebleNotes[2] = new Note("C", R.drawable.c);
        trebleNotes[3] = new Note("D", R.drawable.d);
        trebleNotes[4] = new Note("E", R.drawable.e);
        trebleNotes[5] = new Note("F", R.drawable.f);
        trebleNotes[6] = new Note("G", R.drawable.g);

        return trebleNotes;
    }

    private Note[] bassNotes() {
        return null;
    }

    private Note[] altoNotes() {
        return null;
    }

    public void generateNextNote() {
        int rand = (int) (Math.random() * notes.length);
        currentNote = notes[rand];
        updateNoteImage();
        if (speed != R.id.notime_rb) {
            setTimer();
            timerStarted = true;
        }
        if (++turn >= notes.length) {
            fin();
        }
    }

    private void updateNoteImage() {
        ImageView noteImage = (ImageView) findViewById(R.id.current_note_image);
        noteImage.setImageResource(currentNote.getImage());
    }

    private void setTimer() {
        if (timerStarted) {
            timer.cancel();
        }
        timerTV.setTextColor(Color.BLACK);
        timer = new CountDownTimer(speed, 1000) {

            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished / 1000 == 3) {
                    timerTV.setTextColor(Color.YELLOW);
                } else if (millisUntilFinished / 1000 == 2) {
                    timerTV.setTextColor(Color.rgb(255, 128, 0));
                } else if (millisUntilFinished / 1000 == 1) {
                    timerTV.setTextColor(Color.RED);
                }
                timerTV.setText(Long.toString((millisUntilFinished / 1000)));
                timeTaken++;
            }

            @Override
            public void onFinish() {
                passOnClick(null);
            }
        };
        timer.start();
    }

    public void aOnClick(View v) {
        if (currentNote.getValue().equals("A")) {
            score++;
            updateCounts();
            generateNextNote();
        } else {
            missed++;
        }
    }

    public void bOnClick(View v) {
        if (currentNote.getValue().equals("B")) {
            score++;
            updateCounts();
            generateNextNote();
        } else {
            missed++;
        }
    }

    public void cOnClick(View v) {
        if (currentNote.getValue().equals("C")) {
            score++;
            updateCounts();
            generateNextNote();
        } else {
            missed++;
        }
    }

    public void dOnClick(View v) {
        if (currentNote.getValue().equals("D")) {
            score++;
            updateCounts();
            generateNextNote();
        } else {
            missed++;
        }
    }

    public void eOnClick(View v) {
        if (currentNote.getValue().equals("E")) {
            score++;
            updateCounts();
            generateNextNote();
        } else {
            missed++;
        }
    }

    public void fOnClick(View v) {
        if (currentNote.getValue().equals("F")) {
            score++;
            updateCounts();
            generateNextNote();
        } else {
            missed++;
        }
    }

    public void gOnClick(View v) {
        if (currentNote.getValue().equals("G")) {
            score++;
            updateCounts();
            generateNextNote();
        } else {
            missed++;
        }
    }

    public void passOnClick(View v) {
        passCount++;
        updateCounts();
        generateNextNote();
    }

    public void updateCounts() {
        scoreKeeper.setNumber(score);
        passKeeper.setNumber(passCount);
        TextView score = (TextView) findViewById(R.id.score_text);
        TextView pass = (TextView) findViewById(R.id.pass_view_text);
        score.setText(scoreKeeper.toString());
        pass.setText(passKeeper.toString());
    }

    private void fin() {
        DataManager dm = new DataManager();
        dm.storeScore(score);
        dm.storePassed(passCount);
        dm.storeTime(timeTaken);
        dm.storeMissed(missed);
        dm.storePoints(score);

        Intent startResultsActivity = new Intent(PracticeActivity.this, ResultsActivity.class);
        startResultsActivity.putExtra("sylan.score", score);
        startResultsActivity.putExtra("sylan.passCount", passCount);
        startResultsActivity.putExtra("sylan.timeTaken", timeTaken);
        startResultsActivity.putExtra("sylan.misses", missed);
        startActivity(startResultsActivity);
    }
}
