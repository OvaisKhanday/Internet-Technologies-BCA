<%@page  import="java.util.Map, java.util.HashMap" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="error.ico" type="image/x-icon" />
    <link rel="stylesheet" href="lib/styles/material_theme/colors.module.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/theme.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/theme.dark.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/theme.light.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/tokens.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/typography.module.css" />
    <link rel="stylesheet" href="lib/styles/styles.css" />
    
    <title>Error</title>
  </head>
  <body class="full-screen-output error-container">
    <div class="container error-success-container">
      <img src="lib/assets/images/error.png" height="100" width="100" alt="error" class="error-success-icons error-icon" />
      <h1 class="error-success-title">Error</h1>
    <%
      Map<String, String> map = (Map<String, String>) request.getAttribute("error");
      switch (map.get("msg")) {
        case "wrong-parameters": 
        %>
            <h2>Wrong Parameters provided by user</h2>
            <p><%=map.get("description")%></p>
        <%
        break;

        case "no-connection-to-db":
        %>
            <h2>Connection Failed</h2>
            <p><%=map.get("description")%></p>
        <%
        break;

        case "no-execution":
        %>
            <h2>Execution Failed</h2>
            <p><%=map.get("description")%></p>
        <%
        break;

        case "record-not-added":
        %>
            <h2>Unexptected Error</h2>
            <p><%=map.get("description")%></p>
        <%
        break;

        case "record-already-exists":
        %>
            <h2>Record already exists</h2>
            <p><%=map.get("description")%></p>
        <%
        break;

        case "record-not-found-to-delete":
        %>
          <h2>Record(s) not deleted</h2>
          <p><%=map.get("description")%></p>
        <%
        break;

        case "record-not-found-to-update":
        %>
            <h2>Record not updated</h2>
            <p><%=map.get("description")%></p>
        <%
        break;

        default:
        break;
      }
    %>
    </div>

  </body>
</html>
