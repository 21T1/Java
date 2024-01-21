package example.com.vn.ksoapapi;

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

    EditText txtC;
    TextView txtF;
    Button btnSubmit;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGetF();
            }
        });
    }

    private void handleGetF() {
        String c = txtC.getText().toString();
        CToFTask task = new CToFTask();
        task.execute(c);
    }

    class CToFTask extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtF.setText("");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtF.setText(s);
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                String c = strings[0];
                SoapObject request = new SoapObject(Configuration.NAME_SPACE, Configuration.METHOD_C_TO_F);
                request.addProperty(Configuration.PARAM_C_TO_F_CELSIUS, c);

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);

                HttpTransportSE httpTransportSE = new HttpTransportSE(Configuration.SERVER_URL);
                httpTransportSE.call(Configuration.SOAP_ACTION_C_TO_F, envelope);
                SoapPrimitive data = (SoapPrimitive) envelope.getResponse();
                return data.toString();
            } catch (Exception e) {
                Log.e("ERROR", e.toString());
            }
            return null;
        }
    }

    private void addControls() {
        txtC = findViewById(R.id.txtC);
        txtF = findViewById(R.id.txtF);
        btnSubmit = findViewById(R.id.btnSubmit);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Thông báo");
        progressDialog.setMessage("Đang xử lý...");
        progressDialog.setCanceledOnTouchOutside(false);
    }
}