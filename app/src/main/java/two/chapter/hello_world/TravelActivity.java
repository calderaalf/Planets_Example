package two.chapter.hello_world;

import android.widget.MediaController;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;


public class TravelActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        Uri uriVideo = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.mars270);
        VideoView travelVideo =(VideoView)findViewById(R.id.travelVideoView);
        travelVideo.setVideoURI(uriVideo);
        MediaController videoMediaController = new MediaController(this);
        videoMediaController.setAnchorView(travelVideo);
        travelVideo.setMediaController(videoMediaController);
        travelVideo.bringToFront();
        travelVideo.requestFocus();
        travelVideo.start();

        Button travelButton = (Button)findViewById(R.id.travelButton);
        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(TravelActivity.this,"Going home!!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

       /* travelVideo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(TravelActivity.this,"Going Home!!!",Toast.LENGTH_LONG).show();
                finish();
                return true;
            }
        }); */

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
        getMenuInflater().inflate(R.menu.menu_travel, menu);
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
