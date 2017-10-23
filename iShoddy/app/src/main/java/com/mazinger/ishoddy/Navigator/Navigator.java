package com.mazinger.ishoddy.Navigator;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.mazinger.ishoddy.activities.LoginActivity;
import com.mazinger.ishoddy.activities.PasswordForgottenActivity;


public class Navigator {

    public static Intent navigateFromLoginActivityToPasswordForgottenActivity(@NonNull final LoginActivity activity) {
        assert (activity != null);

        final Intent intent = new Intent(activity, PasswordForgottenActivity.class);
        activity.startActivity(intent);
        return intent;
    }


}
