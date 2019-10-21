<%@page import="java.util.List"%>
<html>
<title>main page</title>
<body>

	<%
		
		
	List<String> list=(List<String>)request.getAttribute("errors");
	if(list!=null)
	{
		for(String str:list)
		{
			out.println("<font color='red'>"+str+"<br/>");
		}
		out.println("</font>");
	}
	
	
	%>
	<h2>index page</h2>
	<form action="controller.do" method="post">
		First Name<input type="text" name="fName"><br /> Last Name<input
			type="text" name="lName"><br /> Age<input type="text"
			name="age"><br /> Subject<select name="subject">
			<option value="Unknown">Select...</option>
			<option value="Physics">Physics</option>
			<option value="Bio Physics">Bio Physics</option>
			<option value="Bio Chemistry">Bio Chemistry</option>
			<option value="Applied Physics">Applied Physics</option>
		</select><br /> <input type="submit"><input type="reset">
	</form>
</body>
</html>
