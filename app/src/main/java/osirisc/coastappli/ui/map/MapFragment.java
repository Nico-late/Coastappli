package osirisc.coastappli.ui.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import osirisc.coastappli.MainActivity;
import osirisc.coastappli.R;

public class MapFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity)getActivity()).createMap(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_map, container, false);
        return root;
    }
}