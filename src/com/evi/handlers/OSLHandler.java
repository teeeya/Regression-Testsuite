package com.evi.handlers;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
/*
 * This class will execute all of the queries
 */
public class OSLHandler {
	private int timeOut;
	private String password, username, question, query;
	private HttpResponse response;
	public OSLHandler(String query, String username, String password,
			String question, Testcase test) {
		this.query = query;
		this.password = password;
		this.username = username;
		this.question = question;
		this.timeOut = test.getMaxTimeOut();
		String fullQuery = query + "question=" + question + "&api_account_id=" + username + "&api_password=" + password;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(fullQuery);
		try {
			test.startTimer();
			response = httpclient.execute(httpGet);
			test.endTimer();
			HttpEntity entity = response.getEntity();
			String responseString = EntityUtils.toString(entity, "UTF-8");
			test.setResponse(responseString);
			test.setResultReturnedInTime(test.workOutWhetherWithinTime());
		} catch (Exception e) {
			System.out
					.println("Error could not exercute test" + e.getMessage());
		} finally {
			httpGet.releaseConnection();
		}

	}

}
