package net.robertli.progressbardemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startProgress(View view) {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        Button goButton = (Button) findViewById(R.id.go_button);
        goButton.setEnabled(false);

        new Thread(new Runnable() {
            public void run() {
                while (doWork()) {
                    progressBar.incrementProgressBy(1);
                    if (progressBar.getProgress() == 100) {
                        break;
                    }
                }
            }
        }).start();
    }

    private boolean doWork() {
        for (int i = 0; i != 10000000; ++i) {
            // do nothing
        }
        return true;
    }
}
