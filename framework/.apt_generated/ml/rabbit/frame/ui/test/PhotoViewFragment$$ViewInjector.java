// Generated code from Butter Knife. Do not modify!
package ml.rabbit.frame.ui.test;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class PhotoViewFragment$$ViewInjector {
  public static void inject(Finder finder, final ml.rabbit.frame.ui.test.PhotoViewFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361834, "field 'photoView'");
    target.photoView = (uk.co.senab.photoview.PhotoView) view;
  }

  public static void reset(ml.rabbit.frame.ui.test.PhotoViewFragment target) {
    target.photoView = null;
  }
}
