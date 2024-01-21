package example.com.vn.ksoapapi_objecttype;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import example.com.vn.config.Configuration;
import example.com.vn.model.Contact;

public class MainActivity extends AppCompatActivity {

    EditText txtSearchId;
    TextView txtId, txtName, txtPhone;
    Button btnGet;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGetDetails();
            }
        });
    }

    private void handleGetDetails() {
        String searchId = txtSearchId.getText().toString().trim();
        if (searchId.equals("")) {
            Toast.makeText(this,
                    "Nhập mã", Toast.LENGTH_SHORT).show();
        } else {
            int id = Integer.parseInt(searchId);
            ContactTask task = new ContactTask();
            task.execute(id);
        }
    }

    class ContactTask extends AsyncTask<Integer, Void, Contact> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtId.setText("");
            txtName.setText("");
            txtPhone.setText("");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Contact contact) {
            super.onPostExecute(contact);
            txtSearchId.setText("");
            txtId.setText(String.valueOf(contact.getId()));
            txtName.setText(contact.getName());
            txtPhone.setText(contact.getPhone());
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Contact doInBackground(Integer... integers) {
            try {
                int id = integers[0];
                SoapObject request = new SoapObject(Configuration.NAME_SPACE, Configuration.METHOD_GET_DETAIL);
                request.addProperty(Configuration.PARAM_DETAIL_ID, id);

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);

                HttpTransportSE httpTransportSE = new HttpTransportSE(Configuration.SERVER_URL);
                httpTransportSE.call(Configuration.SOAP_ACTION_GET_DETAIL, envelope);

                SoapObject data = (SoapObject) envelope.getResponse();
                Contact contact = new Contact();
                if (data.hasProperty("Id")) {
                    contact.setId(Integer.parseInt(data.getPropertyAsString("Id")));
                }
                if (data.hasProperty("Name")) {
                    contact.setName(data.getPropertyAsString("Name"));
                }
                if (data.hasProperty("Phone")) {
                    contact.setPhone(data.getPropertyAsString("Phone"));
                }
                return contact;
            } catch (Exception e) {
                Log.e("ERROR", e.toString());
            }
            return null;
        }
    }

    private void addControls() {
        txtSearchId = findViewById(R.id.txtSearchId);
        txtId = findViewById(R.id.txtId);
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        btnGet = findViewById(R.id.btnGet);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Thông báo");
        progressDialog.setCanceledOnTouchOutside(false);
    }
}