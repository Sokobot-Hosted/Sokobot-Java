/**
 * 
 */
package info.sokobot.sokobot;

import java.io.IOException;

import com.google.gson.Gson;

import info.sokobot.sokobot.resources.User;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author jonah
 * 
 */
public class RequestUtil {

	protected String baseURL = "https://dashboard.sokobot.info/";
	protected String basePath = "api/";
	
	private final OkHttpClient client = new OkHttpClient();

	protected User getUser(String userId) {
		Request request = new Request.Builder()
				.url(baseURL+basePath+ "users/" + userId).addHeader("Authorization", Sokobot.getToken())
				.build();

		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
			
			Headers responseHeaders = response.headers();
			for (int i = 0; i < responseHeaders.size(); i++) {
				System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
			}
			String obj = response.body().string();
			Gson gson = new Gson();
			return gson.fromJson(obj, new User());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
