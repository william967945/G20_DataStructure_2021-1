
import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SubWebCatcher {
	private String urlStr;
    private String content;
    
    public SubWebCatcher(String urlStr){
    	this.urlStr = urlStr;
    }
    
    private String fetchContent() throws IOException{
    	this.urlStr = URLDecoder.decode(this.urlStr , "utf-8");
    	//this.urlStr = java.net.URLEncoder.encode(this.urlStr,"utf-8");

    	
    	URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
	
		String retVal = "";
	
		String line = null;
		
		while ((line = br.readLine()) != null){
			System.out.println(line);
		    retVal = retVal + line + "\n";
		}
		
		
		return retVal;
    }
    
//    public int countKeyword(String keyword) throws IOException{
//		if (content == null){
//		    content = fetchContent();//把html文件化
//		}
//		
//		//To do a case-insensitive search, we turn the whole content and keyword into upper-case:
//		content = content.toUpperCase();
//		keyword = keyword.toUpperCase();
//	
//		//hw
//		int retVal = 0;//找到個數
//		int fromIdx = 0;//從哪開始搜尋
//		int found = -1;//找到的位置
//	
//		while ((found = content.indexOf(keyword, fromIdx)) != -1){
//		   retVal++;
//		   fromIdx = found + keyword.length();
//		}
//	    //
//		
//		return retVal;
//    }
//    
    public HashMap<String, String> subquery() throws IOException

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
