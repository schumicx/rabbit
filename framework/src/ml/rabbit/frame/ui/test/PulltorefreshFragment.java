package ml.rabbit.frame.ui.test;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ml.rabbit.frame.R;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PulltorefreshFragment extends Fragment {

	@InjectView(R.id.swiperefresh)
	SwipeRefreshLayout swiperefresh;
	@InjectView(R.id.listview)
	ListView listview;

	private static String[] ITEMS = { "list item 1", "list item 2",
			"list item 3", "list item 4", "list item 5", "list item 6",
			"list item 7", "list item 8", "list item 9", "list item 10",
			"list item 11", "list item 12", "list item 13", "list item 14",
			"list item 15", "list item 16", "list item 17", "list item 18",
			"list item 19", "list item 20", "list item 21", "list item 22",
			"list item 23", "list item 24", "list item 25" };

	public static PulltorefreshFragment newInstance() {
		PulltorefreshFragment f = new PulltorefreshFragment();
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
		View view = inflater.inflate(R.layout.test_pulltorefresh_fragment,
				container, false);
		ButterKnife.inject(this, view);

		listview.setAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, ITEMS));

		swiperefresh.setColorSchemeResources(android.R.color.holo_red_light,
				android.R.color.holo_green_light,
				android.R.color.holo_blue_bright,
				android.R.color.holo_orange_light);
		swiperefresh.setOnRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub

				/**
				 * Simulate Refresh with 4 seconds sleep
				 */
				new AsyncTask<Void, Void, Void>() {

					@Override
					protected Void doInBackground(Void... params) {
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						return null;
					}

					@Override
					protected void onPostExecute(Void result) {
						super.onPostExecute(result);

						// Notify PullToRefreshLayout that the refresh has
						// finished
						swiperefresh.setRefreshing(false);
					}
				}.execute();
			}

		});

		return view;
	}

}