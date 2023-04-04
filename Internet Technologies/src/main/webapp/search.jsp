<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!--        1. directive tag-->
<%@page  import="java.util.ArrayList, com.khanday.model.Student" %>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="search.ico" type="image/x-icon" />
    <link rel="stylesheet" href="lib/styles/material_theme/colors.module.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/theme.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/theme.dark.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/theme.light.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/tokens.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/typography.module.css" />
    <link rel="stylesheet" href="lib/styles/styles.css" />
    <title>Students</title>
  </head>
  <body>

    <div class="container primary-container">
      <h1>student database records</h1>
      <p>All records, stored in the database, are shown in the ascending order of roll no.</p>
      <div class="container tertiary-container generated-sql-container">
      <p><b><%=request.getAttribute("sql").toString()%></b></p>
    </div>
    </div>


    <%
      ArrayList<Student> studentsList = (ArrayList<Student>)request.getAttribute("list");
    %>


    <div class="container secondary-container">
      <table class="student-table">
        <thead>
        <tr>
          <th>Roll No</th>
          <th>Name</th>
          <th>Address</th>
          <th>Phone No</th>
        </tr>
        </thead>
        </tbody>

        <% 
          for(Student student : studentsList){
        %>

          <tr>
            <td><%=student.getRollNo()%></td>
            <td><%=student.getName()%></td>
            <td><%=student.getAddress()%></td>
            <td><%=student.getPhoneNo()%></td>
          </tr>
          
        <%}%>

        </tbody>
      </table>
    </div>
  </body>
  <script type="text/javascript" src="lib/scripts/script.js" defer></script>
</html>
