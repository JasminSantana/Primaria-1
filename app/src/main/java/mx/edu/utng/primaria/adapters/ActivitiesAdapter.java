package mx.edu.utng.primaria.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mx.edu.utng.primaria.R;
import mx.edu.utng.primaria.model.Activities;

/**
 * Created by Husky Siberiano on 07/02/2017.
 */

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder>
        implements View.OnClickListener {

    List<Activities>activitiesList;
    private View.OnClickListener listener;

    public ActivitiesAdapter(List<Activities>activitiesList){
        this.activitiesList=activitiesList;
    }

    @Override
    public ActivitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ActivitiesViewHolder holder = new ActivitiesViewHolder(v);
        v.setOnClickListener(this);//
        return holder;
    }

    @Override
    public void onBindViewHolder(ActivitiesViewHolder holder, int position) {
        holder.ivPhoto.setBackgroundResource(activitiesList.get(position).getImageId());
        holder.tvName.setText(activitiesList.get(position).getNombre());
        holder.tvDescription.setText(activitiesList.get(position).getDescripcion());

    }


    @Override
    public int getItemCount() {
        return activitiesList.size();
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

    public static class ActivitiesViewHolder extends RecyclerView.ViewHolder{
        CardView cvActivity;
        ImageView ivPhoto;
        TextView tvName;
        TextView tvDescription;
        public ActivitiesViewHolder(View itemView){
            super(itemView);
            cvActivity=(CardView)itemView.findViewById(R.id.cv_data);
            ivPhoto=(ImageView)itemView.findViewById(R.id.iv_photo);
            tvName=(TextView)itemView.findViewById(R.id.tv_name);
            tvDescription=(TextView)itemView.findViewById(R.id.tv_description);
        }

    }
}
