package comm.mobile.demo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comm.mobile.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DownLoadFragment extends Fragment {


    public DownLoadFragment() {
        // Required empty public constructor
    }

    public static DownLoadFragment newInstance() {
        Bundle args = new Bundle();
        DownLoadFragment fragment = new DownLoadFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_down_load, container, false);
    }

}
