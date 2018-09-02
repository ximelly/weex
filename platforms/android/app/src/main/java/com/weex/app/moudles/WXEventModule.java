package com.weex.app.moudles;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.weex.app.WXPageActivity;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;


public class WXEventModule extends WXModule {
    @JSMethod()
    public void openURL(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Uri uri = Uri.parse(url);
        String scheme = uri.getScheme();

        boolean isJsBundle = false;
        if (!TextUtils.isEmpty(scheme)) {
            isJsBundle = scheme.equals("http") || scheme.equals("https") || scheme.equals("file");
        }
        if (isJsBundle) {
            Intent renderIntent = new Intent(mWXSDKInstance.getContext(), WXPageActivity.class);
            renderIntent.setData(uri);
            mWXSDKInstance.getContext().startActivity(renderIntent);
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            mWXSDKInstance.getContext().startActivity(intent);
        }
    }
}
