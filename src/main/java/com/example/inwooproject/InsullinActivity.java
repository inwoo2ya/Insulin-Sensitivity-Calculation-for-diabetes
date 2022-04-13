package com.example.inwooproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InsullinActivity extends AppCompatActivity {
    RadioGroup insul;
    RadioButton rapid,regular;
    TextView rare,resultext,resul;
    EditText num;
    String Num;
    LinearLayout ins;
    Integer resultrap,resultreg;
    Button back,btnOk,btnOk2,reset;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.insullin);
            setTitle("인슐린민감성 계산");

            num = (EditText) findViewById(R.id.num1);
            rare = (TextView) findViewById(R.id.rare);
            resul = (TextView) findViewById(R.id.resul);
            resultext = (TextView) findViewById(R.id.resultext);
            insul = (RadioGroup) findViewById(R.id.insul);
            rapid = (RadioButton) findViewById(R.id.Rapid);
            regular = (RadioButton) findViewById(R.id.Regular);
            btnOk = (Button) findViewById(R.id.OK);
            btnOk2 =(Button) findViewById(R.id.OK2);
            back = (Button) findViewById(R.id.Back);
            reset = (Button) findViewById(R.id.reset);
            ins = (LinearLayout) findViewById(R.id.ins);
            back.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            });
            reset.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent intent = new Intent(getApplicationContext(),InsullinActivity.class);
                    startActivity(intent);

                }
            });

            btnOk.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    resultrap = 0;
                    resultreg = 0;

                    switch(insul.getCheckedRadioButtonId()){

                        case R.id.Rapid:
                            btnOk.setVisibility(View.INVISIBLE);
                            ins.setVisibility(View.VISIBLE);
                            rare.setText("하루에 맞는 총 인슐린양(초속효성+지속형): ");


                                btnOk2.setVisibility(View.VISIBLE);

                                    btnOk2.setOnClickListener(new View.OnClickListener() {

                                    public void onClick(View v) {
                                        Num = num.getText().toString();
                                        reset.setVisibility(View.VISIBLE);
                                        if(Num.equals("")) {
                                            Toast.makeText(getApplicationContext(),"값을 넣어주세요!",Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            resultrap = (1800 / Integer.parseInt(Num));
                                            resul.setText("초속효성 인슐린 1단위당 ");
                                            resultext.setText("\n" + resultrap.toString() + " mg/dL 이 떨어집니다." + "\n\n 유의하세요!");
                                        }
                                        }

                                });
                                    break;

                        case R.id.Regular:

                            btnOk.setVisibility(View.INVISIBLE);
                            ins.setVisibility(View.VISIBLE);
                            rare.setText("하루에 맞는 총 인슐린양(속효성+지속형) : ");

                            btnOk2.setVisibility(View.VISIBLE);
                            btnOk2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Num = num.getText().toString();
                                    reset.setVisibility(View.VISIBLE);
                                    if(Num.equals("")) {
                                        Toast.makeText(getApplicationContext(),"값을 넣어주세요.",Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        resultreg = 1500 / Integer.parseInt(Num);
                                        resul.setText("속효성 인슐린 1단위당 ");
                                        resultext.setText("\n" +resultreg.toString()+" mg/dL 이 떨어집니다."+"\n\n 유의하세요!");
                                    }

                                }
                            });
                            break;
                        default :
                            Toast.makeText(getApplicationContext(),"초속효성 속효성 둘중에 하나를 선택해주세요.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
}
