package com.babenkovladimir.androidlesson2;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityForResult extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_for_result);

    Button button = findViewById(R.id.btCloseActivtyWithResult);
    EditText editText = findViewById(R.id.editText);

    button.setOnClickListener(new OnClickListener() {
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
