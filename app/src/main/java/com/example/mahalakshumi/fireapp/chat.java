package com.example.mahalakshumi.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class chat extends AppCompatActivity {

    EditText userInput;
    RecyclerView recyclerView;
    List<com.example.mahalakshumi.fireapp.ResponseMessage> responseMessagesList;
    com.example.mahalakshumi.fireapp.MessageAdapter messageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat2);
        userInput= (EditText)findViewById(R.id.userInput);
        recyclerView =(RecyclerView)findViewById(R.id.conversation);
        responseMessagesList=new ArrayList<>();
        messageAdapter=new com.example.mahalakshumi.fireapp.MessageAdapter(responseMessagesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(messageAdapter);
        userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEND){
                    com.example.mahalakshumi.fireapp.ResponseMessage message= new com.example.mahalakshumi.fireapp.ResponseMessage(userInput.getText().toString(),true);
                    responseMessagesList.add(message);
                    com.example.mahalakshumi.fireapp.ResponseMessage message2= new com.example.mahalakshumi.fireapp.ResponseMessage(userInput.getText().toString(),false);
                    responseMessagesList.add(message2);
                    messageAdapter.notifyDataSetChanged();
                    if(!isVisible()){
                        recyclerView.smoothScrollToPosition(messageAdapter.getItemCount()-1);
                    }

                }
                return true;
            }
        });

    }

    public boolean isVisible(){
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
        int positionOfLastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        int itemCount = recyclerView.getAdapter().getItemCount();
        return (positionOfLastVisibleItem>=itemCount);
    }
}
