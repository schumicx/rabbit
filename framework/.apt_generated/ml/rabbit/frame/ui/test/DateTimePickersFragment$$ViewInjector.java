// Generated code from Butter Knife. Do not modify!
package ml.rabbit.frame.ui.test;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class DateTimePickersFragment$$ViewInjector {
  public static void inject(Finder finder, final ml.rabbit.frame.ui.test.DateTimePickersFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361820, "field 'm24' and method 'onChecked'");
    target.m24 = (android.widget.Switch) view;
    ((android.widget.CompoundButton) view).setOnCheckedChangeListener(
      new android.widget.CompoundButton.OnCheckedChangeListener() {
        @Override public void onCheckedChanged(
          android.widget.CompoundButton p0,
          boolean p1
        ) {
          target.onChecked(p1);
        }
      });
    view = finder.findRequiredView(source, 2131361816, "field 'tvDisplayDate'");
    target.tvDisplayDate = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131361819, "field 'tvDisplayTime'");
    target.tvDisplayTime = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131361821, "method 'changeTime'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.changeTime();
        }
      });
    view = finder.findRequiredView(source, 2131361817, "method 'changeDate'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.changeDate();
        }
      });
  }

  public static void reset(ml.rabbit.frame.ui.test.DateTimePickersFragment target) {
    target.m24 = null;
    target.tvDisplayDate = null;
    target.tvDisplayTime = null;
  }
}
