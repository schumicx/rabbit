// Generated code from Butter Knife. Do not modify!
package ml.rabbit.frame.ui.test;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ViewpagerFragment$$ViewInjector {
  public static void inject(Finder finder, final ml.rabbit.frame.ui.test.ViewpagerFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361850, "field 'mIndicator'");
    target.mIndicator = (com.viewpagerindicator.CirclePageIndicator) view;
    view = finder.findRequiredView(source, 2131361823, "field 'mPager'");
    target.mPager = (android.support.v4.view.ViewPager) view;
  }

  public static void reset(ml.rabbit.frame.ui.test.ViewpagerFragment target) {
    target.mIndicator = null;
    target.mPager = null;
  }
}
