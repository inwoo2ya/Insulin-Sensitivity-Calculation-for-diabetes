package com.example.inwooproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tan,Gi,mass,foodname;
    String tans,GI,mas;
    String fn;
    Float GI2,GL;
    TextView resultText,results,result1;
    View dialogView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("혈당 지수/부하 계산");


        resultText = (TextView) findViewById(R.id.resultText);
        results = (TextView) findViewById(R.id.result);
        result1 = (TextView) findViewById(R.id.result1);
        foodname = (EditText) findViewById(R.id.foodname);
        Gi = (EditText) findViewById(R.id.Gi);
        mass = (EditText) findViewById(R.id.mess);
        tan = (EditText) findViewById(R.id.tan);

        final Button button1 = (Button) findViewById(R.id.Insullin);
        final Button button3 = (Button) findViewById(R.id.Confirm);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                dialogView = (View) View.inflate(MainActivity.this,R.layout.setting,null);
                AlertDialog.Builder dlg1 = new AlertDialog.Builder(MainActivity.this);
                dlg1.setTitle("환자의 인슐린민감성");
                dlg1.setView(dialogView);
                dlg1.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(),InsullinActivity.class);
                    startActivity(intent);
                    }
                });

                dlg1.setNegativeButton("취소",null);
                dlg1.show();

            }
        });


        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                fn = foodname.getText().toString();
                GI = Gi.getText().toString();
                mas = mass.getText().toString();
                tans = tan.getText().toString();


                resultText.setText("\n" + fn + "의 결과 : \n\n");
                if(mas.equals("") || tans.equals("")||GI.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"값을 넣어주세요.",Toast.LENGTH_SHORT).show();
                } else {
                    GI2 = (Float.parseFloat(GI) / 100) * (Float.parseFloat(mas));
                    result1.setText("\n\nGI(혈당지수) : " + GI2.toString() + "\n");
                    GL = (GI2 * Integer.parseInt(tans)) / 100;
                    results.setText("\n\nGL(혈당부하) : " + GL.toString() + "\n");
                }


                /*else if(fn == " "){
                    dialogView = (View) View.inflate(MainActivity.this,R.layout.error,null);
                    AlertDialog.Builder dlg3 = new AlertDialog.Builder(MainActivity.this);
                    dlg3.setTitle("오류");
                    dlg3.setView(dialogView);
                    dlg3.setPositiveButton("확인",null);
                    dlg3.show();
                }*/
            }
        });


    }
}