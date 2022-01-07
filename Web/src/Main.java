
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class Main {




	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		//root node
		WebPage rootPage = new WebPage("https://klrosie12.pixnet.net/blog/post/464370284-%25E7%25B2%25BE%25E9%2581%25B8%25E5%258F%25B0%25E5%258C%259725%25E9%2596%2593%25E5%25BF%2585%25E5%258E%25BB%25E7%25BE%258E%25E5%25A5%25BD%25E5%2592%2596%25E5%2595%25A1%25E5%25BB%25B3%25E3%2580%2581%25E6%2597%25A9%25E5%258D%2588%25E9%25A4%2590%25E3%2580%2581%25E4%25B8%258B%25E5%258D%2588&sa=U&ved=2ahUKEwjxtZqdiZ_1AhWiyosBHeRED-QQFnoECAMQAg&usg=AOvVaw0aSMbWjkEQuIIztZM6FikM", "精選台北25間必去美好咖啡廳、早午餐、下午茶網美餐廳、不限時");		
		WebTree tree = new WebTree(rootPage);
		//build childnode
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Publications.html","Publication")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Projects.html","Projects")));
		tree.root.children.get(1).addChild(new WebNode(new WebPage("https://vlab.cs.ucsb.edu/stranger/", "Stranger")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Members.html", "MEMBER")));
		tree.root.addChild(new WebNode(new WebPage("http://www3.nccu.edu.tw/~yuf/course.htm","Course")));
		
		
		
		File file = new File("input.txt");
		Scanner scanner = new Scanner(file);
		
		
		//read 2 Yu 1.2 Fang 1.8 
		//Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextLine()){
			int numOfKeywords = scanner.nextInt();//2
			ArrayList<Keyword> keywords = new ArrayList<Keyword>();
			
			for(int i =0;i<numOfKeywords;i++)
			{
				String s = scanner.next();//Yu
				
				// encoding for Chinese characters
				String name = new String(s.getBytes("GBK"),"UTF-8");
				
				double weight = scanner.nextDouble();//1.2
				Keyword k = new Keyword(name, weight);//store key
				keywords.add(k);
			}
			
			tree.setPostOrderScore(keywords);
			tree.eularPrintTree();
		}
		scanner.close();
	}
	
	static {
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() 
		{
			public boolean verify(String hostname,SSLSession session) 
			{
				return true;
			}
		});
	}
	

}

//static {
//	HttpsURLConnection.setDefaultHostnameVerifier((hostname,session) -> hostname.equals("127.0.0.1"));
//}	


/*
 * 
Input:
2
Fang 0.5
Yu 0.6

Output:

(Fang Yu,131.10000000000002
	(Publication,110.5)
	(Project,12.1
		(Stranger,0.0)
	)
	(Biography,2.8
		(Vlab,0.0)
	)
	(Course,2.3)
)

*/
