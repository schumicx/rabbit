// Generated code from Butter Knife. Do not modify!
package ml.rabbit.frame.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final ml.rabbit.frame.ui.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361799, "field 'listView' and method 'onItemClick'");
    target.listView = (android.widget.ListView) view;
    ((android.widget.AdapterView<?>) view).setOnItemClickListener(
      new android.widget.AdapterView.OnItemClickListener() {
        @Override public void onItemClick(
          android.widget.AdapterView<?> p0,
          android.view.View p1,
          int p2,
          long p3
        ) {
          target.onItemClick(p2);
        }
      });
    view = finder.findRequiredView(source, 2131361797, "field 'mDrawerLayout'");
    target.mDrawerLayout = (android.support.v4.widget.DrawerLayout) view;
  }

  public static void reset(ml.rabbit.frame.ui.MainActivity target) {
    target.listView = null;
    target.mDrawerLayout = null;
  }
}
