package ml.rabbit.frame.ui.test;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ml.rabbit.frame.R;
import ml.rabbit.frame.support.pagerslidingtabstrip.PagerSlidingTabStrip;
import ml.rabbit.frame.support.pagerslidingtabstrip.PagerSlidingTabStrip.IconTabProvider;
import android.app.DialogFragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

public class QuickContactFragment extends DialogFragment {

	@InjectView(R.id.tabs)
	PagerSlidingTabStrip tabs;
	@InjectView(R.id.pager)
	ViewPager pager;
	private ContactPagerAdapter adapter;

	public static QuickContactFragment newInstance() {
		QuickContactFragment f = new QuickContactFragment();
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (getDialog() != null) {
			getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			getDialog().getWindow().setBackgroundDrawableResource(
					android.R.color.transparent);
		}

		View view = inflater.inflate(R.layout.test_pagequick_fragment,
				container, false);
		ButterKnife.inject(this, view);

		adapter = new ContactPagerAdapter();
		pager.setAdapter(adapter);
		tabs.setViewPager(pager);

		return view;
	}

	@Override
	public void onStart() {
		super.onStart();

		// change dialog width
		if (getDialog() != null) {

			Display display = getActivity().getWindowManager().getDefaultDisplay();
			Point size = new Point();
			display.getSize(size);
			int fullWidth = size.x;

			final int padding = (int) TypedValue.applyDimension(
					TypedValue.COMPLEX_UNIT_DIP, 48, getResources()
							.getDisplayMetrics());

			int w = fullWidth - padding;
			int h = getDialog().getWindow().getAttributes().height;

			getDialog().getWindow().setLayout(w, h);
		}
	}

	public class ContactPagerAdapter extends PagerAdapter implements
			IconTabProvider {

		private final int[] ICONS = {
				R.drawable.umeng_update_btn_check_on_holo_light,
				R.drawable.umeng_update_btn_check_off_holo_light,
				R.drawable.umeng_update_btn_check_on_holo_light,
				R.drawable.umeng_update_btn_check_off_holo_light };

		public ContactPagerAdapter() {
			super();
		}

		@Override
		public int getCount() {
			return ICONS.length;
		}

		@Override
		public int getPageIconResId(int position) {
			return ICONS[position];
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// looks a little bit messy here
			TextView v = new TextView(getActivity());
			v.setBackgroundColor(0xffe5e5e5);
			v.setText("PAGE " + (position + 1));
			v.setGravity(Gravity.CENTER);
			container.addView(v, 0);
			return v;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object view) {
			container.removeView((View) view);
		}

		@Override
		public boolean isViewFromObject(View v, Object o) {
			return v == ((View) o);
		}

	}

}
