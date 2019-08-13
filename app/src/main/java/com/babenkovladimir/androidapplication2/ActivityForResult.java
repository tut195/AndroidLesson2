package com.babenkovladimir.androidapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityForResult extends AppCompatActivity {

  @BindView(R.id.btCloseActivtyWithResult)
  Button mButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_for_result);
    ButterKnife.bind(this);

    //mButton = findViewById(R.id.btCloseActivtyWithResult);
    EditText editText = findViewById(R.id.editText);

    mButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        String message = editText.getText().toString();

        Intent data = new Intent();
        data.putExtra("message", message);

        setResult(RESULT_OK, data);
        finish();
        // setResult(RESULT_CANCELED);
      }
    });


  }
}
