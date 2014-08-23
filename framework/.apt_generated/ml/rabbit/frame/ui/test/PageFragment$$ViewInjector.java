// Generated code from Butter Knife. Do not modify!
package ml.rabbit.frame.ui.test;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class PageFragment$$ViewInjector {
  public static void inject(Finder finder, final ml.rabbit.frame.ui.test.PageFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361831, "field 'tabs'");
    target.tabs = (ml.rabbit.frame.support.pagerslidingtabstrip.PagerSlidingTabStrip) view;
    view = finder.findRequiredView(source, 2131361832, "field 'pager'");
    target.pager = (android.support.v4.view.ViewPager) view;
  }

  public static void reset(ml.rabbit.frame.ui.test.PageFragment target) {
    target.tabs = null;
    target.pager = null;
  }
}
