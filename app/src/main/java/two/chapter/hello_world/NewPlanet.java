package two.chapter.hello_world;

import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class NewPlanet extends ActionBarActivity {
    private MediaPlayer marsPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_planet);

        final RelativeLayout newPlanetScreen = (RelativeLayout)findViewById(R.id.new_planet_screen);
        final TransitionDrawable trans = (TransitionDrawable) getResources().getDrawable(R.drawable.tran_stars_galaxy);
        newPlanetScreen.setBackground(trans);

        ImageView marsImage = (ImageView)findViewById(R.id.imageMars);
        marsPlayer = MediaPlayer.create(this,R.raw.mars);
        Button doneButton = (Button)findViewById(R.id.doneAddingButton);


        marsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorldGen mars = new WorldGen("Mars",642,3.7);
                mars.setPlanetColonies(1);
                Toast.makeText(NewPlanet.this,"Mars Created",Toast.LENGTH_SHORT).show();
                trans.startTransition(5000);
                marsPlayer.start();
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
        getMenuInflater().inflate(R.menu.menu_new_planet, menu);
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
