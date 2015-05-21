package com.dh.mediaplayer;

/**
 * Created by DH on 5/12/2015.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.dh.mediaplayer.handler.HandlerOnTouchHideSearch;

public class VideosOfOnlineFragment extends Fragment {
    ListView lvVideoOnline;
    private LinearLayout linearVideoSearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.video_child_of_online_fragment, container, false);
        lvVideoOnline = (ListView)V.findViewById(R.id.lvVideoOnline);
        linearVideoSearch = (LinearLayout)V.findViewById(R.id.searchVideoOnline);
        lvVideoOnline.setOnTouchListener(new HandlerOnTouchHideSearch(getActivity(), lvVideoOnline, linearVideoSearch));
        return V;
    }
}
