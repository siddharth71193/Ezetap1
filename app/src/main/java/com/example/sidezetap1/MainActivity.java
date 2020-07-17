package com.example.sidezetap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ezelibrary.MathOperation;
import com.example.ezelibrary.MathOps;
import com.example.sidezetap1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    private MathOperation mMathOperation;
    private String inputOne;
    private String inputTwo;
    private String operation;
    private MathOps mMathOps;
    public static final int RES_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mMathOperation = new MathOperation(this);

        mBinding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = mBinding.etxInputOne.getText().toString();
                String input2 = mBinding.etxInputTwo.getText().toString();
                if (!input1.isEmpty() && !input2.isEmpty()) {
                    inputOne = input1;
                    inputTwo = input2;
                    operation = "Addition";
                    mMathOperation.addTwoNumbers(Integer.parseInt(input1), Integer.parseInt(input2));
                } else {
                    Toast.makeText(MainActivity.this, "Please provide input data!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mBinding.btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = mBinding.etxInputOne.getText().toString();
                String input2 = mBinding.etxInputTwo.getText().toString();
                if (!input1.isEmpty() && !input2.isEmpty()) {
                    inputOne = input1;
                    inputTwo = input2;
                    operation = "Subtraction";
                    mMathOperation.subtractTwoNumbers(Integer.parseInt(input1), Integer.parseInt(input2));
                } else {
                    Toast.makeText(MainActivity.this, "Please provide input data!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void onResultReady(int result) {
        mBinding.resultCard.setVisibility(View.VISIBLE);
        String inputTextOne = getString(R.string.input_text) + inputOne;
        mBinding.tvInputOne.setText(inputTextOne);
        String inputTextTwo = getString(R.string.input_text_two) + inputTwo;
        mBinding.tvInputTwo.setText(inputTextTwo);
        String operation_text = "Operation: " + operation;
        String result_text = "Result: " + result;
        mBinding.tvOperation.setText(operation_text);
        mBinding.tvResult.setText(result_text);
    }

    public void onResultError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == RES_CODE) {

            int result = data.getIntExtra("RESULT", 0);
            onResultReady(result);
        } else {
            Toast.makeText(this, "Sorry,Unable to get result!", Toast.LENGTH_SHORT).show();
        }
    }


}