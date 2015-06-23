package com.xiobit.calculator;

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
    OperatorEnum operationSelected;
    Double lastValue;
    Boolean startInputDigit = false;

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
        // Decimal
        findViewById(R.id.pointButton).setOnClickListener(this);

        // Clear Behavior
        findViewById(R.id.clearButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTextView.setText("0");
                startInputDigit = false;
            }
        });

        // Basic Operations: /, x, -, +
        findViewById(R.id.divideButton).setOnClickListener(operationListener);
        findViewById(R.id.multiplyButton).setOnClickListener(operationListener);
        findViewById(R.id.minusButton).setOnClickListener(operationListener);
        findViewById(R.id.addButton).setOnClickListener(operationListener);

        // Equal Result
        findViewById(R.id.equalButton).setOnClickListener(equalListener);

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


    //Global On Click listener for all operations
    final View.OnClickListener operationListener = new View.OnClickListener() {
        public void onClick(final View v) {

            lastValue = Double.valueOf(displayTextView.getText().toString());

            switch(v.getId()) {
                case R.id.divideButton:
                    operationSelected = OperatorEnum.DIVIDE;
                    break;
                case R.id.multiplyButton:
                    operationSelected = OperatorEnum.MULTIPLY;
                    break;
                case R.id.addButton:
                    operationSelected = OperatorEnum.ADD;
                    break;
                case R.id.minusButton:
                    operationSelected = OperatorEnum.MINUS;
                    break;

            }

            startInputDigit = false;
        }
    };

    //Global On Click Listener for equal result
    final View.OnClickListener equalListener = new View.OnClickListener() {
        public void onClick(final View v) {
            Double currentValue = Double.valueOf(displayTextView.getText().toString());
            Double result = null;

            switch(operationSelected) {
                case DIVIDE:
                    result = lastValue / currentValue;
                    break;
                case MULTIPLY:
                    result = lastValue * currentValue;
                    break;
                case ADD:
                    result = lastValue + currentValue;
                    break;
                case MINUS:
                    result = lastValue - currentValue;
                    break;
            }

            displayTextView.setText( Double.toString(result) );
        }
    };



    // OnClickListener for all Digits
    @Override
    public void onClick(View v) {
        Button digitButton = (Button) v;
        // Log.i(TAG, "digit pressed : " + digitButton.getText());

        if ( startInputDigit ) {
            displayTextView.setText( displayTextView.getText() + digitButton.getText().toString() );
        } else {
            displayTextView.setText( digitButton.getText().toString() );
            startInputDigit = true;
        }

    }


}
