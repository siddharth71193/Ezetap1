package com.example.ezelibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class MathOperation implements MathOps {
    private Context mContext;
    private int mResult;
    public static final String ACTION = "com.developer.siddharth.ezetap";
    public static final String NUMBER_ONE = "param_one";
    public static final String NUMBER_TWO = "param_two";
    public static final String OPERATION = "OPERATION";
    public static final String ADD = "Add";
    public static final String SUB = "sub";
    public static final int RES_CODE = 100;

    public MathOperation(Context context) {
        mContext = context;

    }

    @Override
    public void addTwoNumbers(int op_one, int op_two) {
        Intent intent = new Intent();
        intent.setAction(ACTION);
        intent.putExtra(NUMBER_ONE, op_one);
        intent.putExtra(NUMBER_TWO, op_two);
        intent.putExtra(OPERATION, ADD);
        intent.setType("text/plain");
        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
            //ActivityHelper activityHelper = new ActivityHelper(this);
            intent.setFlags(0);
            ((Activity)mContext).startActivityForResult(intent,RES_CODE);
        }
    }

    @Override
    public void subtractTwoNumbers(int op_one, int op_two) {
        Intent intent = new Intent();
        intent.setAction(ACTION);
        intent.putExtra(NUMBER_ONE, op_one);
        intent.putExtra(NUMBER_TWO, op_two);
        intent.putExtra(OPERATION, SUB);
        intent.setType("text/plain");
        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
           // ActivityHelper activityHelper = new ActivityHelper(this);
            intent.setFlags(0);
            ((Activity)mContext).startActivityForResult(intent,RES_CODE);
        }
    }

    public interface OperationInterface{
        void onResultReady(int result);
        void onResultError(String message);
    }

}
