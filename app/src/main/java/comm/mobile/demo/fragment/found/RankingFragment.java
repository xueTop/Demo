package comm.mobile.demo.fragment.found;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comm.mobile.demo.R;


public class RankingFragment extends Fragment {


    public RankingFragment() {
        // Required empty public constructor
    }

    public static AnchorFragment newInstance() {
        Bundle args = new Bundle();
        AnchorFragment fragment = new AnchorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_ranking, container, false);
        initView(rootView);

        return rootView;
    }

    private void initView(View rootView) {
        
    }

}
