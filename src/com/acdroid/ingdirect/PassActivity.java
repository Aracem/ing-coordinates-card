
package com.acdroid.ingdirect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class PassActivity extends Activity implements OnEditorActionListener {

    private static final String PASS = "1234";
    private EditText pass;
    private View layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);

        pass = (EditText) findViewById(R.id.pass);
        layout = findViewById(R.id.layout);

        layout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String password = pass.getText().toString();

                if (PASS.equals(password)) {
                    Intent i = new Intent(PassActivity.this, Codes.class);
                    startActivity(i);
                    finish();
                }
                else {
                    pass.setText("");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_pass, menu);
        return true;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        switch (actionId) {
            case EditorInfo.IME_ACTION_GO:
                pass.setText("");
                return true;
        }

        return false;

    }
}
