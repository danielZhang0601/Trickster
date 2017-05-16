package cn.zxd.trickster.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;
import cn.zxd.trickster.manager.CustomerActivityManager;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int layoutResource();

    private static Intent launchIntent(Context context, Bundle bundle) {
        String className = new Object() {
            public String getClassName() {
                String clazzName = this.getClass().getName();
                return clazzName.substring(0, clazzName.indexOf('$'));
            }
        }.getClassName();
        try {
            Intent intent = new Intent(context, Class.forName(className));
            if (bundle != null)
                intent.putExtras(bundle);
            return intent;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void launch(Context context) {
        launch(context, null);
    }

    public static void launch(Context context, Bundle bundle) {
        Intent intent = launchIntent(context, bundle);
        if (intent != null)
            context.startActivity(intent);
    }

    public static void launch(Activity activity, Bundle bundle, int requestCode) {
        Intent intent = launchIntent(activity, bundle);
        if (intent != null) {
            if (requestCode > 0)
                activity.startActivityForResult(intent, requestCode);
            else
                activity.startActivity(intent);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //CustomerActivityManager add this
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (isFullScreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(layoutResource());
        ButterKnife.bind(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected boolean isFullScreen() {
        return false;
    }
}
