package es.easygas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isConnected() == true){
                    Uri uri = getIntent().getData();
                    String path = "";
                    if(uri!=null){
                        path = uri.toString();
                        Toast.makeText(MainActivity.this, "Path = "+path, Toast.LENGTH_SHORT).show();

                        Intent prueba = new Intent(MainActivity.this, WebPrueba.class);
                        prueba.putExtra("url", path);
                        startActivity(prueba);
                    }else{
                        startActivity(new Intent(MainActivity.this, WebActivity.class));
                    }


                }else{
                    startActivity(new Intent(MainActivity.this, ErrorActivity.class));
                }
                finish();
            }
        }, 2000);




    }

    private boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        boolean activo = false;

        if (networkInfo != null && networkInfo.isConnected()) {
            activo = true;
        }
        return activo;
    }
}