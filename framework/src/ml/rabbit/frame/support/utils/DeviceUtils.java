package ml.rabbit.frame.support.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class DeviceUtils {

	/**
	 * 获取当前程序版本名
	 * 
	 * @param context
	 * @return
	 */
	public static String getPackageVersion(Context context) {
		String versionName = "";
		try {
			PackageInfo pi = context
					.getApplicationContext()
					.getPackageManager()
					.getPackageInfo(
							context.getApplicationContext().getPackageName(), 0);
			versionName = pi.versionName;
		} catch (Exception e) {
			versionName = "";
		}
		return versionName;
	}

	/**
	 * 获取当前程序包名
	 * 
	 * @param context
	 * @return
	 */
	public static String getPackageName(Context context) {
		String packageName = "";
		try {
			PackageInfo pi = context
					.getApplicationContext()
					.getPackageManager()
					.getPackageInfo(
							context.getApplicationContext().getPackageName(), 0);
			packageName = pi.packageName;
		} catch (Exception e) {
			packageName = "";
		}
		return packageName;
	}

	/**
	 * 获取当前程序版本code
	 * 
	 * @param context
	 * @return
	 */
	public static int getPackageCode(Context context) {
		int versionCode;
		try {
			PackageInfo pi = context
					.getApplicationContext()
					.getPackageManager()
					.getPackageInfo(
							context.getApplicationContext().getPackageName(), 0);
			versionCode = pi.versionCode;
		} catch (Exception e) {
			versionCode = 1;
		}
		return versionCode;
	}

	/**
	 * 判断是否是平板
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isTablet(Context context) {
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}

	/**
	 * 获取屏幕密度
	 * 
	 * @param context
	 * @return
	 */
	public static float getScreenDensity(Context context) {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getMetrics(displaymetrics);
		return displaymetrics.density;
	}

	/**
	 * 获取设备信息
	 * 
	 * @param context
	 * @return
	 */
	public static TelephonyManager getTelephonyManager(Context context) {
		return (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
	}

	/**
	 * 获取网络信息
	 * 
	 * @param context
	 * @return
	 */
	public static WifiManager getWifiManager(Context context) {
		return (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
	}
}
