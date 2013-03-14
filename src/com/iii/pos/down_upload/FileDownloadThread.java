package com.iii.pos.down_upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.util.Log;

//public class FileDownloadThread extends Thread{
public class FileDownloadThread extends Thread{
	
	private String downloadURL;
	private static final int DOWNLOAD_BUFFER_SIZE = 1024;
	
	private String path;
	
	public FileDownloadThread(String url, String path) {
		this.downloadURL = url;
		this.path = path;
		
		run();
	}
	
	@Override
	public void run() {
	
		URL url;
		URLConnection connectURL;
		int lastShash;
		String fimeName;
		BufferedInputStream inStream;
		BufferedOutputStream outStream;
		File outFile;
		FileOutputStream fileStream;
		
		try {
				url = new URL(downloadURL);
				connectURL = url.openConnection();
				connectURL.setUseCaches(false);
				connectURL.connect();
				
				lastShash = url.toString().lastIndexOf('/');
				fimeName = "";
				if(lastShash >= 0){
					fimeName = url.toString().substring(lastShash + 1 );
				}
				if(fimeName.equals("")){
					fimeName = "file.bin";
				}
				
				outFile = new File(path+"/"+fimeName);
				inStream = new BufferedInputStream(url.openStream());
				fileStream = new FileOutputStream(outFile);
				outStream = new BufferedOutputStream(fileStream, DOWNLOAD_BUFFER_SIZE);
				byte [] arrayBytes = new byte[DOWNLOAD_BUFFER_SIZE];
				int readByteSize = 0;
				int status = 0;
				
					while ((readByteSize = (inStream.read(arrayBytes, 0, arrayBytes.length)))>=0) {
						
							if(!interrupted()){
								outStream.write(arrayBytes, 0, readByteSize);
								status = 0;
							}else {
								status = 1;
							}
					} if(status == 1) {
						outFile.delete();
					}

				outStream.close();
				fileStream.close();
				inStream.close();
			
		}catch (MalformedURLException e) {
			Log.i(getClass().getName(), e.toString());
		} catch (IOException e) {
			Log.i(getClass().getName(), e.toString());
		} catch (Exception e) {
			Log.i(getClass().getName(), e.toString());
		}
		super.run();

	};
		
}
