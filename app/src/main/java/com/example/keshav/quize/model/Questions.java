package com.example.keshav.quize.model;

import java.util.ArrayList;

/**
 * Created by keshav on 20/5/17.
 */

public class Questions {
    private String mQues;
    private String mAns;
    private ArrayList<String> mOptions;

    public Questions(final String mQues, final String mAns, final ArrayList<String> mOptions) {
        this.mQues = mQues;
        this.mAns = mAns;
        this.mOptions = mOptions;
    }

    public String getmQues() {
        return mQues;
    }

    public void setmQues(final String mQues) {
        this.mQues = mQues;
    }

    public String getmAns() {
        return mAns;
    }

    public void setmAns(final String mAns) {
        this.mAns = mAns;
    }

    public ArrayList<String> getmOptions() {
        return mOptions;
    }

    public void setmOptions(final ArrayList<String> mOptions) {
        this.mOptions = mOptions;
    }
}
