package com.select.mcpeone.mainlist.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.select.mcpeone.mainlist.R;
import com.select.mcpeone.mainlist.classes.LoadImage;
import com.select.mcpeone.mainlist.classes.ListBean;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.AddView>{
    private List<ListBean> list;
    public ListAdapter(List<ListBean> list) {
        this.list = list;
    }
    @Override
    public AddView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_normal, viewGroup, false);
        return new AddView(view);
    }

    @Override
    public void onBindViewHolder(final AddView addView, final int position) {
        addView.title.setText(list.get(position).getTitle());
        addView.subTitle.setText(list.get(position).getSubTitle());
        LoadImage.loadImage(addView.icon,list.get(position).getMarkLevel(),true);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class AddView extends RecyclerView.ViewHolder{
        private ImageView icon;
        private TextView title;
        private TextView subTitle;
        public AddView(View itemView){
            super(itemView);
            icon= (ImageView) itemView.findViewById(R.id.icon );
            title= (TextView) itemView.findViewById(R.id.title);
            subTitle= (TextView) itemView.findViewById(R.id.mark_level);
        }
    }}
