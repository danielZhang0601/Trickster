package cn.zxd.trickster.ui.activity;

import cn.zxd.trickster.R;
import cn.zxd.trickster.util.RootUtils;
import cn.zxd.trickster.util.XposedUtils;

public class LauncherActivity extends BaseActivity {

    @Override
    protected boolean isFullScreen() {
        return true;
    }

    @Override
    protected int layoutResource() {
        return R.layout.activity_launcher;
    }

    @Override
    protected void onResume() {
        super.onResume();
        toNext();
    }

    void toNext() {
        if (!RootUtils.isDeviceRooted()) {
            PreRootActivity.launch(this);
        } else if (XposedUtils.isXposedInstalled()) {
            PreXposedActivity.launch(this);
        } else {
            MainActivity.launch(this);
        }
    }
}
