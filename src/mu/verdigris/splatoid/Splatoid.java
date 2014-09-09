package mu.verdigris.splatoid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Splatoid extends Activity {

    static {
        System.loadLibrary("splatoid");
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        final TextView value =
            (TextView)Splatoid.this.findViewById(R.id.text_value);
        final int nativeValue = this.nativeTest();
        value.setText("The value is: " + nativeValue);
    }

    public native int nativeTest();
}
