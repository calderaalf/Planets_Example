package two.chapter.hello_world;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class ConfigActivity extends ActionBarActivity {
    private MediaPlayer clickPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        clickPlayer = MediaPlayer.create(getApplicationContext(),R.raw.click);
        EditText colonyText = (EditText)findViewById(R.id.editTextColonies);
        colonyText.setText("1", EditText.BufferType.EDITABLE);
        EditText colonistText = (EditText)findViewById(R.id.editTextColonist);
        colonistText.setText("100", EditText.BufferType.EDITABLE);
        EditText baseText = (EditText)findViewById(R.id.editTextBases);
        baseText.setText("1", EditText.BufferType.EDITABLE);
        EditText militaryText = (EditText)findViewById(R.id.editTextMilitary);
        militaryText.setText("10", EditText.BufferType.EDITABLE);
        EditText forceFieldOnText = (EditText)findViewById(R.id.editTextForcefieldOn);
        forceFieldOnText.setText("", EditText.BufferType.EDITABLE);
        EditText forceFieldOffText = (EditText)findViewById(R.id.editTextForcefieldOff);
        forceFieldOffText.setText("Force Field is Off!", EditText.BufferType.EDITABLE);


        Button colonyButton = (Button)findViewById(R.id.coloniesButton);
        colonyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlayer.start();
                finish();
            }
        });

        Button colonistButton = (Button)findViewById(R.id.colonistsButton);
        colonistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlayer.start();
                finish();
            }
        });
        Button baseButton = (Button)findViewById(R.id.basesButton);
        baseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlayer.start();
                finish();
            }
        });
        Button militaryButton = (Button)findViewById(R.id.militaryButton);
        militaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlayer.start();
                finish();
            }
        });
        Button forceFieldButtonOn = (Button)findViewById(R.id.coloniesFfon);
        forceFieldButtonOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlayer.start();
                finish();
            }
        });
        Button forceFieldButtonOff = (Button)findViewById(R.id.coloniesFfoff);
        forceFieldButtonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlayer.start();
                finish();
            }
        });
        Button doneButton = (Button)findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickPlayer.start();
                finish();
            }
        });

        Button timeButton = (Button)findViewById(R.id.timeButton);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callTimeIntent = new Intent(getApplicationContext(),TimePlanet.class);
                startActivityForResult(callTimeIntent,0);
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_X){
            finish();
            return true;
        }
        return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_config, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
