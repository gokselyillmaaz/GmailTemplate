package com.example.vize_gmail;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_mail_olustur;
    private RecyclerView mRecyclerView;
    private ornekAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<ornek_item> m_ornek_liste = new ArrayList<ornek_item>();

    public void init(){
        btn_mail_olustur= (Button) findViewById(R.id.mail_olustur_butonu);
    }

    public static final int ikinci_ekran_request_code = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createExampleList();
        buildRecyclerView();
        init();
        EditText editText = findViewById(R.id.arama_cubugu);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        btn_mail_olustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_mailekrani = new Intent(MainActivity.this,ikinci_ekran.class);
                startActivityForResult(intent_mailekrani,ikinci_ekran_request_code);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
         super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ikinci_ekran_request_code){
            if(resultCode == RESULT_OK){
                if(data != null){
                     m_ornek_liste.add(0,new ornek_item(R.drawable.profil_foto,
                             data.getStringExtra("str1"),
                             data.getStringExtra("str3"),
                             data.getStringExtra("str4")));
                     mAdapter.setList(m_ornek_liste);
                     mAdapter.notifyDataSetChanged();
                }
            }
        }
        if(resultCode == RESULT_CANCELED){
            Toast toast =Toast.makeText(getApplicationContext(),"Mail Gönderimi Olmadı",Toast. LENGTH_SHORT);
            toast.show();
        }
    }

    private void filter(String text) {
        ArrayList<ornek_item> filtrelenmis_liste = new ArrayList<>();

        for (ornek_item item : m_ornek_liste) {
            if (item.getM_konu().toLowerCase().contains(text.toLowerCase())
                ||item.getM_gonderen().toLowerCase().contains(text.toLowerCase())
                ||item.getM_mail().toLowerCase().contains(text.toLowerCase())) {
                filtrelenmis_liste.add(item);
            }
        }
        mAdapter.filterList(filtrelenmis_liste);
    }


    public void createExampleList(){
        m_ornek_liste.add(new ornek_item(R.drawable.profil_foto,"Goksel Yilmaz", "vizeler" ,"vizelerin suresi gecti"));
        m_ornek_liste.add(new ornek_item(R.drawable.profil_foto,"Netflix", "Odeme Plani" ,"Son odeme tarihiniz gecti. Izlemeye devam etmek icin odeme yapin."));
        m_ornek_liste.add(new ornek_item(R.drawable.profil_foto,"Youtube", "Firsati yakala" ,"Youtube premium simdi 10 tl"));
        m_ornek_liste.add(new ornek_item(R.drawable.profil_foto,"Tatil.com", "Yaz tatili" ,"Bu yaz tatile doyacaksiniz."));
    }
    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ornekAdapter(m_ornek_liste);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}