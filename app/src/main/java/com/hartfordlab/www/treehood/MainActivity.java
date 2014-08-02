package com.hartfordlab.www.treehood;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    ServerManager serverManager;
    TextView title;
    EditText user;
    EditText pass;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        title = (TextView) findViewById(R.id.title);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.button);

        serverManager = new ServerManager();
        Typeface fontMusket = Typeface.createFromAsset(getAssets(), "fonts/Musket bold.ttf");
        Typeface fontRobo = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Black.ttf");
        Typeface fontRobo2 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        button.setTypeface(fontRobo2);
        title.setTypeface(fontMusket);
        user.setTypeface(fontRobo);
        pass.setTypeface(fontRobo);

        getActionBar().hide();



        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
    }



    //overrides the dispatchTouchEvent so that the keyboard closes when a user
    //touches elsewhere on the screen
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        View v = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);

        if (v instanceof EditText) {
            View w = getCurrentFocus();
            int scrcoords[] = new int[2];
            w.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + w.getLeft() - scrcoords[0];
            float y = event.getRawY() + w.getTop() - scrcoords[1];

            Log.d("Activity", "Touch event " + event.getRawX() + "," + event.getRawY() + " " + x + "," + y + " rect " + w.getLeft() + "," + w.getTop() + "," + w.getRight() + "," + w.getBottom() + " coords " + scrcoords[0] + "," + scrcoords[1]);
            if (event.getAction() == MotionEvent.ACTION_UP && (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w.getBottom()) ) {

                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
    }

    public void login(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        String username = ((EditText)findViewById(R.id.username)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();


        User user = serverManager.login(username,password);
        System.out.println("j_: in MainActivity, username: " + user.getName());


        intent.putExtra("USER",user);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
