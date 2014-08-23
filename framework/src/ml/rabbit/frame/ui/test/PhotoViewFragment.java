package ml.rabbit.frame.ui.test;

import ml.rabbit.frame.R;
import uk.co.senab.photoview.PhotoView;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class PhotoViewFragment extends Fragment {

	@InjectView(R.id.photoview)
	PhotoView photoView;
	
	public static PhotoViewFragment newInstance() {
		PhotoViewFragment f = new PhotoViewFragment();
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
		View view = inflater.inflate(R.layout.test_photoview_fragment,
				container, false);
		ButterKnife.inject(this, view);
		
		photoView.setImageResource(R.drawable.ic_launcher);
		
		return view;
	}

}