package ml.rabbit.frame.ui.test;

import ml.rabbit.frame.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.Validator.ValidationListener;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Required;
import com.mobsandgeeks.saripaar.annotation.TextRule;

public class SaripaarFragment extends Fragment {

	@InjectView(R.id.et_email)
	@Required(order = 1, message = "必填校验")
	@Email(order = 2, message = "邮箱校验")
	EditText emailEditText;

	@InjectView(R.id.et_pwd)
	@Password(order = 3, message = "密码必填校验")
	@TextRule(order = 4, minLength = 6, maxLength = 12, message = "长度大于6,小于12校验")
	EditText passwordEditText;

	@InjectView(R.id.et_repwd)
	@ConfirmPassword(order = 5, message = "重复密码校验")
	EditText confirmPasswordEditText;

	@InjectView(R.id.checkbox)
	@Checked(order = 6, message = "必选校验")
	CheckBox iAgreeCheckBox;

	@InjectView(R.id.button)
	Button registerButton;

	@OnClick(R.id.button)
	public void verify() {
		validator.validate();
	}

	Validator validator;

	public static SaripaarFragment newInstance() {
		SaripaarFragment f = new SaripaarFragment();
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
		View view = inflater.inflate(R.layout.test_saripaar_fragment,
				container, false);
		ButterKnife.inject(this, view);
		validator = new Validator(this);
		validator.setValidationListener(new ValidationListener() {

			@Override
			public void onValidationSucceeded() {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "所有校验正确!",
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onValidationFailed(View failedView, Rule<?> failedRule) {
				String message = failedRule.getFailureMessage();

				if (failedView instanceof EditText) {
					failedView.requestFocus();
					((EditText) failedView).setError(message);
				} else {
					Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT)
							.show();
				}
			}
		});

		return view;
	}

}