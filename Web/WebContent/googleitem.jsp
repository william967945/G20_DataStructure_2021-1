<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CafeSearch</title>

<style type="text/css">
#padding{
	padding: 0px 0px 0px 15px;
}
a {
	color: #0B173B;
	font-size: 30px;
	text-decoration: none;
}
a:hover{
text-decoration:underline;
}
.border-style {
	
}
</style>
</head>
<body>
<body style='background-color:#EFEEEE'>
<form action='${requestUri}' method='get'>

	<div>
	<a href ='http://localhost:8080/Final_Project/TestProject'><img src="images/coffee10.png" style='position:absolute;width:935px;height:567px;left:16%;top:0%;
 	'></a>
 	</div>

	<div style='font-size:120%;position:absolute;
	margin-top:80px;margin-left:250px'>
	<p>We recommend you...</p>
	</div>
	
	  <div style='position: absolute;background-color:#EFEEEE ;margin-top:150px;margin-left:250px;width:400px;height:350px;overflow:scroll'>
	<div style='position: absolute;margin-top:10px;margin-left:50px'>
		<%
		String[][] orderList = (String[][]) request.getAttribute("query");
		for (int i = 5; i < orderList.length; i++) {
			String s=orderList[i][1]; // [0][1], [1][1] 
			 //start from 8
		%>
		
		<a href='<%=s%>'><%=orderList[i][0]%> </a> <br>-----------------------------------------------<br>
		
		<%
}
%>
	</div>
	</div>

	
	
	<div style='position: absolute;background-color:#EFEEEE ;margin-top:150px;margin-left:700px;width:400px;height:350px;overflow:scroll'>		
	</div>
	
	<div>
	<a href ='http://localhost:8080/Final_Project/TestProject'><img src="images/coffee5.png" style='position:absolute;width:70px;height:70px;left:50%;top:10%;margin-top:-47px;
	margin-left:-400px '></a>
	</div>
	
	<div>
	<input type='text' class="border-style" id="padding"  
	style='font-size:120%;position:absolute;left:50%;top:10%;
	margin-top:-30px;margin-left:-300px;width:500px;height:45px' name='keyword' placeholder='請輸入關鍵字'
	onfocus="placeholder= '' " onblur="placeholder='請輸入關鍵字'" />
	</div>
	
<div>
<input type='image' src="images/coffeeSearch.png" 
style='position:absolute;width:142px;height:45px;left:50%;top:10%;margin-top:-30px;
margin-left:230px '/>
</div>



</form>
</body>
</html>