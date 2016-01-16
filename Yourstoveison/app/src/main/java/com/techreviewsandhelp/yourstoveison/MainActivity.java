package com.techreviewsandhelp.yourstoveison;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiConfiguration;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.service.notification.StatusBarNotification;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import javax.net.ssl.SSLEngineResult;


public class MainActivity extends ActionBarActivity {

    NotificationManager nmanger;
    private Button mStove;
    private Button mHelp;
    private static final String PREFS_FILE = "com.techreviewsandhelp.yourstoveison.preferences";
    private static final String Stove_S = "stove_s";
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mShare;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ID
        mStove = (Button) findViewById(R.id.stove_button);
        mHelp   = (Button) findViewById(R.id.button);

        nmanger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


//stove button
    View.OnClickListener listener = new View.OnClickListener(){
      public void onClick(View v){
          if (mStove.getText().equals("Off")){
              mStove.setText("On");
          }else {
              mStove.setText("Off");
              }
            //save
            mEditor.putString(Stove_S, mStove.getText().toString());
          mEditor.apply();
          }};
        //help button
        View.OnClickListener help = new View.OnClickListener(){
        public void onClick(View v){
            Intent myIntent = new Intent(v.getContext(), Help.class);
            startActivity(myIntent);
            onPause();
        }};
        mStove.setOnClickListener(listener);
        mHelp.setOnClickListener(help);
    }

    @Override
    protected void onStart(){
        super.onStart();
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        final String stove = preferences.getString(Data.Stove,
                Data.default_Stove);

       //load
        mShare = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mShare.edit();
        String edit = mShare.getString(Stove_S, "");
        mStove.setText(edit);
    }
}


