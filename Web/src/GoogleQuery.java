import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import java.net.URLConnection;

import java.util.HashMap;
import java.util.PriorityQueue;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

public class GoogleQuery

{

	public String searchKeyword;

	public String url;

	public String content;

//	public PriorityQueue<WebNode> heap;

	public GoogleQuery(String searchKeyword) throws UnsupportedEncodingException

	{
		// �襤��r�i��ѽX encode for chinese charcters
		String message = java.net.URLEncoder.encode(searchKeyword,"utf-8");

		this.searchKeyword = message;
		this.url = "http://www.google.com/search?q=" + this.searchKeyword + "&oe=utf8&num=10";

	}

	private String fetchContent() throws IOException

	{
		String retVal = "";

		URL u = new URL(url);

		URLConnection conn = u.openConnection();

		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in, "utf-8");

		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while ((line = bufReader.readLine()) != null) {
			retVal += line;

		}
		return retVal;
	}

	public HashMap<String, String> query() throws IOException

	{

		if (content == null)

		{

			content = fetchContent();

		}

		HashMap<String, String> retVal = new HashMap<String, String>();

		Document doc = Jsoup.parse(content);
		//System.out.println(doc.text());
		Elements lis = doc.select("div");
		 //System.out.println(lis);
		lis = lis.select(".kCrYT");
		 //System.out.println(lis.size());

		for (Element li : lis) {
			try

			{
				String citeUrl = li.select("a").get(0).attr("href");
				String title = li.select("a").get(0).select(".vvjwJb").text();
				if (title.equals("")) {
					continue;
				}

				System.out.println(title + "," + citeUrl);
				System.out.println("-----------------------------");
				
				retVal.put(title, citeUrl); // key, value

			} catch (IndexOutOfBoundsException e) {

//				e.printStackTrace();

			}

		}

		return retVal;

	}

}