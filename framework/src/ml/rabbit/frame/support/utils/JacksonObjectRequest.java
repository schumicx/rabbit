package ml.rabbit.frame.support.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.json.JSONObject;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonObjectRequest<T> extends JsonRequest<T> {

	private static ObjectMapper objectMapper;
	private final Class<T> mClass;

	private final static ObjectMapper getMapper() {
		if (objectMapper == null) {
			return new ObjectMapper();
		} else {
			return objectMapper;
		}
	}

	public JacksonObjectRequest(int method, String url, Class<T> clazz,
			JSONObject jsonRequest, Listener<T> listener,
			ErrorListener errorListener) {
		super(method, url, (jsonRequest == null) ? null : jsonRequest
				.toString(), listener, errorListener);
		objectMapper = getMapper();
		mClass = clazz;
	}

	public JacksonObjectRequest(String url, Class<T> clazz,
			JSONObject jsonRequest, Listener<T> listener,
			ErrorListener errorListener) {
		this(jsonRequest == null ? Method.GET : Method.POST, url, clazz,
				jsonRequest, listener, errorListener);
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			String jsonString = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers));
			return Response.success(objectMapper.readValue(jsonString, mClass),
					HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e0) {
			return Response.error(new ParseError(e0));
		} catch (JsonParseException e1) {
			return Response.error(new ParseError(e1));
		} catch (JsonMappingException e2) {
			return Response.error(new ParseError(e2));
		} catch (IOException e3) {
			return Response.error(new ParseError(e3));
		}
	}
}
