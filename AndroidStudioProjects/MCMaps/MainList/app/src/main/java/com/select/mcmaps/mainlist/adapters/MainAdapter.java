package com.select.mcmaps.mainlist.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.select.mcmaps.mainlist.classes.ListBean;
import com.select.mcmaps.mainlist.classes.LoadPic;
import com.select.mcmaps.mainlist.classes.MainBean;
import com.select.mcmaps.mainlist.R;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.AddView> {
    private List<MainBean> list;
    private int type;
    public MainAdapter(List<MainBean> list,int type) {
        this.list = list;
        this.type=type;
    }

    @Override
    public AddView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        switch (type) {
            case 0:
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_image, viewGroup, false);
                break;
            case 1:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_image, viewGroup, false);
                break;
            case 2:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_image, viewGroup, false);
                break;
            case 3:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_image, viewGroup, false);
                break;
            case 4:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_image, viewGroup, false);
                break;
            default:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_image, viewGroup, false);
                break;
        }
        return new AddView(view);
    }

    @Override
    public void onBindViewHolder(final AddView addView, final int position) {
        switch (type) {
            case 0:
                addView.pic.setImageDrawable(new LoadPic(list.get(position).getPic()).getImageDrawable());
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                addView.pic.setImageDrawable(new LoadPic(list.get(position).getPic()).getImageDrawable());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AddView extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView title;
        private TextView subTitle;
        private ImageView pic;
        private ImageView picBg;
        private TextView userName;
        private RecyclerView list;
        private TextView markLevel;
        public AddView(View itemView) {
            super(itemView);
            switch (type) {
                case 0:
                    pic= (ImageView) itemView.findViewById(R.id.pic );
                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    pic= (ImageView) itemView.findViewById(R.id.pic );
                    break;
            }
        }

    }
}