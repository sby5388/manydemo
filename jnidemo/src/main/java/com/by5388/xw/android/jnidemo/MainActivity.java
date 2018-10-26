package com.by5388.xw.android.jnidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.by5388.xw.android.jnidemo.tools.NetTools;
import com.by5388.xw.android.jnidemo.tools.TestCode;
import com.by5388.xw.android.jnidemo.tools.Tools;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    TextView show;
    Tools tools;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tools = new Tools();
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(tools.getString());
        start();

        int number = 5;
        Tools.getMiALong(number);
        tools.setPersonName("by5388");
        NetTools netTools = new NetTools();
        String ip = netTools.getNetIP();
        System.out.println(ip);
        new TestCode().test();
    }

    private void start() {
        editText1 = findViewById(R.id.number1);
        editText2 = findViewById(R.id.number2);
        show = findViewById(R.id.result);
        findViewById(R.id.start_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
            }
        });
    }

    private void calc() {
        String strA = editText1.getText().toString().trim();
        String strB = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strB)) {
            Toast.makeText(this, "Null ", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);

            int result = Tools.getSum(a, b);
            show.setText(String.valueOf(result));
        } catch (Exception e) {
            //
            editText1.setError("null");
            editText2.setError("null");
        }
    }
}

