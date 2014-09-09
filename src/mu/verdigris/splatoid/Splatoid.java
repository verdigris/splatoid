package mu.verdigris.splatoid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Splatoid extends Activity {

    static {
        System.loadLibrary("python2.6");
        System.loadLibrary("splatoid");
    };

    static final String SCRIPT =
        "f1 = open('/sdcard/splatoid-was-here', 'r')\n" +
        "f2 = open('/sdcard/splatoid-python', 'w')\n" +
        "f2.write(f1.read())\n";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        final TextView value =
            (TextView)Splatoid.this.findViewById(R.id.text_value);
        final int nativeValue = this.nativeTest();
        value.setText("The value is: " + nativeValue);

        final TextView python =
            (TextView)Splatoid.this.findViewById(R.id.text_python);
        final int pythonValue = this.pythonTest(SCRIPT);
        python.setText("Python script: \n\n" + script +
                       "\n\nreturned value: " + pythonValue);
    }

    public native int nativeTest();
    public native int pythonTest(String script);
}
