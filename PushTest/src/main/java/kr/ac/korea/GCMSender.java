package kr.ac.korea;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by kjs on 2015-11-23.
 */
public class GCMSender {
    public static void main(String[] args){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://storm-korea.cloudsc.kr");
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();

            System.out.println("status code: " + statusCode);
            InputStream inputStream = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
