package ml.rabbit.frame.ui.test;

import ml.rabbit.frame.R;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.viewpagerindicator.CirclePageIndicator;

public class ViewpagerFragment extends Fragment {

	TestFragmentAdapter mAdapter;
	@InjectView(R.id.pager)
	ViewPager mPager;
	@InjectView(R.id.indicator)
	CirclePageIndicator mIndicator;

	public static ViewpagerFragment newInstance() {
		ViewpagerFragment f = new ViewpagerFragment();
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
		View view = inflater.inflate(R.layout.test_viewpager_fragment,
				container, false);
		ButterKnife.inject(this, view);

		mAdapter = new TestFragmentAdapter(getFragmentManager());
		mPager.setAdapter(mAdapter);
		mIndicator.setViewPager(mPager);

		return view;
	}

	class TestFragmentAdapter extends FragmentStatePagerAdapter {
		private String[] CONTENT = new String[] { "This", "Is", "A", "Test", };

		private int mCount = CONTENT.length;

		public TestFragmentAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
		}

		@Override
		public int getCount() {
			return mCount;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return CONTENT[position % CONTENT.length];
		}

		public void setCount(int count) {
			if (count > 0 && count <= 10) {
				mCount = count;
				notifyDataSetChanged();
			}
		}
	}

	static class TestFragment extends Fragment {
		private static final String KEY_CONTENT = "TestFragment:Content";

		public static TestFragment newInstance(String content) {
			TestFragment fragment = new TestFragment();

			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < 20; i++) {
				builder.append(content).append(" ");
			}
			builder.deleteCharAt(builder.length() - 1);
			fragment.mContent = builder.toString();

			return fragment;
		}

		private String mContent = "???";

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			if ((savedInstanceState != null)
					&& savedInstanceState.containsKey(KEY_CONTENT)) {
				mContent = savedInstanceState.getString(KEY_CONTENT);
			}
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			TextView text = new TextView(getActivity());
			text.setGravity(Gravity.CENTER);
			text.setText(mContent);
			text.setTextSize(20 * getResources().getDisplayMetrics().density);
			text.setPadding(20, 20, 20, 20);

			LinearLayout layout = new LinearLayout(getActivity());
			layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
			layout.setGravity(Gravity.CENTER);
			layout.addView(text);

			return layout;
		}

		@Override
		public void onSaveInstanceState(Bundle outState) {
			super.onSaveInstanceState(outState);
			outState.putString(KEY_CONTENT, mContent);
		}
	}
}
