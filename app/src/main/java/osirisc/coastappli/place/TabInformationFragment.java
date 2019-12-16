package osirisc.coastappli.place;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import osirisc.coastappli.FullScreen;
import osirisc.coastappli.PlaceMainActivity;
import osirisc.coastappli.R;

public class TabInformationFragment extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab_information, container, false);
        TextView textViewNamePlace = root.findViewById(R.id.textViewNamePlace);
        TextView textViewCoastType = root.findViewById(R.id.textViewCoastType);
        TextView textViewINEC = root.findViewById(R.id.textViewINEC);
        textViewNamePlace.setText(((PlaceMainActivity)getActivity()).getNameBeach()+"\n"+((PlaceMainActivity)getActivity()).getNameTown());
        textViewCoastType.setText(((PlaceMainActivity)getActivity()).getCoastType());
        textViewINEC.setText(((PlaceMainActivity)getActivity()).getINEC());
        ImageView imageViewPlace = root.findViewById(R.id.imageViewPlace);
        Bitmap bm = BitmapFactory.decodeByteArray(((PlaceMainActivity)getActivity()).getPhoto(), 0,((PlaceMainActivity)getActivity()).getPhoto().length);
        imageViewPlace.setImageBitmap(bm);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the button view
        final ImageView imageViewPlace = getView().findViewById(R.id.imageViewPlace);
        // set a onclick listener for when the button gets clicked
        imageViewPlace.setOnClickListener(new View.OnClickListener() {
            // Start new list activity
            public void onClick(View v) {
                Intent mainIntent = new Intent(getActivity(), FullScreen.class);
                mainIntent.putExtra("markerLatitude",((PlaceMainActivity)getActivity()).getMarkerLatitude());
                mainIntent.putExtra("markerLongitude",((PlaceMainActivity)getActivity()).getMarkerLongitude());
                mainIntent.putExtra("imageType", "informationPhoto");
                startActivity(mainIntent);
            }
        });
    }

}
