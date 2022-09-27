package com.example.vize_gmail;

public class ornek_item {
    private int m_profil;
    private String m_gonderen;
    private String m_konu;
    private String m_mail;


    public ornek_item(int m_profil, String m_gonderen, String m_konu, String m_mail) {
        this.m_profil = m_profil;
        this.m_gonderen = m_gonderen;
        this.m_konu = m_konu;
        this.m_mail = m_mail;
    }

    public int getM_profil() {
        return m_profil;
    }

    public String getM_gonderen() {
        return m_gonderen;
    }

    public String getM_konu() {
        return m_konu;
    }

    public String getM_mail() {
        return m_mail;
    }
}
