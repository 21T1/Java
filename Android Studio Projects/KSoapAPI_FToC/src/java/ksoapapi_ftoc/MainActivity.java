package example.com.vn.ksoapapi_ftoc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import example.com.vn.config.Configuration;

public class MainActivity extends AppCompatActivity {

    EditText txtF;
    Button btnF;
    TextView txtC;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGetC();
            }
        });
    }

    private void handleGetC() {
        String f = txtF.getText().toString();
        FToCTask task = new FToCTask();
        task.execute(f);
    }

    class FToCTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtC.setText("");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtC.setText(s);
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                String f = strings[0];
                SoapObject request = new SoapObject(Configuration.NAME_SPACE, Configuration.METHOD_F_TO_C);
                request.addProperty(Configuration.PARAM_F_TO_C_FAHRENHEIT, f);

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);

                HttpTransportSE httpTransportSE = new HttpTransportSE(Configuration.SERVER_URL);
                httpTransportSE.call(Configuration.SOAP_ACTION_F_TO_C, envelope);
                SoapPrimitive data = (SoapPrimitive) envelope.getResponse();
                return data.toString();
            } catch (Exception e) {
                Log.e("ERROR", e.toString());
            }
            return null;
        }
    }

    private void addControls() {
        txtF = findViewById(R.id.txtF);
        btnF = findViewById(R.id.btnF);
        txtC = findViewById(R.id.txtC);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Thông báo");
        progressDialog.setMessage("Đang xử lý");
        progressDialog.setCanceledOnTouchOutside(false);
    }
}