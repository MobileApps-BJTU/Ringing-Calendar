package com.xx.administrator.calendar1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageButton eventlist = (ImageButton)findViewById(R.id.imageButton2);
        eventlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Activity2Intent = new Intent(getApplicationContext(),
                        EventList.class);
                startActivity(Activity2Intent);
            }
        });
        final ImageButton addEvent = (ImageButton)findViewById(R.id.imageButton);
        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddEventIntent = new Intent(getApplicationContext(),
                        AddEventActivity.class);
                startActivity(AddEventIntent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
