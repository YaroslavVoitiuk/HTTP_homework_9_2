package ru.netology;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class App {

    public static final String SITE_URL = "https://api.nasa.gov/planetary/apod?api_key=mFSakV7dwbavJdMME2tMLZRuKxhmu8VRH5zZlg1C";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main( String[] args ) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                    .setConnectTimeout(5000)
                    .setSocketTimeout(30000)
                    .setRedirectsEnabled(false)
                    .build())
                .build();

        HttpGet request = new HttpGet(SITE_URL);
        CloseableHttpResponse response = httpClient.execute(request);
        NASAData data = mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {});
        System.out.println(data);

        try(InputStream in = new URL(data.getUrl()).openStream()){
            Files.copy(in, Paths.get("perseid_iss_1080.jpg"));
        } catch (FileAlreadyExistsException e){
            System.out.println("Файл уже существует!");
        }
    }
}
