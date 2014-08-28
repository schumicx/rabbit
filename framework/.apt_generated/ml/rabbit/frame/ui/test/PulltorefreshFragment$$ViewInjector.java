// Generated code from Butter Knife. Do not modify!
package ml.rabbit.frame.ui.test;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class PulltorefreshFragment$$ViewInjector {
  public static void inject(Finder finder, final ml.rabbit.frame.ui.test.PulltorefreshFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361828, "field 'listview'");
    target.listview = (android.widget.ListView) view;
    view = finder.findRequiredView(source, 2131361827, "field 'swiperefresh'");
    target.swiperefresh = (android.support.v4.widget.SwipeRefreshLayout) view;
  }

  public static void reset(ml.rabbit.frame.ui.test.PulltorefreshFragment target) {
    target.listview = null;
    target.swiperefresh = null;
  }
}
