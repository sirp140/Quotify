package com.bignerdranch.android.quotify;

public class Quote {
    private int mTextResId;
    private int mquoteDetailsResId;
    private String quoteText;


    public Quote (int textResId, int quoteDetailsResId){
        mTextResId = textResId;
        mquoteDetailsResId = quoteDetailsResId;
    }

    public int getTextResId() {
        return mTextResId;
    }


    public int getQuoteDetails(){
        return mquoteDetailsResId;
    }



    public void setTextResId(int textResId){
        mTextResId = textResId;
    }


    public void setQuoteDetails(int quoteDetailsResId){
        mquoteDetailsResId = quoteDetailsResId;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }




    /* public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue){
        mAnswerTrue = answerTrue;
    }

     */
}
