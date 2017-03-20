package mx.edu.utng.primaria.adapters;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.model.ActivityWriting;

/**
 * Created by Husky Siberiano on 24/02/2017.
 */

public class WritingAdapter extends RecyclerView.Adapter<WritingAdapter.WritingViewHolder>
        implements View.OnClickListener{

    List<ActivityWriting> writings;
    private View.OnClickListener listener;

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public WritingAdapter(List<ActivityWriting>writingList){
        this.writings=writingList;
    }

    @Override
    public WritingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_writing,parent,false);
        WritingViewHolder holder = new WritingViewHolder(v);
        v.setOnClickListener(this);//
        return holder;
    }

    @Override
    public void onBindViewHolder(WritingViewHolder holder, int position) {
        holder.ivImage.setBackgroundResource(writings.get(position).getImageId());
        holder.tvTitle.setText(writings.get(position).getTitle());
        Log.i("Color", ""+writings.get(position).getColor());
        holder.etWritingColor.setText(writings.get(position).getColor());
        holder.etWritingColor.setTextColor(writings.get(position).getColor().equalsIgnoreCase(" _ H I _ E  ")?Color.BLACK:Color.WHITE);
        holder.etWritingComplete.setText(writings.get(position).getWritingColor());
        holder.setListener(this);
    }


    @Override
    public int getItemCount() {
        return writings.size();
    }

    public void setOnclicListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public static class WritingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        LinearLayout cvWriting;
        ImageView ivImage;
        TextView tvTitle;
        TextView etWritingColor;
        EditText etWritingComplete;
        Button btCompleted;
        View.OnClickListener listener;

        public WritingViewHolder(View itemView){
            super(itemView);
            cvWriting=(LinearLayout) itemView.findViewById(R.id.cv_writing);
            ivImage=(ImageView)itemView.findViewById(R.id.iv_writing);
            tvTitle=(TextView)itemView.findViewById(R.id.tv_title_writing);
            etWritingColor=(TextView) itemView.findViewById(R.id.et_writing_color);
            etWritingComplete=(EditText) itemView.findViewById(R.id.et_writing_complete);
            btCompleted=(Button)itemView.findViewById(R.id.bt_completed);
            btCompleted.setOnClickListener(this);
        }

        public void setListener(View.OnClickListener listener) {
            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            if(listener!=null){
                listener.onClick(v);
            }
        }
    }
}
