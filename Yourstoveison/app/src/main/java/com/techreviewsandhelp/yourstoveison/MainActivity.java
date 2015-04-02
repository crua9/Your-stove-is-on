package com.techreviewsandhelp.yourstoveison;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.service.notification.StatusBarNotification;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    NotificationManager nmanger;
    static final int uniqueID = 1315315;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button stove = (Button)findViewById(R.id.toggleButton);
        stove.setOnClickListener(this);
        Button help = (Button)findViewById(R.id.button);
        help.setOnClickListener(this);
        nmanger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, StatusBarNotification.class);
        PendingIntent pi = PendingIntent.getActivities(this, 0, intent, 0);
        String body = "Your stove is on";
        String title = "stoveon";
        Notification n = new Notification(R.drawable.icon, body, System.currentTimeMillis());
        n.setLatestEventInfo(this, title, body, pi);
        n.defaults = Notification.DEFAULT_ALL;
        nmanger.notify(uniqueID, n);
    }

      }

