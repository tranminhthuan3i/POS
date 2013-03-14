package com.iii.pos.down_upload;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;

import com.iii.pos.R;

public class UploadAudioPos {

	private static final int SELECT_AUDIO = 2;
	String selectedPath = "";
	private static final String AUDIO_RECORDER_FOLDER1 = "Irocchi/Audios/local";
	private Context mContext = null;

	public UploadAudioPos(Context mcontext) {
		this.mContext = mcontext;
	}

	public void uploadAudio() {
		// lets doing the main thread
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		// III 79 insert to SQlite

		// Upload to server (Audio)
		doFileUpload();
	}

	public String getFileName() {
		String str = "";
		String filepath = Environment.getExternalStorageDirectory().getPath();
		File file = new File(filepath, AUDIO_RECORDER_FOLDER1);
		if (!file.exists()) {
			file.mkdirs();
		}
		File[] sdDirList = file.listFiles();
		// Temp

		if (sdDirList != null) {
			// get lastest file name of audio
			str = filepath + "/" + AUDIO_RECORDER_FOLDER1 + "/"// temp
					+ sdDirList[sdDirList.length - 1].getName();
		}
		return str;
	}

	private void doFileUpload() {

		HttpURLConnection conn = null;
		DataOutputStream dos = null;
		DataInputStream inStream = null;
		String existingFileName = getFileName();// get file name lastest
												// recording

		String lineEnd = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		int bytesRead, bytesAvailable, bufferSize;
		byte[] buffer;
		int maxBufferSize = 1 * 1024 * 1024;
		String responseFromServer = "";

		String urlString = mContext.getResources().getString(
				R.string.UploadAuDio);

		Log.i("Log : ", "urlString  : " + urlString);

		try {
			// ------------------ CLIENT REQUEST
			FileInputStream fileInputStream = new FileInputStream(new File(
					existingFileName));
			// open a URL connection to the Servlet
			URL url = new URL(urlString);
			// Open a HTTP connection to the URL
			conn = (HttpURLConnection) url.openConnection();
			// Allow Inputs
			conn.setDoInput(true);
			// Allow Outputs
			conn.setDoOutput(true);
			// Don't use a cached copy.
			conn.setUseCaches(false);
			// Use a post method.
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);

			dos = new DataOutputStream(conn.getOutputStream());
			dos.writeBytes(twoHyphens + boundary + lineEnd);

			dos.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\""
					+ existingFileName + "\"" + lineEnd);

			dos.writeBytes(lineEnd);
			// create a buffer of maximum size
			bytesAvailable = fileInputStream.available();
			bufferSize = Math.min(bytesAvailable, maxBufferSize);
			buffer = new byte[bufferSize];
			// read file and write it into form...
			bytesRead = fileInputStream.read(buffer, 0, bufferSize);
			while (bytesRead > 0) {
				dos.write(buffer, 0, bufferSize);
				bytesAvailable = fileInputStream.available();
				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				bytesRead = fileInputStream.read(buffer, 0, bufferSize);
			}
			// send multipart form data necesssary after file data...
			dos.writeBytes(lineEnd);
			dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
			// close streams
			Log.e("Log : ", "File is written");
			fileInputStream.close();
			dos.flush();
			dos.close();
		} catch (MalformedURLException ex) {
			Log.e("Log : ", "error: " + ex.getMessage(), ex);
		} catch (IOException ioe) {
			Log.e("Log : ", "error: " + ioe.getMessage(), ioe);
		}
		// ------------------ read the SERVER RESPONSE
		try {
			inStream = new DataInputStream(conn.getInputStream());
			String str;

			while ((str = inStream.readLine()) != null) {
				Log.e("Log : ", "Server Response " + str);
			}
			inStream.close();
			// passing to next activity

		} catch (IOException ioex) {
			Log.e("Log : ", "error: " + ioex.getMessage(), ioex);
		}
	}

}
