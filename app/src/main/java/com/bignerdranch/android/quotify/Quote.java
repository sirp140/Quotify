package com.bignerdranch.android.quotify;

public class Quote {
    private int mTextResId;
    //private boolean mAnswerTrue;

    public Quote (int textResId){
        mTextResId = textResId;
        //mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId){
        mTextResId = textResId;
    }

    /* public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue){
        mAnswerTrue = answerTrue;
    }

     */
}
