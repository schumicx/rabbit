// Generated code from Butter Knife. Do not modify!
package ml.rabbit.frame.ui.test;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class PicassoFragment$$ViewInjector {
  public static void inject(Finder finder, final ml.rabbit.frame.ui.test.PicassoFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361826, "field 'gridView'");
    target.gridView = (android.widget.GridView) view;
  }

  public static void reset(ml.rabbit.frame.ui.test.PicassoFragment target) {
    target.gridView = null;
  }
}
