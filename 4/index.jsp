<%@ page import="java.sql.*" %>
    
<html>
<body>
	<%
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet rs = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "nemo", "123").createStatement().executeQuery("SELECT * FROM employee");
	%>
	<%
		while (rs.next()) {
			String name = rs.getString("name");
			double sal = rs.getDouble("salary");
	%>
	<%= name %><span>: </span><%= sal %>
    <br />
	<%
		}
	%>
</body>
</html>
