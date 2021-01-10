package com.example.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.aboutme.databinding.ActivityContacBinding;

public class ContacActivity extends AppCompatActivity {
    private ActivityContacBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityContacBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.ibWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareWinthWatsapp();

            }
        });
        mBinding.ibPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhone();
            }
        });
        mBinding.ibLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkedin();
            }
        });

    }
    private void shareWinthWatsapp(){
        String url = "https://wa.link/ie6jfy"; //Cambiar a mi enlace
        Intent mIntent = new Intent(Intent.ACTION_VIEW);
        mIntent.setData(Uri.parse(url));
        if (mIntent.resolveActivity(getPackageManager()) !=null) {
            startActivity(mIntent);
        } else {
            Toast.makeText(this, "Debes instalar WhatsApp",
                    Toast.LENGTH_SHORT).show();
        }
    }
    private void callPhone(){
        Uri number = Uri.parse("tel: +56995550447");
        Intent mIntent = new Intent(Intent.ACTION_DIAL, number);
        if (mIntent.resolveActivity(getPackageManager()) != null){
            startActivity(mIntent);
        }else {
            Toast.makeText(this, "Equipo no apto para realizar llamadas",
                    Toast.LENGTH_SHORT).show();
        }

    }
    private void openLinkedin(){
        String url = "https://www.linkedin.com/in/carol-llanca/"; //cambiar a mi linkedin
        Intent mIntent = new Intent(Intent.ACTION_VIEW);
        mIntent.setData(Uri.parse(url));
        if (mIntent.resolveActivity(getPackageManager()) !=null) {
            startActivity(mIntent);
        } else {
            Toast.makeText(this, "Debes instalar WhatsApp",
                    Toast.LENGTH_SHORT).show();
        }
    }
}