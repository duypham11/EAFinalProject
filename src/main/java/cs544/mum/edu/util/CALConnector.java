package cs544.mum.edu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.mum.edu.model.CommonResponseDTO;

public class CALConnector {

	private static final Logger logger = LogManager.getLogger(CALConnector.class);

	public static String callRest(String restURL, RequestMethod requestMethod, String serviceBody, String contentType) {
		String output = null;
		try {
			URL url = new URL(restURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(requestMethod.toString());
			if (StringUtils.isEmpty(contentType)) {
				conn.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON_VALUE);
			} else {
				conn.setRequestProperty("Content-Type", contentType);
			}

			logger.info("Connection Rest URL: " + restURL);
			logger.info("Service Body: " + serviceBody);
			System.out.println("............We are going to connect to " + restURL);
			System.out.println(".............Service body is " + serviceBody);
			if (!StringUtils.isEmpty(serviceBody)) {
				OutputStream os = conn.getOutputStream();
				os.write(serviceBody.getBytes());
				os.flush();
			}

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println(" in error ");
				Exception e = new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				e.printStackTrace();
				CommonResponseDTO commonResponseDTO = new CommonResponseDTO(-1, null,"Spmething went wrong..!");
				System.out.println(" commonResponseDTO :: " + commonResponseDTO);
				return JsonUtils.getJsonFromObject(commonResponseDTO);
				//throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			System.out.println("Output from Server .... \n");
			output = br.readLine();
			System.out.println(output);

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			CommonResponseDTO commonResponseDTO = new CommonResponseDTO(-1, null, e.getMessage());
			return JsonUtils.getJsonFromObject(commonResponseDTO);
		} catch (IOException e) {
			e.printStackTrace();
			CommonResponseDTO commonResponseDTO = new CommonResponseDTO(-1, null, e.getMessage());
			return JsonUtils.getJsonFromObject(commonResponseDTO);
		}
		return output;
	}
}
