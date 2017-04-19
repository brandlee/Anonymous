package com.brandlee.anonymous.sections.daily;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brandlee.anonymous.R;
import com.brandlee.anonymous.entities.DailyEntity;
import com.brandlee.anonymous.service.HttpMethods;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DailyFragment extends Fragment {
    private static final String TAG = "DailyFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DailyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DailyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DailyFragment newInstance(String param1, String param2) {
        DailyFragment fragment = new DailyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        getDaily(2017, 4, 19);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daily, container, false);

        return view;
    }

    private void getDaily(int year, int month, int day) {
        Observer observer = new Observer<DailyEntity>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(DailyEntity dailyEntity) {
                List<String> category = dailyEntity.getCategory();
                Log.i(TAG, "onNext: " + category);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        HttpMethods.getInstance().getDailyData(observer, year, month, day);
    }
}
