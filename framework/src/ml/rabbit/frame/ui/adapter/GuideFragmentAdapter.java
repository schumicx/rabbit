package ml.rabbit.frame.ui.adapter;

import ml.rabbit.frame.ui.GuideFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.TypedArray;
import android.support.v13.app.FragmentPagerAdapter;

public class GuideFragmentAdapter extends FragmentPagerAdapter {

	private TypedArray RESOURCES;

	public GuideFragmentAdapter(FragmentManager fm, TypedArray typedArray) {
		super(fm);
		RESOURCES = typedArray;
	}

	@Override
	public Fragment getItem(int position) {
		return GuideFragment.newInstance(
				RESOURCES.getResourceId(position % RESOURCES.length(), 0),
				position, RESOURCES.length());
	}

	@Override
	public int getCount() {
		return RESOURCES.length();
	}

}
