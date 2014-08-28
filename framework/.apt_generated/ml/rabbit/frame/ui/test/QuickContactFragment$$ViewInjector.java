// Generated code from Butter Knife. Do not modify!
package ml.rabbit.frame.ui.test;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class QuickContactFragment$$ViewInjector {
  public static void inject(Finder finder, final ml.rabbit.frame.ui.test.QuickContactFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361822, "field 'tabs'");
    target.tabs = (ml.rabbit.frame.support.pagerslidingtabstrip.PagerSlidingTabStrip) view;
    view = finder.findRequiredView(source, 2131361823, "field 'pager'");
    target.pager = (android.support.v4.view.ViewPager) view;
  }

  public static void reset(ml.rabbit.frame.ui.test.QuickContactFragment target) {
    target.tabs = null;
    target.pager = null;
  }
}
