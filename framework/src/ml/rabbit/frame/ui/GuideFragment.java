package ml.rabbit.frame.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;

public final class GuideFragment extends Fragment {

	private int mContent;
	private int mPosition;
	private int mLength;

	public static GuideFragment newInstance(int resources, int position,
			int length) {
		GuideFragment fragment = new GuideFragment();
		fragment.mContent = resources;
		fragment.mPosition = position;
		fragment.mLength = length;

		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ImageView imageView = new ImageView(getActivity());
		imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		imageView.setImageResource(mContent);
		imageView.setScaleType(ScaleType.CENTER_INSIDE);
		imageView.setTag(mPosition);

		if (Integer.parseInt(imageView.getTag().toString()) == mLength - 1) {
			imageView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					startActivity(new Intent(getActivity(), MainActivity.class));
					getActivity().finish();
				}
			});
		}
		return imageView;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
}
