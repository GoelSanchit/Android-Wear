package websank.corp.mahisan.circledimageview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CircledImageViewActivity extends Activity {

    private int mValue=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CircledImageView circledImageViewCancel = (CircledImageView) findViewById(R.id.circledImageViewCancel);
        final Handler handler = new Handler();
        circledImageViewCancel.setProgress(0.0f);
        circledImageViewCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (mValue < 100){
                            mValue +=0.1f;
                            try{
                                Thread.sleep(100);
                            } catch(InterruptedException e) {
                                e.printStackTrace();
                            }
                            //Update the Circular Progress Bar
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    circledImageViewCancel.setProgress(mValue);
                                }
                            });
                        }
                    }
                }).start();
                Toast.makeText(getBaseContext(),"Cancel Clicked",Toast.LENGTH_LONG).show();
            }
        });

        final CircledImageView circledImageViewOK = (CircledImageView) findViewById(R.id.circledImageViewOK);
        circledImageViewOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"OK Clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
