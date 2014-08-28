package ml.rabbit.frame.ui.test;

import ml.rabbit.frame.R;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.squareup.picasso.Picasso;

public class PicassoFragment extends Fragment {

	@InjectView(R.id.grid_view)
	GridView gridView;

	public static PicassoFragment newInstance() {
		PicassoFragment f = new PicassoFragment();
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
		View view = inflater.inflate(R.layout.test_picasso_fragment, container,
				false);
		ButterKnife.inject(this, view);

		gridView.setAdapter(new SampleGridViewAdapter(getActivity()));
		return view;
	}

}

class SampleGridViewAdapter extends BaseAdapter {
	private final Context context;
	static final String BASE = "http://i.imgur.com/";
	static final String EXT = ".jpg";
	static final String[] URLS = { BASE + "CqmBjo5" + EXT,
			BASE + "zkaAooq" + EXT, BASE + "0gqnEaY" + EXT,
			BASE + "9gbQ7YR" + EXT, BASE + "0E2tgV7" + EXT,
			BASE + "P5JLfjk" + EXT, BASE + "nz67a4F" + EXT,
			BASE + "dFH34N5" + EXT, BASE + "FI49ftb" + EXT,
			BASE + "DvpvklR" + EXT, BASE + "DNKnbG8" + EXT,
			BASE + "yAdbrLp" + EXT, BASE + "55w5Km7" + EXT,
			BASE + "NIwNTMR" + EXT, BASE + "xZLIYFV" + EXT,
			BASE + "HvTyeh3" + EXT, BASE + "Ig9oHCM" + EXT,
			BASE + "7GUv9qa" + EXT, BASE + "i5vXmXp" + EXT,
			BASE + "u6JF6JZ" + EXT, BASE + "ExwR7ap" + EXT,
			BASE + "Q54zMKT" + EXT, BASE + "9t6hLbm" + EXT,
			BASE + "F8n3Ic6" + EXT, BASE + "jbemFzr" + EXT,
			BASE + "OKvWoTh" + EXT, BASE + "zD3gT4Z" + EXT,
			BASE + "z77CaIt" + EXT, };

	public SampleGridViewAdapter(Context context) {
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView view = (ImageView) convertView;
		if (view == null) {
			view = new ImageView(context);
		}

		Picasso.with(context).load(getItem(position))
				.placeholder(R.drawable.ic_launcher)
				.error(R.drawable.ic_launcher).into(view);

		return view;
	}

	@Override
	public int getCount() {
		return URLS.length;
	}

	@Override
	public String getItem(int position) {
		return URLS[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
}