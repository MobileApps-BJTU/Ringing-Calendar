package com.xx.administrator.calendar1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;


public class AddEventActivity extends ActionBarActivity {

    private EditText titleInput;
    private EditText locationInput;
    private TextView timeSelect;
    private TextView remindTypeSelect;
    private TextView alertTimeSelect;
    private TextView repeatType;
    private EditText noteEditText;

    private TextView dateDisplay;
    private int mYear;
    private int mMonth;
    private int mDay;


    //prepare the dialog ID
    static final int DATE_DIALOG_ID = 0;

    //准备日期设置监听器
    private DatePickerDialog.OnDateSetListener ds1 = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMonth){
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            dateDisplay.setText(mYear+"-"+(mMonth+1)+"-"+mDay);
        }
    };

    //重写创建对话框的方法
    /*@Override
    protected Dialog onCreateDialog(int id){
        switch(id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,ds1,mYear,mMonth,mDay);
        }
        return null;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        titleInput = (EditText)findViewById(R.id.titleEditText);
        locationInput = (EditText)findViewById(R.id.locationInput);
        remindTypeSelect = (TextView)findViewById(R.id.remindTypeSelect);
        alertTimeSelect = (TextView)findViewById(R.id.alertTimeSelect);
        repeatType = (TextView)findViewById(R.id.repeatTypeSelect);
        noteEditText = (EditText)findViewById(R.id.noteEditText);

        //得到当前日期
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        timeSelect = (TextView)findViewById(R.id.timeSelect);
        timeSelect.setText(mYear+"-"+(mMonth+1)+"-"+mDay);

        //给TextView绑定点击监听器
        timeSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // showDialog(DATE_DIALOG_ID);
            }
        });

        //给repeatTextView添加监听器
        repeatType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RepeatIntent = new Intent(getApplicationContext(),
                        RepeatActivity.class);
                startActivity(RepeatIntent);
            }
        });

        //给alertTimeTextView添加监听器
        alertTimeSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AlertTimeIntent = new Intent(getApplicationContext(),
                        AlertTimeActivity.class);
                startActivity(AlertTimeIntent);
            }
        });

        //给remindTypeSelect添加监听器
        remindTypeSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RemindTypeIntent = new Intent(getApplicationContext(),
                        RemindTypeActivity.class);
                startActivity(RemindTypeIntent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_event, menu);
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
