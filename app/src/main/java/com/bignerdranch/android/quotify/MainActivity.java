package com.bignerdranch.android.quotify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private Button mYesButton;
    private Button mNoButton;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView mQuoteTextView;
    private int mCurrentIndex = 0;

    private Quote[] mQuoteBank = new Quote[]{
            new Quote(R.string.believe_you_can),
            new Quote(R.string.harder_I_work),
    };

    //onCreate(Bundle) method is called when an instance of the activity subclass is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting references to widgets
        mYesButton = (Button) findViewById(R.id.yes_button);
        mNoButton = (Button) findViewById(R.id.no_button);
        mNextButton = (Button)findViewById(R.id.next_button);
        mQuoteTextView = (TextView) findViewById(R.id.quote_text_view);
        mPrevButton = (Button)findViewById(R.id.prev_button);

        //setting listeners for yes button
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.yay_toast, Toast.LENGTH_LONG).show();
            }
        });

        //setting listener for no button
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Button clicked");
                Toast.makeText(MainActivity.this, R.string.nah_toast, Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG).show();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuoteBank.length;
                updateQuote();
            }
        });

        updateQuote();

        mPrevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mCurrentIndex == 0){
                    mCurrentIndex = mQuoteBank.length - 1;
                }
                else{
                    mCurrentIndex = (mCurrentIndex -1) % mQuoteBank.length;
                }
                updateQuote();
            }
        });

    }
    private void updateQuote() {
        int quote = mQuoteBank[mCurrentIndex].getTextResId();
        mQuoteTextView.setText(quote);

    }
}

