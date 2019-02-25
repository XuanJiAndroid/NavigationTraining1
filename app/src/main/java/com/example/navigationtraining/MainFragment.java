package com.example.navigationtraining;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;


public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(),"进入了MainFragment",Toast.LENGTH_SHORT).show();
        View rootView =inflater.inflate(R.layout.fragment_main,container,false);
        rootView.findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实践过程 5 开始
//                NavController navController = NavHostFragment.findNavController(MainFragment.this);
//                navController.navigate(R.id.twoFragment);
                //实践过程 5 结束
            }
        });
        return rootView;
    }
}
