package ml.rabbit.frame.ui;

import ml.rabbit.frame.R;
import ml.rabbit.frame.support.guidebackgroundcoloranimation.ColorAnimationView;
import ml.rabbit.frame.ui.adapter.GuideFragmentAdapter;
import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.viewpagerindicator.CirclePageIndicator;

public class GuideActivity extends BaseActivity {

	@InjectView(R.id.pager)
	ViewPager mPager;
	@InjectView(R.id.indicator)
	CirclePageIndicator mIndicator;
	@InjectView(R.id.ColorAnimationView)
	ColorAnimationView colorAnimationView;
	GuideFragmentAdapter mAdapter;

	@SuppressLint("Recycle")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		ButterKnife.inject(this);

		TypedArray typedArray = getResources().obtainTypedArray(
				R.array.guide_res);
		mAdapter = new GuideFragmentAdapter(getFragmentManager(), typedArray);
		mPager.setAdapter(mAdapter);

		colorAnimationView.setViewPager(mPager, typedArray.length(),
				Color.MAGENTA, Color.YELLOW, Color.CYAN, Color.GREEN,
				Color.BLUE);
		mIndicator.setViewPager(mPager);

		mPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				colorAnimationView.getmPageChangeListener()
						.onPageSelected(arg0);
				mIndicator.onPageSelected(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				colorAnimationView.getmPageChangeListener().onPageScrolled(
						arg0, arg1, arg2);
				mIndicator.onPageScrolled(arg0, arg1, arg2);
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				colorAnimationView.getmPageChangeListener()
						.onPageScrollStateChanged(arg0);
				mIndicator.onPageScrollStateChanged(arg0);
			}
		});

	}
}