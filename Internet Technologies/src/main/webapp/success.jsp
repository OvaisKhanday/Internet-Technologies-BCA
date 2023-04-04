<%@page  import="java.util.Map, java.util.HashMap" %>

<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="success.ico" type="image/x-icon" />
    <link rel="stylesheet" href="lib/styles/material_theme/colors.module.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/theme.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/theme.dark.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/theme.light.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/tokens.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/typography.module.css" />
    <link rel="stylesheet" href="lib/styles/styles.css" />
    
    <title>Success</title>
  </head>

  <body class="full-screen-output primary-container">
    <div class="container error-success-container">
      <img src="lib/assets/images/success.png" height="100" width="100" alt="success" class="error-success-icons success-icon" />
      <h1 class="error-success-title">Done</h1>
    <%
      Map<String, String> map = (Map<String, String>) request.getAttribute("success");
      switch (map.get("msg")) {
        case "record-added": 
    %>
            <h2>Student record added successfully</h2>
            <p><%=map.get("description")%></p>
    <%
        break;

        case "record-deleted":
    %>
            <h2>Student record(s) deleted successfully</h2>
            <p><%=map.get("description")%></p>
    <%
        break;

        case "record-updated":
    %>
            <h2>Students record updated successfully</h2>
            <p><%=map.get("description")%></p>
    <% 
        default:
  
        break;
      }
    %>
  
    </div>

  </body>
</html>
