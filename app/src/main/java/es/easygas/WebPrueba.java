package es.easygas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebPrueba extends AppCompatActivity {

    private WebView miVisorWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web1);



        Bundle parametros = this.getIntent().getExtras();
        String url = parametros.getString("url");

        miVisorWeb = (WebView) findViewById(R.id.webview);
        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        miVisorWeb.loadUrl(url);


        miVisorWeb.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                System.out.println(description);
                super.onReceivedError(view, errorCode, description, failingUrl);

            }
        });
    }

    public void goErrorActivity (){

    }

    @Override
    public void onBackPressed() {
        if (miVisorWeb.canGoBack()) {
            miVisorWeb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}