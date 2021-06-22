package com.example.covid_19vaccinefinder;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClientImpl extends WebViewClient {

    private Activity activity = null;

    public WebViewClientImpl(Activity activity){
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.indexOf("https://selfregistration.cowin.gov.in/") > -1)
            return false;

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(i);
        return true;
    }
}
