// Generated code from Butter Knife. Do not modify!
package ml.rabbit.frame.ui.test;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SaripaarFragment$$ViewInjector {
  public static void inject(Finder finder, final ml.rabbit.frame.ui.test.SaripaarFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361838, "field 'iAgreeCheckBox'");
    target.iAgreeCheckBox = (android.widget.CheckBox) view;
    view = finder.findRequiredView(source, 2131361835, "field 'emailEditText'");
    target.emailEditText = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131361821, "field 'registerButton' and method 'verify'");
    target.registerButton = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.verify();
        }
      });
    view = finder.findRequiredView(source, 2131361837, "field 'confirmPasswordEditText'");
    target.confirmPasswordEditText = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131361836, "field 'passwordEditText'");
    target.passwordEditText = (android.widget.EditText) view;
  }

  public static void reset(ml.rabbit.frame.ui.test.SaripaarFragment target) {
    target.iAgreeCheckBox = null;
    target.emailEditText = null;
    target.registerButton = null;
    target.confirmPasswordEditText = null;
    target.passwordEditText = null;
  }
}
