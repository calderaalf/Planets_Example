package two.chapter.hello_world;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


public class AttackActivity extends ActionBarActivity {
    private MediaPlayer bombPlayer = null;
    private MediaPlayer transportPlayer = null;
    private MediaPlayer virusPlayer = null;
    private MediaPlayer laserPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack);
        setAudioPlayers();

        ImageButton bombButton = (ImageButton)findViewById(R.id.bombButton);
        Animation rotateBomb  = AnimationUtils.loadAnimation(this,R.anim.anim_rot_bomb);
        bombButton.startAnimation(rotateBomb);
        bombButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AttackActivity.this, "Bombs Away!!", Toast.LENGTH_SHORT).show();
                bombPlayer.start();
            }
        });

        ImageView invadeEffect = (ImageView)findViewById(R.id.invadeEffect);
        AnimationDrawable transporterEffect = (AnimationDrawable)invadeEffect.getBackground();
        transporterEffect.start();
        ImageButton invadeButton = (ImageButton)findViewById(R.id.invadeButton);
        Animation alphaInvade = AnimationUtils.loadAnimation(this,R.anim.anim_alpha_invade);
        invadeButton.startAnimation(alphaInvade);
        invadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AttackActivity.this,"Troops Sent!",Toast.LENGTH_SHORT).show();
                transportPlayer.start();
            }
        });


        ImageButton infectButton = (ImageButton)findViewById(R.id.infectButton);
        Animation scaleVirus = AnimationUtils.loadAnimation(this,R.anim.anim_scale_virus);
        infectButton.startAnimation(scaleVirus);
        infectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AttackActivity.this,"Virus Spread!",Toast.LENGTH_SHORT).show();
                virusPlayer.start();
            }
        });

        ImageButton laserButton = (ImageButton)findViewById(R.id.laserButton);
        Animation translateLaser = AnimationUtils.loadAnimation(this,R.anim.anim_trans_laser);
        laserButton.startAnimation(translateLaser);
        laserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AttackActivity.this,"Laser Fired!",Toast.LENGTH_SHORT).show();
                laserPlayer.start();
            }
        });

        ImageButton exitButton = (ImageButton)findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
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
        getMenuInflater().inflate(R.menu.menu_attack, menu);
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


    private void setAudioPlayers(){
        bombPlayer = MediaPlayer.create(getApplicationContext(),R.raw.blast);
        transportPlayer = MediaPlayer.create(getApplicationContext(),R.raw.transport);
        virusPlayer = MediaPlayer.create(getApplicationContext(),R.raw.virus);
        laserPlayer = MediaPlayer.create(getApplicationContext(),R.raw.laser);

    }
}
