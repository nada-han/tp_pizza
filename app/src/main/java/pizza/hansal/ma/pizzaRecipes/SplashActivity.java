package pizza.hansal.ma.pizzaRecipes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    private ImageView image;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        image = findViewById(R.id.imageView2);
        image.setImageResource(R.drawable.back);

        ImageView iconView = findViewById(R.id.imageView3);
        iconView.setImageResource(R.drawable.icon);

        progressBar = findViewById(R.id.progressBar);

        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(7000);

                    //pour cacher le spinner apres chargement
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                        }
                    });

                    Intent intent = new Intent(SplashActivity.this, ListPizzaActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
    }
}
