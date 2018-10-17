
package com.example.mahalakshumi.fireapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.CustomViewHolder> {

    class CustomViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textMessage);
        }
    }


    List<com.example.mahalakshumi.fireapp.ResponseMessage> responseMessageList;
    public MessageAdapter(List<com.example.mahalakshumi.fireapp.ResponseMessage> responseMessageList) {
        this.responseMessageList= responseMessageList;
    }

    @Override
    public int getItemViewType(int position) {
        if(responseMessageList.get(position).isIsme()){
            return R.layout.me_bubble;
        }
        return R.layout.bot_bubble;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.CustomViewHolder holder, int position) {
        holder.textView.setText(responseMessageList.get(position).getTextMessage());
    }

    @Override
    public int getItemCount() {

        return responseMessageList.size();
    }
}
