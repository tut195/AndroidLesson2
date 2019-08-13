package com.babenkovladimir.androidapplication2;

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
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private static final int REQUEST_CODE_ACTIVITY_FOR_RESULT = 1000;
  private Button mBt, mBt1, mBt2, mBt3;
  private TextView tvResult;

  //  private static final String TAG = MainActivity.class.getSimpleName();
  private static final String TAG = "SKILLUP";

  private View.OnClickListener globalListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      // Nothing happens
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

        if (data != null && data.hasExtra("message")) {
          String message = data.getStringExtra("message");
          tvResult.setText(message);
        }

        break;
    }
  }

  // Lifecycle

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    Log.d(TAG, "onCreate");
    //Log.d("SKILLUP", "SkillUp hello");

    //Log.d(TAG, "saved state = " + savedInstanceState);

    initViews();
    setupListeners();

  }

  private void initViews() {
    tvResult = findViewById(R.id.tvResult);

    mBt = (Button) findViewById(R.id.btShowDialog);
    mBt1 = (Button) findViewById(R.id.btShowDialog1);
    mBt2 = (Button) findViewById(R.id.btShowDialog2);
    mBt3 = (Button) findViewById(R.id.btShowDialog3);

    mBt3.setText(R.string.open_second_activity);
    mBt2.setText("Open for result");
  }

  private void setupListeners() {
    mBt.setOnClickListener(new OnClickListener() {
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

    mBt.setOnClickListener(clickListener);
    mBt1.setOnClickListener(globalListener);
    mBt2.setOnClickListener(this);
    mBt3.setOnClickListener(this);
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d(TAG, "onStart");
//    Log.i(TAG, "onStart");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(TAG, "onResume");
//    Log.wtf("", "");
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

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
  }
}
