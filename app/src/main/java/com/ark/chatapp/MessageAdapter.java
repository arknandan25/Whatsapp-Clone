package com.ark.chatapp;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.FirebaseDatabase;

        import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    ArrayList<MesssageObject> messageList;

    public MessageAdapter(ArrayList<MesssageObject> messageList){
        this.messageList = messageList;

    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        MessageViewHolder rcv = new MessageViewHolder(layoutView);

        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, final int position) {
        holder.mMessage.setText(messageList.get(position).getMessage());
        holder.mSender.setText(messageList.get(position).getSenderId());
        //holder.mMessage.setText(messageList.get(position).getMessage());




    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }


     class  MessageViewHolder extends RecyclerView.ViewHolder{
        TextView mMessage , mSender;

        LinearLayout mLayout;
        MessageViewHolder(View view){
            super(view);

            mLayout= view.findViewById(R.id.layout);
            mSender= view.findViewById(R.id.sender);
            mMessage= view.findViewById(R.id.message);
        }
    }
}
