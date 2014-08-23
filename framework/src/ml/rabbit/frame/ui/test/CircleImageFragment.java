package ml.rabbit.frame.ui.test;

import ml.rabbit.frame.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CircleImageFragment extends Fragment {

	public static CircleImageFragment newInstance() {
		CircleImageFragment f = new CircleImageFragment();
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.test_circleimage_fragment,
				container, false);
		return view;
	}

}