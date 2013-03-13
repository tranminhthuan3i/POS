package com.iii.pos.config;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class ConfigurationWS {

	int TIMEOUT_MILLISEC = 10000;
	Context context;
	
	public ConfigurationWS(Context context) {
		this.context = context;
	}

	public JSONArray connectWSPut_Get_Data(String url, JSONObject json, String jsonName) {
		JSONArray jarr = null;
		try {

			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams,
					TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpClient client = new DefaultHttpClient(httpParams);

			HttpPost request = new HttpPost(url);
			request.setEntity(new ByteArrayEntity(json.toString().getBytes(
					"UTF8")));
			request.setHeader("json", json.toString());
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();

			InputStream instream = entity.getContent();

			String result = ConfigurationWSRestClient
					.convertStreamToString(instream);
			JSONObject jobj = new JSONObject(result);
			jarr = jobj.getJSONArray(jsonName);

		} catch (Throwable t) {
			/*Toast.makeText(context, "Request failed: " + t.toString(),
					Toast.LENGTH_LONG).show();*/
			Log.i("Log : ", "-------- "+t.getMessage());
		}
		return jarr;
	}

	public JSONArray connectWS_Get_Data(String url, String jsonName) {
		JSONArray jarr = null;
		try {

			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams,
					TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpClient client = new DefaultHttpClient(httpParams);

			HttpPost request = new HttpPost(url);
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();

			InputStream instream = entity.getContent();

			String result = ConfigurationWSRestClient
					.convertStreamToString(instream);
			JSONObject jobj = new JSONObject(result);
			jarr = jobj.getJSONArray(jsonName);

		} catch (Throwable t) {
			Log.i(getClass().getName(), t.getMessage());
		}
		return jarr;
	}

	public void connectWS_Put_Data(String url, JSONObject json) {
		try {
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams,
					TIMEOUT_MILLISEC);
			HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);
			HttpClient client = new DefaultHttpClient(httpParams);
			HttpPost request = new HttpPost(url);
			request.setEntity(new ByteArrayEntity(json.toString().getBytes(
					"UTF8")));
			request.setHeader("json", json.toString());
			client.execute(request);

		} catch (Throwable t) {
			Log.i(getClass().getName(), t.getMessage());
		}
	}
}
