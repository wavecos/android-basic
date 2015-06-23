package com.xiobit.calculator;

import android.nfc.Tag;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private static final String TAG = "Calculator";

    TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Initializing Calculator App...");

        displayTextView = (TextView) findViewById(R.id.displayTextView);

        findViewById(R.id.digit0Button).setOnClickListener(this);
        findViewById(R.id.digit1Button).setOnClickListener(this);
        findViewById(R.id.digit2Button).setOnClickListener(this);
        findViewById(R.id.digit3Button).setOnClickListener(this);
        findViewById(R.id.digit4Button).setOnClickListener(this);
        findViewById(R.id.digit5Button).setOnClickListener(this);
        findViewById(R.id.digit6Button).setOnClickListener(this);
        findViewById(R.id.digit7Button).setOnClickListener(this);
        findViewById(R.id.digit8Button).setOnClickListener(this);
        findViewById(R.id.digit9Button).setOnClickListener(this);

        // Clear Behavior
        findViewById(R.id.clearButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTextView.setText("0");
            }
        });

        // Sin(x) function
        findViewById(R.id.sinButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double displayValue = Double.valueOf( displayTextView.getText().toString() );
                Double sinx = Math.sin(displayValue);
                displayTextView.setText(sinx.toString());
            }
        });

        // Cos(x) function
        findViewById(R.id.cosButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double displayValue = Double.valueOf( displayTextView.getText().toString() );
                Double cosx = Math.cos(displayValue);
                displayTextView.setText(cosx.toString());
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

    // OnClickListener
    @Override
    public void onClick(View v) {
        Button digitButton = (Button) v;
        Log.i(TAG, "digit pressed : " + digitButton.getText());

        displayTextView.setText( displayTextView.getText() + digitButton.getText().toString() );



    }
}
