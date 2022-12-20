package edu.upi.cs.yudiwbs.uas_template;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.upi.cs.yudiwbs.uas_template.databinding.FragmentDuaBinding;
import edu.upi.cs.yudiwbs.uas_template.databinding.FragmentSatuBinding;

public class FragmentDua extends Fragment {

    private FragmentDuaBinding binding;
    DecimalFormat numberFormat = new DecimalFormat("0.00");
    Boolean limit = false;

    ArrayList<Hasil> alHasil = new ArrayList<>();
    AdapterHasil adapter;
    RecyclerView.LayoutManager lm;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            double x = sensorEvent.values[0];
            double y = sensorEvent.values[1];
            double z = sensorEvent.values[2];

            double acceleration = Math.sqrt(x * x + y * y + z * z);
            double finalAcc = Double.parseDouble(numberFormat.format(acceleration));

            if(!limit && finalAcc < 3) {
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                String ts = s.format(new Date());

                alHasil.add(new Hasil(ts));
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    public FragmentDua() {
        // Required empty public constructor
    }

    public static FragmentDua newInstance(String param1, String param2) {
        FragmentDua fragment = new FragmentDua();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDuaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        adapter = new AdapterHasil(alHasil);
        binding.rvHasil.setAdapter(adapter);

        lm = new LinearLayoutManager(getActivity());
        binding.rvHasil.setLayoutManager(lm);

        //supaya ada garis antar row
        binding.rvHasil.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        binding.buttonFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                String ts = s.format(new Date());

                alHasil.add(new Hasil(ts));

                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }
}