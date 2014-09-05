package ml.rabbit.frame.ui;

import ml.rabbit.frame.R;
import ml.rabbit.frame.support.utils.DeviceUtils;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;

public class WelcomeActivity extends BaseActivity {

	private Intent intent;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ImageView imageView = new ImageView(this);
		imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		imageView.setImageResource(R.drawable.ic_launcher);
		imageView.setScaleType(ScaleType.CENTER_INSIDE);
		imageView.setBackgroundColor(getResources().getColor(R.color.welcome_background));

		setContentView(imageView);
		
		new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... params) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				super.onPostExecute(result);
				loadPage();
			}
		}.execute();
	}
	
	private void loadPage(){
		SharedPreferences preferences = getSharedPreferences("FIRST", MODE_PRIVATE);
		if (preferences.getBoolean(String.valueOf(DeviceUtils.getPackageCode(this)), true)) {
			intent = new Intent(this, GuideActivity.class);
		} else {
			intent = new Intent(this, MainActivity.class);
		}
		startActivity(intent);
		finish();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
