package edu.wit.mobileapp.wellness_app.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import java.io.FileOutputStream;

import edu.wit.mobileapp.wellness_app.R;
import edu.wit.mobileapp.wellness_app.databinding.FragmentDashboardBinding;
import edu.wit.mobileapp.wellness_app.ui.notifications.NotificationsFragment;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;

    private String fileName = "Wellness_Counselor";
    private String counselorName ="";
    FileOutputStream outputStream;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textView;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        Button button = binding.contactBtn;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(getActivity(), edu.wit.mobileapp.wellness_app.ui.dashboard.ContactInfo.class);

                startActivity(intent);

            }
        });


        TextView counselor_1 = binding.counselorName1;
        counselor_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Fragment fragment_home = new NotificationsFragment();
                transaction.replace(R.id.container, fragment_home);
                transaction.commit();
                counselorName = counselor_1.getText().toString();

                FileOutputStream outputStream;
                try{
                    outputStream = getActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(counselorName.getBytes());
                    outputStream.close();
                }catch (Exception e){
                    Log.v("Write counselor name","Error: " + e);
                }
            }
        });

        TextView counselor_2 = binding.counselorName2;
        counselor_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Fragment fragment_home = new NotificationsFragment();
                transaction.replace(R.id.container, fragment_home);
                transaction.commit();
                counselorName = counselor_2.getText().toString();

                FileOutputStream outputStream;
                try{
                    outputStream = getActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(counselorName.getBytes());
                    outputStream.close();
                }catch (Exception e){
                    Log.v("Write counselor name","Error: " + e);
                }
            }
        });

        TextView counselor_3 = binding.counselorName1;
        counselor_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Fragment fragment_home = new NotificationsFragment();
                transaction.replace(R.id.container, fragment_home);
                transaction.commit();
                counselorName = counselor_3.getText().toString();

                FileOutputStream outputStream;
                try{
                    outputStream = getActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(counselorName.getBytes());
                    outputStream.close();
                }catch (Exception e){
                    Log.v("Write counselor name","Error: " + e);
                }
            }
        });



        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}