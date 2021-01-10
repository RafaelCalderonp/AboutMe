package com.example.aboutme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aboutme.databinding.FragmentMessageBinding;


public class MessageFragment extends Fragment {

    private FragmentMessageBinding mBinding;


    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentMessageBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.btContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.btContact.setVisibility(View.GONE);
                mBinding.msgHolder.setVisibility(View.VISIBLE);
                mBinding.btSend.setVisibility(View.VISIBLE);

            }
        });
        mBinding.btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mBinding.etMsg.getText().toString();
                if (message.length() !=0){
                    sendMessage(message);

                } else {
                    Toast.makeText(getContext(), "Debes escribir un mensaje",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void sendMessage(String message){
        String[] emails = {"rafael.calderonp@gmail.com"};
        Intent mIntent = new Intent((Intent.ACTION_SENDTO));
        mIntent.setData(Uri.parse("mailto:"));
        mIntent.putExtra(Intent.EXTRA_EMAIL, emails );
        mIntent.putExtra(Intent.EXTRA_SUBJECT, "Contacto AboutMe");
        mIntent.putExtra(Intent.EXTRA_TEXT, message);
        if (mIntent.resolveActivity(getActivity().getPackageManager()) !=null) {
            startActivity(mIntent);
        } else {
            Toast.makeText(getContext(), "Debes instalar una app de correo",
                    Toast.LENGTH_SHORT).show();
        }

    }
}