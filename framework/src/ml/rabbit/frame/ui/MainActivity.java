package ml.rabbit.frame.ui;

import ml.rabbit.frame.R;
import ml.rabbit.frame.support.utils.DeviceUtils;
import ml.rabbit.frame.ui.test.CircleImageFragment;
import ml.rabbit.frame.ui.test.DateTimePickersFragment;
import ml.rabbit.frame.ui.test.FragmentSuperActivityToast;
import ml.rabbit.frame.ui.test.FragmentSuperCardToast;
import ml.rabbit.frame.ui.test.FragmentSuperToast;
import ml.rabbit.frame.ui.test.PageFragment;
import ml.rabbit.frame.ui.test.PhotoViewFragment;
import ml.rabbit.frame.ui.test.PicassoFragment;
import ml.rabbit.frame.ui.test.PulltorefreshFragment;
import ml.rabbit.frame.ui.test.QuickContactFragment;
import ml.rabbit.frame.ui.test.SaripaarFragment;
import ml.rabbit.frame.ui.test.ViewpagerFragment;
import ml.rabbit.frame.ui.test.VolleyFragment;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;

import com.github.johnpersano.supertoasts.SuperToast;
import com.umeng.message.PushAgent;

public class MainActivity extends BaseActivity implements DrawerListener {

	@InjectView(R.id.drawer_layout)
	DrawerLayout mDrawerLayout;
	@InjectView(R.id.left_drawer)
	ListView listView;

	@OnItemClick(R.id.left_drawer)
	void onItemClick(int position) {
		getActionBar().setDisplayShowTitleEnabled(true);
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);

		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = PulltorefreshFragment.newInstance();
			break;
		case 1:
			fragment = DateTimePickersFragment.newInstance();
			break;
		case 2:
			getActionBar().setDisplayShowTitleEnabled(false);
			getActionBar().setDisplayShowHomeEnabled(false);
			getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

			ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_dropdown_item_1line,
					android.R.id.text1, new String[] { "SuperToast",
							"SuperActivityToast", "SuperCardToast" });
			arrayAdapter
					.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
			getActionBar().setListNavigationCallbacks(arrayAdapter,
					new ActionBar.OnNavigationListener() {
						@Override
						public boolean onNavigationItemSelected(
								int itemPosition, long itemId) {
							Fragment fragment = null;
							switch (itemPosition) {
							case 0:
								fragment = new FragmentSuperToast();
								break;
							case 1:
								fragment = new FragmentSuperActivityToast();
								break;
							case 2:
								fragment = new FragmentSuperCardToast();
								break;
							}
							FragmentTransaction fragmentTransaction = getFragmentManager()
									.beginTransaction();
							fragmentTransaction.replace(R.id.framelayout,
									fragment);
							fragmentTransaction.commit();
							return false;
						}
					});
			break;
		case 3:
			fragment = ViewpagerFragment.newInstance();
			break;
		case 4:
			fragment = PhotoViewFragment.newInstance();
			break;
		case 5:
			fragment = CircleImageFragment.newInstance();
			break;
		case 6:
			fragment = PicassoFragment.newInstance();
			break;
		case 7:
			fragment = PageFragment.newInstance();
			break;
		case 8:
			fragment = SaripaarFragment.newInstance();
			break;
		case 9:
			fragment = VolleyFragment.newInstance();
			break;
		case 10:

			break;
		case 11:

			break;
		case 12:

			break;
		case 13:

			break;
		}
		if (fragment != null) {
			getFragmentManager().beginTransaction()
					.replace(R.id.framelayout, fragment).commit();
		}
		mActionBar.setTitle(TITLES[position]);
		mDrawerLayout.closeDrawer(listView);
	}

	private ActionBarHelper mActionBar;
	private ActionBarDrawerToggle mDrawerToggle;

	public static final String[] TITLES = { "下拉刷新", "日历", "弹出提示", "viewpage",
			"图片放大", "圆形图片", "网络图片", "pagefragment", "校验", "网络请求", "缓存", "下载",
			"上传", "数据库" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);

		SharedPreferences preferences = getSharedPreferences("FIRST", MODE_PRIVATE);
		if (preferences.getBoolean(String.valueOf(DeviceUtils.getPackageCode(this)), true)) {
			Editor editor = preferences.edit();
			editor.putBoolean(String.valueOf(DeviceUtils.getPackageCode(this)), false);
			editor.commit();
		}
		
		PushAgent.getInstance(this).enable();

		// getActionBar().setTitle("主标题");
		// getActionBar().setSubtitle("副标题");

		// TextView title = (TextView)
		// findViewById(Resources.getSystem().getIdentifier("action_bar_title",
		// "id", "android"));
		// title.setTextColor(Color.WHITE);
		// TextView subTitle = (TextView)
		// findViewById(Resources.getSystem().getIdentifier("action_bar_subtitle",
		// "id", "android"));
		// subTitle.setTextColor(Color.WHITE);
		// getActionBar().setBackgroundDrawable(new ColorDrawable(0xff00bcd4));

		mDrawerLayout.setDrawerListener(this);

		listView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, TITLES));
		// listView.setCacheColorHint(0);
		// listView.setScrollingCacheEnabled(false);
		// listView.setScrollContainer(false);
		// listView.setFastScrollEnabled(true);
		// listView.setSmoothScrollbarEnabled(true);

		mActionBar = createActionBarHelper();
		mActionBar.init();

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_nav_drawer, R.string.drawer_open,
				R.string.drawer_close);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		switch (item.getItemId()) {
		case R.id.push_list:
			QuickContactFragment dialog = new QuickContactFragment();
			dialog.show(getFragmentManager(), "QuickContactFragment");
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(listView);
		hideMenuItems(menu, !drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	private void hideMenuItems(Menu menu, boolean visible) {
		for (int i = 0; i < menu.size(); i++) {
			menu.getItem(i).setVisible(visible);
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	private ActionBarHelper createActionBarHelper() {
		return new ActionBarHelper();
	}

	private class ActionBarHelper {
		private final ActionBar mActionBar;
		private CharSequence mDrawerTitle;
		private CharSequence mTitle;

		private ActionBarHelper() {
			mActionBar = getActionBar();
		}

		public void init() {
			mActionBar.setDisplayHomeAsUpEnabled(true);
			mActionBar.setHomeButtonEnabled(true);
			mTitle = mDrawerTitle = getTitle();
		}

		public void onDrawerClosed() {
			mActionBar.setTitle(mTitle);
			invalidateOptionsMenu();
		}

		public void onDrawerOpened() {
			mActionBar.setTitle(mDrawerTitle);
			invalidateOptionsMenu();
		}

		public void setTitle(CharSequence title) {
			mTitle = title;
		}
	}

	@Override
	public void onDrawerStateChanged(int newState) {
		mDrawerToggle.onDrawerStateChanged(newState);
	}

	@Override
	public void onDrawerSlide(View drawerView, float slideOffset) {
		mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
	}

	@Override
	public void onDrawerOpened(View drawerView) {
		mDrawerToggle.onDrawerOpened(drawerView);
		mActionBar.onDrawerOpened();
	}

	@Override
	public void onDrawerClosed(View drawerView) {
		mDrawerToggle.onDrawerClosed(drawerView);
		mActionBar.onDrawerClosed();
	}

	private static long back_pressed;

	@Override
	public void onBackPressed() {
		if (back_pressed + 2000 > System.currentTimeMillis()) {
			super.onBackPressed();
		} else {
			SuperToast.create(getBaseContext(), "再按一次退出", SuperToast.Duration.SHORT).show();
		}
		back_pressed = System.currentTimeMillis();
	}

}
