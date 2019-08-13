package com.babenkovladimir.androidlesson2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private static final int REQUEST_CODE_ACTIVITY_FOR_RESULT = 1;

  Button bt, bt1, bt2, bt3;
  TextView tvResult;

  //  private static final String TAG = MainActivity.class.getSimpleName();
  private static final String TAG = "SKILLUP";
  private View.OnClickListener globalListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
  };

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    switch (requestCode) {
      case REQUEST_CODE_ACTIVITY_FOR_RESULT:
        if (resultCode == RESULT_CANCELED) {
          return;
        }

        if (data.hasExtra("message")) {
          String message = data.getStringExtra("message");
          tvResult.setText(message);

        }

        break;
    }
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d(TAG, "onCreate");
    Log.d(TAG, "saved state = " + savedInstanceState);

    initViews();
    setupListeners();

  }

  private void initViews() {
    tvResult = findViewById(R.id.tvResultr);

    bt = (Button) findViewById(R.id.btShowDialog);
    bt1 = (Button) findViewById(R.id.btShowDialog1);
    bt2 = (Button) findViewById(R.id.btShowDialog2);
    bt3 = (Button) findViewById(R.id.btShowDialog3);

    bt3.setText(R.string.open_second_activity);
    bt2.setText("Open for result");


  }

  private void setupListeners() {
    bt.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        onShowDialogBtClick(view);
      }
    });

    View.OnClickListener clickListener = new OnClickListener() {
      @Override
      public void onClick(View view) {
        onShowDialogBtClick(view);
      }
    };

    bt.setOnClickListener(clickListener);
    bt1.setOnClickListener(globalListener);
    bt2.setOnClickListener(this);
    bt3.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    //onShowDialogBtClick(view);

    int id = view.getId();
    switch (id) {
      case R.id.btShowDialog2:
        Intent resultIntent = new Intent(this, ActivityForResult.class);
        startActivityForResult(resultIntent, REQUEST_CODE_ACTIVITY_FOR_RESULT);

        break;
      case R.id.btShowDialog3:

        Intent secondActivityIntent = new Intent(this, SecondActivity.class);
        //Bundle bundle = new Bundle();

        secondActivityIntent.putExtra("message", "Hello from First Activity");

        startActivity(secondActivityIntent);

        break;

    }
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d(TAG, "onStart");
    Log.i(TAG, "onStart");
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(TAG, "onResume");
    Log.wtf("", "");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(TAG, "onPause");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(TAG, "onStop");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "onDestroy");
  }

  //  public void onShowDialogBtClick(View view) {
  public void onShowDialogBtClick(View view) {

    AlertDialog.Builder builder = new Builder(this)
        .setMessage("Popup message")
        .setCancelable(true);

    AlertDialog dialog = builder.create();

    dialog.show();

//    new AlertDialog
//        .Builder(this)
//        .setMessage("Messagew")
//        .setCancelable(false)
//        .create()
//        .show();
  }
}
