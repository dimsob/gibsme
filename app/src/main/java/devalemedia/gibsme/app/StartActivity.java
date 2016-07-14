package devalemedia.gibsme.app;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.os.AsyncTask;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class StartActivity extends AppCompatActivity {
    private Toolbar toolbar;
    public EditText inputName, inputPassword;
    private TextInputLayout inputLayoutName, inputLayoutPassword;
    private Button btnSignUp;
    private ProgressBar progressBar;
    private ProgressDialog progressDialog;
    private enterHttpPost mTask = null;
    String user_name, user_password;
    DialogFragment dlg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);

        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        inputName = (EditText) findViewById(R.id.input_name);
        inputPassword = (EditText) findViewById(R.id.input_password);
        btnSignUp = (Button) findViewById(R.id.btn_signup);

        inputName.addTextChangedListener(new MyTextWatcher(inputName));

        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateName()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }
        user_name = inputName.getText().toString();
        user_password = inputPassword.getText().toString();
        String csMobile = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager cmMobile = (ConnectivityManager) getSystemService(csMobile);
        cmMobile.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        String csWifi = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager cmWifi = (ConnectivityManager) getSystemService(csWifi);
        cmWifi.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (cmMobile.getActiveNetworkInfo() == null
                || cmWifi.getActiveNetworkInfo() == null) {
            Toast.makeText(
                    StartActivity.this,
                    "Отсутствует подключение к интернету. Проверьте настройки",
                    Toast.LENGTH_LONG).show();
        } else {
            new enterHttpPost().execute();
        }
        this.progressDialog = new ProgressDialog(StartActivity.this);
        this.progressDialog.setMessage("Вход...");
        this.progressDialog.show();

    }


    public class enterHttpPost extends AsyncTask<String, Void, Void> {

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(StartActivity.this.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        String res = null;
        String comment = null;
        String descErr = null;
        String username = null;
        String acc = null;
        String amount = null;
        String email = null;
        String fio = null;
        String completed_orders = null;
        String placed_orders = null;
        String completed_rating = null;
        String placed_rating = null;
        String bio = null;
        String versionName = BuildConfig.VERSION_NAME;

        @Override
        protected Void doInBackground(String... params) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(
                    "http:/10.0.3.2/maxo/xmlInterface.php");

            try {

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
                        2);
                nameValuePairs.add(new BasicNameValuePair("login",
                        user_name));
                nameValuePairs.add(new BasicNameValuePair("password", user_password));
                nameValuePairs.add(new BasicNameValuePair("command",
                        "auth"));
                nameValuePairs.add(new BasicNameValuePair("version_code",
                        "versionName"));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                HttpResponse response = httpclient.execute(httppost);
                String responseStr = EntityUtils.toString(response.getEntity());

                res = (String) getXPathValue("//" + "result", responseStr,
                        XPathConstants.STRING);
                comment = (String) getXPathValue("//" + "comment", responseStr,
                        XPathConstants.STRING);
                if (res.equals("false")) {
                    Log.d("StartAct", comment);
                    // DialogCall();
                    dlg1.show(getFragmentManager(), "dlg1");

                } else if (res.equals("true")) {

                    fio = (String) getXPathValue("//" + "name",
                            responseStr, XPathConstants.STRING);
                    completed_orders = (String) getXPathValue("//" + "completed_orders",
                            responseStr, XPathConstants.STRING);
                    placed_orders = (String) getXPathValue("//" + "placed_orders",
                            responseStr, XPathConstants.STRING);
                    completed_rating = (String) getXPathValue("//" + "completed_rating",
                            responseStr, XPathConstants.STRING);
                    placed_rating = (String) getXPathValue("//" + "placed_rating",
                            responseStr, XPathConstants.STRING);
                    bio = (String) getXPathValue("//" + "bio",
                            responseStr, XPathConstants.STRING);

                    User us = new User(user_name,
                            user_name, user_password, completed_orders,
                            placed_orders, completed_rating, placed_rating, null);


                    Log.d("StartAct", "Inserting ..");
                    GibsDatabase db = new GibsDatabase(StartActivity.this);
                    db.userAdd(us);

                    Intent i = new Intent(StartActivity.this,
                            MainActivity.class);
                    startActivity(i);
                    finish();
                }

            } catch (ClientProtocolException e) {

            } catch (IOException e) {

            }

            return null;
        }

    }

    private Object getXPathValue(String xPathQuery, String xml, QName type) {
        Object result = null;
        StringReader stringReader = new StringReader(xml);
        InputSource inputSource = new InputSource(stringReader);
        DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = dbfact.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
        Document doc = null;
        try {
            doc = builder.parse(inputSource);
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        try {
            result = xpath.evaluate(xPathQuery, doc, type);
        } catch (XPathExpressionException ex) {
            ex.printStackTrace();
        }
        return result;
    }


    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError("Введите номер телефоа");
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError("Введите пароль");
            requestFocus(inputPassword);
            return false;

        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    break;

                case R.id.input_password:
                    validatePassword();
                    break;
            }
        }
    }
}
