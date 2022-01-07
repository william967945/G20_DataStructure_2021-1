
// startNode.webPage.name+","+startNode.nodeScore
public class Result {
	public String name;
	public double nodeScore;
	
	public Result(String name,double nodeScore){
		this.name = name;
		this.nodeScore = nodeScore;
	}
	
	@Override
	public String toString(){
		return "["+name+","+nodeScore+"]";
	}
}

