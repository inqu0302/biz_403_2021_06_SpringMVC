package com.callor.book.service.impl.news;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.config.NaverQualifier;
import com.callor.book.config.NaverSecret;
import com.callor.book.model.NewsDTO;
import com.callor.book.service.NaverAbstractService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

@Service(NaverQualifier.NAVER_NEWS_SERVICE_V1)
public class NaverNewsServiceImplV1 extends NaverAbstractService<NewsDTO>{

	@Override
	public String queryURL(String search) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		String queryURL = NaverSecret.NURL.NEWS;
		queryURL += "?query=%s&display=10";
		
		String searchUTF = URLEncoder.encode(search, "UTF-8");
		
		queryURL = String.format(queryURL, searchUTF);
		
		return queryURL;
	}

	
	/*
	 * gSon을 사용하여 jsonString 을 List<MovieDTO>로 변환하기
	 */
	@Override
	public List<NewsDTO> getNaverList(String jsonString) throws ParseException {
		// TODO Auto-generated method stub
		
		JsonElement jsonElement = JsonParser.parseString(jsonString);
		
		JsonElement oItems = jsonElement.getAsJsonObject().get("items");
		
		Gson gson = new Gson();
		TypeToken<List<NewsDTO>> typeToken = new TypeToken<List<NewsDTO>>() {};
		
		List<NewsDTO> news = gson.fromJson(oItems, typeToken.getType());
		
		return news;
	}

}
