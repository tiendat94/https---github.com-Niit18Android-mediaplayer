package com.dh.mediaplayer;

/**
 * Created by DH on 5/12/2015.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dh.mediaplayer.bean.SongBean;
import com.dh.mediaplayer.bean.UtilsSong;
import com.dh.mediaplayer.custom_listview_online.CustomListViewSongLocal;
import com.dh.mediaplayer.handler.HandlerOnItemClickSongLocal;

import java.util.ArrayList;

public class SongsOfLocalFragment extends Fragment {

    ArrayList<SongBean> listData;
    CustomListViewSongLocal adapter;
    ListView lvArtistsOnline;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.song_child_of_localfragment, container, false);
        lvArtistsOnline = (ListView)V.findViewById(R.id.lvArtists);

        UtilsSong utilsSong = new UtilsSong();
        listData = utilsSong.getAllAudio(".mp3",getActivity());
        adapter = new CustomListViewSongLocal(getActivity(),listData);
        lvArtistsOnline.setAdapter(adapter);
        lvArtistsOnline.setOnItemClickListener(new HandlerOnItemClickSongLocal(getActivity(), listData));

        return V;
    }
}
