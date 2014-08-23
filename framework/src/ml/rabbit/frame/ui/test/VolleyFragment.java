package ml.rabbit.frame.ui.test;

import java.util.HashMap;
import java.util.Map;

import ml.rabbit.frame.R;
import ml.rabbit.frame.support.utils.ApplicationController;
import ml.rabbit.frame.support.utils.JacksonObjectRequest;

import org.json.JSONObject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

public class VolleyFragment extends Fragment {

	@InjectView(R.id.textview)
	TextView textview;

	public static VolleyFragment newInstance() {
		VolleyFragment f = new VolleyFragment();
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
		View view = inflater.inflate(R.layout.test_volley_fragment, container,
				false);
		ButterKnife.inject(this, view);

		String url = "http://httpbin.org/post";
		Map<String, String> params = new HashMap<String, String>();
		params.put("params1", "value1");
		params.put("params2", "value2");
		ApplicationController.getInstance().addToRequestQueue(
				new JacksonObjectRequest<>(Method.POST, url, Map.class,
						new JSONObject(params), new Listener<Map>() {
							@Override
							public void onResponse(Map response) {
								// TODO Auto-generated method stub
								textview.setText(response.toString());
							}
						}, new ErrorListener() {
							@Override
							public void onErrorResponse(VolleyError error) {
								// TODO Auto-generated method stub
								error.printStackTrace();
								textview.setText(error.getMessage());
							}
						}));

		return view;
	}

}