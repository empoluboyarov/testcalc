package com.empoluboyarov.testcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final public int MENU_RESET_ID = 1;
    final public int MENU_QUIT_ID = 2;

    EditText enum1, enum2;
    Button btnAdd, btnMin, btnMult, btnSub;
    TextView result;

    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enum1 = (EditText) findViewById(R.id.enum1);
        enum2 = (EditText) findViewById(R.id.enum2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMin = (Button) findViewById(R.id.btnMin);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnSub = (Button) findViewById(R.id.btnSub);
        result = (TextView) findViewById(R.id.result);

        btnAdd.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnMin.setOnClickListener(this);
        btnSub.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_RESET_ID:
                enum1.setText("");
                enum2.setText("");
                result.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float res = 0;

        if(TextUtils.isEmpty(enum1.getText().toString())|| TextUtils.isEmpty(enum2.getText().toString()))
            return;

        num1 = Float.parseFloat(enum1.getText().toString());
        num2 = Float.parseFloat(enum2.getText().toString());

        switch (v.getId()){
            case R.id.btnAdd:
                res = num1 + num2;
                oper = " + ";
                break;
            case R.id.btnMin:
                oper = " - ";
                res = num1 - num2;
                break;
            case R.id.btnMult:
                oper = " * ";
                res = num1 * num2;
                break;
            case R.id.btnSub:
                res = num1 / num2;
                oper = " / ";
                break;
        }
        result.setText(num1 + oper + num2 + " = " + res);
    }
}
