package com.dh.mediaplayer.custom_listview_online;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dh.mediaplayer.R;
import com.dh.mediaplayer.bean.SingerBean;

import java.util.ArrayList;

/**
 * Created by DH on 5/14/2015.
 */
public class CustomListViewArtists extends BaseAdapter {
    private Activity context;
    private LayoutInflater inflater;
    private ArrayList<SingerBean> listItem;

    public CustomListViewArtists(Activity context, ArrayList<SingerBean> listItem) {
        this.context = context;
        this.listItem = listItem;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

   public static class ViewHolder{
        ImageView imgArtists;
        TextView tvArtistsName;
        TextView tvArtistsDescription;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.custom_listview_artists_online_layout, null);

            holder.imgArtists = (ImageView) convertView.findViewById(R.id.imgArtists);
            holder.tvArtistsName = (TextView) convertView.findViewById(R.id.tvArtistsName);
            holder.tvArtistsDescription = (TextView) convertView.findViewById(R.id.tvArtistsDescription);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        SingerBean singer = listItem.get(position);

//        holder.imgArtists.setImageResource(Integer.parseInt(singer.getThumbImage()));
        holder.tvArtistsName.setText(singer.getSingerName());
        holder.tvArtistsDescription.setText(singer.getDescription());


        return convertView;
    }

}
