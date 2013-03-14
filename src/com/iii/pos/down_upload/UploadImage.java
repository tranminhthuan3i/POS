package com.iii.pos.down_upload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;

import com.iii.pos.R;

public class UploadImage {
	InputStream inputStream;
	private String PICTURE_FOLDER = "Irocchi/Pictures/local/ICrop";
	Context mContext;
	String imageFileName = "";
	private String URLUPLOAD_IMG = "";

	public UploadImage(Context mcontext, String path) {
		this.mContext = mcontext;
		PICTURE_FOLDER = path;
		URLUPLOAD_IMG = mcontext.getResources().getString(
				R.string.UploadImage);
	}

	public void initial() {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		Bitmap bitmap = getBitmapImageLast();
		// Bitmap bitmap = BitmapFactory.decodeFile(�/sdcard/android.jpg�);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream); // compress to
																// which format
																// you want.
		byte[] byte_arr = stream.toByteArray();
		String image_str = Base64.encodeBytes(byte_arr);
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

		Log.d("THUAN-->", imageFileName);
		nameValuePairs.add(new BasicNameValuePair("image", image_str));
		nameValuePairs.add(new BasicNameValuePair("name", imageFileName));

		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(URLUPLOAD_IMG);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			HttpResponse response = httpclient.execute(httppost);
			String the_string_response = convertResponseToString(response);

		} catch (Exception e) {
			System.out.println("Error in http connection " + e.toString());
		}
	}

	public String convertResponseToString(HttpResponse response)
			throws IllegalStateException, IOException {

		String res = "";
		StringBuffer buffer = new StringBuffer();
		inputStream = (InputStream) response.getEntity().getContent();
		int contentLength = (int) response.getEntity().getContentLength(); // getting
																			// content
																			// length�..
		if (contentLength < 0) {
		} else {
			byte[] data = new byte[512];
			int len = 0;
			try {
				while (-1 != (len = inputStream.read(data))) {
					buffer.append(new String(data, 0, len)); // converting to
																// string and
																// appending to
																// stringbuffer�..
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				inputStream.close(); // closing the stream�..
			} catch (IOException e) {
				e.printStackTrace();
			}
			res = buffer.toString(); // converting stringbuffer to string�..

			// System.out.println("Response => " +
			// EntityUtils.toString(response.getEntity()));
		}
		return res;
	}

	// Return a Bitmap from folder
	private Bitmap getBitmapImageLast() {
		Bitmap bm1 = BitmapFactory.decodeResource(mContext.getResources(),
				R.drawable.ic_launcher);
		try {
			String filepath = Environment.getExternalStorageDirectory()
					.getPath();
			File file = new File(filepath, PICTURE_FOLDER);
			if (!file.exists()) {
				file.mkdirs();
			}
			File[] sdDirList = file.listFiles();
			// Temp

			Log.i("Log : ", "UploadImage Length : " + sdDirList.length);

			if (sdDirList.length > 0) {

				String str = filepath + "/" + PICTURE_FOLDER + "/"// temp
						+ sdDirList[sdDirList.length - 1].getName();
				imageFileName = sdDirList[sdDirList.length - 1].getName();
				bm1 = BitmapFactory.decodeFile(str);
			} else {
			}
		} catch (Exception e) {

		}
		return bm1;
	}
}
