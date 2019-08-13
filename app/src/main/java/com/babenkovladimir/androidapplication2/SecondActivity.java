package com.babenkovladimir.androidapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    Intent intent = getIntent();

    if(intent.hasExtra("message")){
      String message = intent.getStringExtra("message");

//      Bundle bundle = intent.getBundleExtra("bundle");
//      bundle.getString("message", "deafult message");

      Log.d("SKILLUP", "message from first activity - " + message);
    }

  }
}
