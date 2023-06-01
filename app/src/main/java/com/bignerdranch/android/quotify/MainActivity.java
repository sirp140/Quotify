package com.bignerdranch.android.quotify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private Button mYesButton;
    private Button mNoButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuoteTextView;
    private int mCurrentIndex = 0;
    private Button mDetailsButton;

    private Quote[] mQuoteBank = new Quote[]{
            new Quote(R.string.believe_you_can, R.string.quote_believe_description),
            new Quote(R.string.harder_I_work, R.string.quote_harder_work_description),
            new Quote(R.string.predict_the_future, R.string.quote_predict_future_description),
            new Quote(R.string.keep_going, R.string.quote_keep_going_description),
            new Quote(R.string.future_belongs_to, R.string.quote_future_belongs_description),
    };

    //onCreate(Bundle) method is called when an instance of the activity subclass is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting references to widgets
        mYesButton = (Button) findViewById(R.id.yes_button);
        mNoButton = (Button) findViewById(R.id.no_button);
        mNextButton = findViewById(R.id.next_button);
        mQuoteTextView = (TextView) findViewById(R.id.quote_text_view);
        mPrevButton = findViewById(R.id.prev_button);
        mDetailsButton = (Button)findViewById(R.id.details_button);

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

        mDetailsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //get the current quote
                Quote currentQuote = mQuoteBank[mCurrentIndex];

                //get the quote details resource id
                int quoteDetailsResId = currentQuote.getQuoteDetails();

                //start DetailsActivity with the quote details resource ID
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("QUOTE_DETAILS_RES_ID", quoteDetailsResId);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {

        super.onResume();

        //check if coming back from DetailsActivity
        boolean comingFromDetailsActivity = getIntent().getBooleanExtra("comingFromDetailsActivity", false);
        if(comingFromDetailsActivity) {
            Toast.makeText(this, R.string.returning_from_DetailsActivity_toast, Toast.LENGTH_SHORT).show();
        }
    }


    private void updateQuote() {
        int quote = mQuoteBank[mCurrentIndex].getTextResId();
        mQuoteTextView.setText(quote);

    }
}

