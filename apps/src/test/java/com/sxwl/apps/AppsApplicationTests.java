package com.sxwl.apps;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


public class AppsApplicationTests {
	@Test
	public void  aa() {
		CloseableHttpClient httpclinet = HttpClients.createDefault();
		HttpGet httpGet=new HttpGet("https://www.baidu.com");
		CloseableHttpResponse response = null;
		try {
			 response = httpclinet.execute(httpGet);
			if(response.getStatusLine().getStatusCode()==200){
				String content = EntityUtils.toString(response.getEntity(), "utf-8");

				System.out.println(content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				httpclinet.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
