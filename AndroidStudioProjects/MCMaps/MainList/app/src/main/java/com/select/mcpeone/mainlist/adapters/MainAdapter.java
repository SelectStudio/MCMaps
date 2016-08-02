package com.select.mcpeone.mainlist.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.select.mcpeone.mainlist.MyApplication;
import com.select.mcpeone.mainlist.R;
import com.select.mcpeone.mainlist.classes.ListType;
import com.select.mcpeone.mainlist.classes.LoadImage;
import com.select.mcpeone.mainlist.classes.MainBean;;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.AddView>{
    private List<MainBean> list;
    private int type;
    public MainAdapter(List<MainBean> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public AddView onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        switch (viewType) {
            case ListType.LIST_PIC :
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_image, viewGroup, false);
                break;
            case ListType.LIST_INFO :
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_info, viewGroup, false);
                break;
            case ListType.LIST_NORMAL :
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_normal, viewGroup, false);
                break;
            case ListType.LIST_PICBG :
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_picbg, viewGroup, false);
                break;
            case ListType.LIST_USER :
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_user, viewGroup, false);
                break;
           default:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_image, viewGroup, false);
                break;
        }
        return new AddView(view);
    }

    @Override
    public void onBindViewHolder(final AddView addView, final int position) {
        type=list.get(position).getType();
        switch (type){
            case ListType.LIST_PIC:
                LoadImage.loadImage(addView.pic,list.get(position).getPic(),true);
                break;
            case ListType.LIST_INFO:
                LoadImage.loadImage(addView.pic,list.get(position).getPic(),true);
                LoadImage.loadImage(addView.icon,list.get(position).getIcon(),true);
                addView.title.setText(list.get(position).getTitle());
                addView.subTitle.setText(list.get(position).getSubTitle());
                break;
            case ListType.LIST_NORMAL:
                addView.title.setText(list.get(position).getTitle());
                addView.subTitle.setText(list.get(position).getSubTitle());
                if(list.get(position).getIsHide()){
                 addView.subTitle.setVisibility(View.GONE);
                }
                initList(addView.list,position);
                break;
            case ListType.LIST_PICBG:
                addView.title.setText(list.get(position).getTitle());
                addView.subTitle.setText(list.get(position).getSubTitle());
                if(list.get(position).getIsHide()){
                    addView.subTitle.setVisibility(View.GONE);
                }
                initList(addView.list,position);
                LoadImage.loadImage(addView.picBg,list.get(position).getPicBg(),true);
                break;
            case ListType.LIST_USER:
                LoadImage.loadImage(addView.picBg,list.get(position).getPic(),true);
                LoadImage.loadImage(addView.icon,list.get(position).getIcon(),true);
                addView.userName.setText(list.get(position).getUserName());
                initList(addView.list,position);
                break;
            default:
                LoadImage.loadImage(addView.pic,list.get(position).getPic(),true);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private void initList(RecyclerView listview,int position){
        listview.setHasFixedSize(true);
        ListAdapter listAdapter=new ListAdapter(list.get(position).getList());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MyApplication.getCtx());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        listview.setLayoutManager(linearLayoutManager);
        listview.setAdapter(listAdapter);
    }
    public static class AddView extends RecyclerView.ViewHolder{
        private ImageView icon;
        private TextView title;
        private TextView subTitle;
        private ImageView pic;
        private ImageView picBg;
        private TextView userName;
        private RecyclerView list;
        private TextView markLevel;
        public AddView(View itemView){
            super(itemView);
            icon= (ImageView) itemView.findViewById(R.id.icon );
            title= (TextView) itemView.findViewById(R.id.title);
            subTitle= (TextView) itemView.findViewById(R.id.subtitle);
            pic= (ImageView) itemView.findViewById(R.id.pic );
            picBg= (ImageView) itemView.findViewById(R.id.pic_bg);
            userName= (TextView) itemView.findViewById(R.id.user_name);
            list= (RecyclerView) itemView.findViewById(R.id.list);
            markLevel= (TextView) itemView.findViewById(R.id.mark_level);
        }




    }}
