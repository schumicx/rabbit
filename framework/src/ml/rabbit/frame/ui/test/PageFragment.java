package ml.rabbit.frame.ui.test;

import ml.rabbit.frame.R;
import ml.rabbit.frame.support.pagerslidingtabstrip.PagerSlidingTabStrip;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class PageFragment extends Fragment {

	@InjectView(R.id.tabs)
	PagerSlidingTabStrip tabs;
	@InjectView(R.id.pager)
	ViewPager pager;
	private MyPagerAdapter adapter;

	public static PageFragment newInstance() {
		PageFragment f = new PageFragment();
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
		View view = inflater.inflate(R.layout.test_page_fragment, container,
				false);
		ButterKnife.inject(this, view);
		
		adapter = new MyPagerAdapter(getFragmentManager());
		pager.setAdapter(adapter);
		tabs.setViewPager(pager);

		return view;
	}

	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "tab1", "tab2", "tab3", "tab4",
				"tab5", "tab6", "tab7", "tab8" };

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			return SuperAwesomeCardFragment.newInstance(position);
		}

	}

}

class SuperAwesomeCardFragment extends Fragment {

	private static final String ARG_POSITION = "position";

	private int position;

	public static SuperAwesomeCardFragment newInstance(int position) {
		SuperAwesomeCardFragment f = new SuperAwesomeCardFragment();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		f.setArguments(b);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		position = getArguments().getInt(ARG_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		FrameLayout fl = new FrameLayout(getActivity());
		TextView v = new TextView(getActivity());
		v.setGravity(Gravity.CENTER);
		v.setText("CARD " + (position + 1));
		fl.addView(v);
		return fl;
	}

}