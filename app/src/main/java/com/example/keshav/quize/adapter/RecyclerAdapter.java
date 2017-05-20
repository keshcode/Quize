package com.example.keshav.quize.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.keshav.quize.R;
import com.example.keshav.quize.model.Questions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by keshav on 20/5/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<Questions> mQuestion;
    private Context mContext;
    private HashMap<String, String> map;

    public RecyclerAdapter(final ArrayList<Questions> mQuestion, final Context mContext) {
        this.mQuestion = mQuestion;
        this.mContext = mContext;
        map = new HashMap<String, String>();
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Questions mQues = mQuestion.get(position);
        holder.tvQuestion.setText(mQues.getmQues());
        holder.rbOptA.setText(mQues.getmOptions().get(0));
        holder.rbOptB.setText(mQues.getmOptions().get(1));
        holder.rbOptC.setText(mQues.getmOptions().get(2));
        holder.rbOptD.setText(mQues.getmOptions().get(3));

        holder.rgOption.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup group, @IdRes final int checkedId) {
                String mAns = " ";
                switch (checkedId) {
                    case R.id.rbOptA:
                        mAns = "A";
                        break;
                    case R.id.rbOptB:
                        mAns = "B";
                        break;
                    case R.id.rbOptC:
                        mAns = "C";
                        break;
                    case R.id.rbOptD:
                        mAns = "D";
                        break;
                    default:
                        break;
                }
                if (mAns.equals(mQues.getmAns())) {
                    map.put(String.valueOf(position), "1");
                } else {
                    map.put(String.valueOf(position), "0");
                }
            }
        });
    }

    public HashMap<String, String> getResultMap() {
        return map;
    }

    @Override
    public int getItemCount() {
        return mQuestion.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvQuestion;
        private RadioGroup rgOption;
        private RadioButton rbOptA, rbOptB, rbOptC, rbOptD;

        public ViewHolder(final View itemView) {
            super(itemView);
            tvQuestion = (TextView) itemView.findViewById(R.id.tvQuestion);
            rgOption = (RadioGroup) itemView.findViewById(R.id.rgOptions);
            rbOptA = (RadioButton) itemView.findViewById(R.id.rbOptA);
            rbOptB = (RadioButton) itemView.findViewById(R.id.rbOptB);
            rbOptC = (RadioButton) itemView.findViewById(R.id.rbOptC);
            rbOptD = (RadioButton) itemView.findViewById(R.id.rbOptD);
        }
    }
}
