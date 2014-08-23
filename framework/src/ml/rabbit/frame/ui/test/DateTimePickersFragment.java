package ml.rabbit.frame.ui.test;

import java.util.Calendar;

import mirko.android.datetimepicker.date.DatePickerDialog;
import mirko.android.datetimepicker.date.DatePickerDialog.OnDateSetListener;
import mirko.android.datetimepicker.time.RadialPickerLayout;
import mirko.android.datetimepicker.time.TimePickerDialog;
import mirko.android.datetimepicker.time.TimePickerDialog.OnTimeSetListener;
import ml.rabbit.frame.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class DateTimePickersFragment extends Fragment {
	@InjectView(R.id.tvTime)
	TextView tvDisplayTime;
	@InjectView(R.id.tvDate)
	TextView tvDisplayDate;
	@InjectView(R.id.switch1)
	Switch m24;

	@OnClick(R.id.btnChangeDate)
	public void changeDate() {
		datePickerDialog.show(getFragmentManager(), null);
	}

	@OnClick(R.id.btnChangeTime)
	public void changeTime() {
		if (m24.isChecked()) {
			timePickerDialog24h.show(getFragmentManager(), null);
		} else {
			timePickerDialog12h.show(getFragmentManager(), null);
		}
	}

	@OnCheckedChanged(R.id.switch1)
	public void onChecked(boolean checked) {
		if (m24.isChecked()) {
			checked = true;
		} else {
			checked = false;
		}
	}

	private final Calendar mCalendar = Calendar.getInstance();

	private int hourOfDay = mCalendar.get(Calendar.HOUR_OF_DAY);

	private int minute = mCalendar.get(Calendar.MINUTE);

	private int day = mCalendar.get(Calendar.DAY_OF_MONTH);

	private int month = mCalendar.get(Calendar.MONTH);

	private int year = mCalendar.get(Calendar.YEAR);

	final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
			new OnDateSetListener() {

				public void onDateSet(DatePickerDialog datePickerDialog,
						int year, int month, int day) {

					tvDisplayDate.setText(new StringBuilder().append(pad(day))
							.append(" ").append(pad(month + 1)).append(" ")
							.append(pad(year)));
					tvDisplayDate.setTextColor(getResources().getColor(
							android.R.color.holo_blue_light));
				}

			}, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
			mCalendar.get(Calendar.DAY_OF_MONTH));

	final TimePickerDialog timePickerDialog12h = TimePickerDialog.newInstance(
			new OnTimeSetListener() {

				@Override
				public void onTimeSet(RadialPickerLayout view, int hourOfDay,
						int minute) {

					tvDisplayTime.setText(new StringBuilder()
							.append(pad2(hourOfDay)).append(":")
							.append(pad(minute)).append(pad3(hourOfDay)));
					tvDisplayTime.setTextColor(getResources().getColor(
							android.R.color.holo_blue_light));
				}
			}, mCalendar.get(Calendar.HOUR_OF_DAY), mCalendar
					.get(Calendar.MINUTE), false);

	final TimePickerDialog timePickerDialog24h = TimePickerDialog.newInstance(
			new OnTimeSetListener() {

				@Override
				public void onTimeSet(RadialPickerLayout view, int hourOfDay,
						int minute) {

					tvDisplayTime.setText(new StringBuilder()
							.append(pad(hourOfDay)).append(":")
							.append(pad(minute)));
					tvDisplayTime.setTextColor(getResources().getColor(
							android.R.color.holo_blue_light));
				}
			}, mCalendar.get(Calendar.HOUR_OF_DAY), mCalendar
					.get(Calendar.MINUTE), true);

	public static DateTimePickersFragment newInstance() {
		DateTimePickersFragment f = new DateTimePickersFragment();
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
		View view = inflater.inflate(R.layout.test_datetimepickers_fragment,
				container, false);
		ButterKnife.inject(this, view);

		resetDate();
		resetTime();

		m24.setChecked(true);
		return view;
	}

	private void resetDate() {
		tvDisplayDate.setText(new StringBuilder().append(pad(day)).append(" ")
				.append(pad(month + 1)).append(" ").append(pad(year)));
		tvDisplayDate.setTextColor(getResources().getColor(
				android.R.color.darker_gray));

	}

	private void resetTime() {
		tvDisplayTime.setText(new StringBuilder().append(pad(hourOfDay))
				.append(":").append(pad(minute)));
		tvDisplayTime.setTextColor(getResources().getColor(
				android.R.color.darker_gray));

	}

	private static String pad(int c) {
		if (c >= 10)
			return String.valueOf(c);
		else
			return "0" + String.valueOf(c);
	}

	private static String pad2(int c) {
		if (c == 12)
			return String.valueOf(c);
		if (c == 00)
			return String.valueOf(c + 12);
		if (c > 12)
			return String.valueOf(c - 12);
		else
			return String.valueOf(c);
	}

	private static String pad3(int c) {
		if (c >= 12)
			return " PM";
		else
			return " AM";
	}

}