package com.example.keshav.quize;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.keshav.quize.adapter.RecyclerAdapter;
import com.example.keshav.quize.model.Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Questions> mQues;
    private RecyclerView rvQuestionsList;
    private TextView tvTotalMarks, tvCorrect, tvIncorrect, tvNotAttempted;
    private LinearLayout llResult;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addElements();
        final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(mQues, this);
        rvQuestionsList.setLayoutManager(new LinearLayoutManager(this));
        rvQuestionsList.setAdapter(recyclerAdapter);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                int mCorrect = 0, mIncorrect = 0;
                llResult.setVisibility(View.VISIBLE);
                HashMap<String, String> map = recyclerAdapter.getResultMap();
                tvNotAttempted.setText("Not Attempted :" + String.valueOf((mQues.size() - map.size())));
                for (Map.Entry<String, String> e : map.entrySet()) {
                    if ("1".equals(e.getValue())) {
                        mCorrect++;
                    } else {
                        mIncorrect++;
                    }
                }
                tvCorrect.setText("Correct :" + String.valueOf(mCorrect));
                tvIncorrect.setText("Incorrect :" + String.valueOf(mIncorrect));
                tvTotalMarks.setText("Marks obtained :" + String.valueOf(mCorrect));
            }
        });
    }

    private void init() {
        mQues = new ArrayList<Questions>();
        rvQuestionsList = (RecyclerView) findViewById(R.id.rvQuestionList);
        llResult = (LinearLayout) findViewById(R.id.llResult);
        tvTotalMarks = (TextView) findViewById(R.id.tvTotalMarks);
        tvCorrect = (TextView) findViewById(R.id.tvCorrect);
        tvIncorrect = (TextView) findViewById(R.id.tvIncorrect);
        tvNotAttempted = (TextView) findViewById(R.id.tvNotAttempted);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
    }

    public void addElements() {
        ArrayList<String> mOptions = new ArrayList<String>();
        mOptions.add("hello");
        mOptions.add("bye");
        mOptions.add("stay");
        mOptions.add("cool");

        mQues.add(new Questions("what is ur question ?", "A", mOptions));
    }


}
