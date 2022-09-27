package com.example.vize_gmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ikinci_ekran extends AppCompatActivity {

    private Toolbar ust_cubuk_;
    private Button send_button;
    private Button m_geri_butonu;
    private EditText m_gonderen_txt;
    private EditText m_alici_txt;
    private EditText m_konu_txt;
    private EditText m_ileti_txt;

    public void init(){
        m_geri_butonu = (Button) findViewById(R.id.geri_butonu);
        send_button = (Button) findViewById(R.id.button_send) ;
        ust_cubuk_ = (Toolbar) findViewById(R.id.ust_cubuk_);
        m_gonderen_txt = (EditText) findViewById(R.id.gonderen_txt);
        m_alici_txt = (EditText) findViewById(R.id.alici_txt);
        m_konu_txt = (EditText) findViewById(R.id.konu_txt);
        m_ileti_txt = (EditText) findViewById(R.id.ileti_txt);

        setSupportActionBar(ust_cubuk_);
        getSupportActionBar().setTitle("");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci_ekran);


        init();
        m_geri_butonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ikinci_ekran.this.finish();
            }
        });

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m_gonderen_txt.getText().toString().equals("")
                || m_alici_txt.getText().toString().equals("") || m_ileti_txt.getText().toString().equals("")
                ||m_konu_txt.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Eksik veri girmeyin.",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent_ = new Intent(ikinci_ekran.this,MainActivity.class);
                    intent_.putExtra("str1",m_gonderen_txt.getText().toString());
                    intent_.putExtra("str2",m_alici_txt.getText().toString());
                    intent_.putExtra("str3",m_konu_txt.getText().toString());
                    intent_.putExtra("str4",m_ileti_txt.getText().toString());
                    setResult(RESULT_OK,intent_);
                    ikinci_ekran.this.finish();
                }
            }
        });
    }
}