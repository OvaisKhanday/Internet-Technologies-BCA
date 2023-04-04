<%@page import="com.khanday.model.DBValues" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="lib/styles/styles.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/colors.module.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/theme.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/theme.dark.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/theme.light.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/tokens.css" />
    <link rel="stylesheet" href="lib/styles/material_theme/typography.module.css" />
    <title>Student Database</title>
  </head>
  <body>
    <!-- Heading -->
    <header class="container primary-container button-container" id="heading-container">
      <div class="container primary top-class-container">
        <h1 class="top-class-heading">HTML, Javascript, Servlet, JSP, JBean, and JDBC in a synergy</h1>
      </div>
      <p>
        The objective of this module is to tackle a practical issue by presenting a comprehensive coverage of nearly all the subjects related to
        "Internet Technologies" in a well-organized manner. By incorporating relevant examples within each concept and ensuring their coherence
        throughout the module, the comprehension of the topics becomes effortless. The foundation of this module rests upon the fundamental principles
        of HTML, Javascript, CSS(optional), Servlet, Jsp, JBeans, and JDBC. It is important to note that this module is intended solely for
        educational purposes, and any errors or difficulties are deeply regretted. The module is designed to provide future cohorts with an overview
        of "Internet Technologies." It is worth acknowledging that without the encouragement and guidance of my esteemed mentor and instructor, Ummar
        Muhammad, this module would not have been possible.
      </p>

      <a href="learn.html">
        <div class="container secondary learn-the-module">
          <h4>Learn the module</h4>
          <img class="icons" src="lib/assets/images/expand.svg" alt="next" id="next-icon" />
        </div>
      </a>
    </header>

    <!-- Insertion -->
    <div class="container insertion-container secondary-container">
      <h2>Insert a student record into the database</h2>
      <p>
        The purpose of this code block is to insert a record into the database. It is mandatory to fill in all the fields, and certain constraints
        have been applied. Specifically, the roll number must be limited to <b><%=DBValues.maxRollNoLength%></b> digits, while the name, address, and
        phone number must not exceed <b><%=DBValues.maxNameLength%></b>, <b><%=DBValues.maxAddressLength%></b>, and
        <b><%=DBValues.maxPhoneNoLength%></b> characters, respectively.
      </p>
      <img class="icons" src="lib/assets/images/add.svg" alt="" />
      <form name="addForm" action="add" method="post" onsubmit="return validateAddForm()">
        <input type="number" name="rollNo" min="1" max="999999999999999999" id="addRollNoInput" placeholder="roll no (e.g. 4818)" required /><br />
        <input type="text" name="name" id="addNameInput" placeholder="name (e.g. Ovais Ahmad Khanday)" required /><br />
        <input
          type="text"
          name="address"
          id="addAddressInput"
          placeholder="address (e.g. Aswara, Kanelwan, Bijbehara, Anantnag, JK)"
          required
        /><br />
        <input type="number" name="phoneNo" min="1" id="addPhoneNoInput" placeholder="phone no (10 digits e.g. 7006108237)" required /><br />
        <input class="button reset" type="reset" value="reset" />
        <span class="padding-only"></span>
        <input class="button submit" id="addSubmitInput" type="submit" value="submit" />
      </form>
    </div>

    <!-- Deletion -->
    <div class="container deletion-container secondary-container">
      <h2>Delete student(s) record(s) from the database</h2>
      <p>
        The purpose of this section is to eliminate student entries from the database based on user-provided parameters. The user can provide a single
        roll number to identify a specific student or a list of arguments to identify multiple students to be removed from the database.
      </p>
      <img class="icons" src="lib/assets/images/delete.svg" alt="" />
      <form name="deleteForm" action="delete" method="post" onsubmit="return validateDeleteForm()">
        <input type="number" name="rollNo" min="1" max="999999999999999999" id="deleteRollNoInput" placeholder="roll no (e.g. 4818)" /><br />
        <input type="text" name="name" id="deleteNameInput" placeholder="name (e.g. Ovais Ahmad Khanday)" /><br />
        <input type="text" name="address" id="deleteAddressInput" placeholder="address (e.g. Aswara, Kanelwan, Bijbehara, Anantnag, JK)" /><br />
        <input type="number" name="phoneNo" min="1" id="deletePhoneNoInput" placeholder="phone no (10 digits e.g. 7006108237)" /><br />
        <input class="button reset" type="reset" value="reset" />
        <span class="padding-only"></span>
        <input class="button submit" id="deleteSubmitInput" type="submit" value="submit" />
      </form>
    </div>

    <!-- Searching -->
    <div class="container searching-container secondary-container">
      <h2>Search student(s) record(s) from the database</h2>
      <p>
        There are various parameters on which students can be searched. For example, a search can be performed on a list of students based on their
        names or addresses. Alternatively, a single student can be found using their unique roll number. It is also possible to search for a list of
        students by providing multiple parameters, such as a list of students whose name is "some name" and address is "some address".
      </p>
      <img class="icons" src="lib/assets/images/search.svg" alt="" />
      <form name="searchForm" action="search" method="post" onsubmit="return validateSearchForm()">
        <input type="number" name="rollNo" min="1" max="999999999999999999" id="searchRollNoInput" placeholder="roll no (e.g. 4818)" /><br />
        <input type="text" name="name" id="searchNameInput" placeholder="name (e.g. Ovais Ahmad Khanday)" /><br />
        <input type="text" name="address" id="searchAddressInput" placeholder="address (e.g. Aswara, Kanelwan, Bijbehara, Anantnag, JK)" /><br />
        <input type="number" name="phoneNo" min="1" id="searchPhoneNoInput" placeholder="phone no (10 digits e.g. 7006108237)" /><br />
        <input class="button reset" type="reset" value="reset" />
        <span class="padding-only"></span>
        <input class="button submit" id="searchSubmitInput" type="submit" value="submit" />
      </form>
    </div>

    <!-- Updating -->
    <div class="container updating-container secondary-container">
      <h2>Update a student record in the database</h2>
      <p>
        To modify a student's record, please enter their current roll number. It is important to check whether the student is registered in the
        database before making any changes to their record. Therefore, it is advisable to confirm the existence of the student's record before
        proceeding with any modifications.
      </p>
      <img class="icons" src="lib/assets/images/update.svg" alt="" />
      <form name="updateForm" action="update" method="post" onsubmit="return validateUpdateForm()">
        <input
          type="number"
          name="existingRollNo"
          min="1"
          max="999999999999999999"
          id="ExistingRollNoInput"
          placeholder="existing roll no (e.g. 4818)"
          required
        /><br />
        <input type="number" name="rollNo" min="1" max="999999999999999999" id="updateRollNoInput" placeholder="new roll no (e.g. 4810)" /><br />
        <input type="text" name="name" id="updateNameInput" placeholder="new name (e.g. Ovais Khanday)" /><br />
        <input type="text" name="address" id="updateAddressInput" placeholder="new address (e.g. Aswara, Bijbehara, Anantnag, JK)" /><br />
        <input type="number" name="phoneNo" min="1" id="updatePhoneNoInput" placeholder="new phone no (10 digits e.g. 7006108237)" /><br />
        <input class="button reset" type="reset" value="reset" />
        <span class="padding-only"></span>
        <input class="button submit" id="updateSubmitInput" type="submit" value="submit" />
      </form>
    </div>

    <!-- Show all -->
    <div class="container show-all-container secondary-container">
      <h2>Display all the students registered in the database</h2>
      <p>
        Upon triggering this event, a new page will be launched that displays all the records associated with each student registered in the database.
      </p>

      <img class="icons" src="lib/assets/images/show-all.svg" alt="" />
      <form action="showAll" method="get">
        <input class="button show-all-button primary submit" id="showAllSubmitInput" type="submit" value="show all students" />
      </form>
    </div>

    <!-- Author -->
    <div class="container primary-container">
      <h3>Designed and Developed by <%=DBValues.author%></h3>
      <div class="container secondary-container author author-details-block">
        <p class="author-details">name = <%=DBValues.author%>;</p>
        <p class="author-details">batch = 2020;</p>
        <p class="author-details">stream = "BCA";</p>
        <p class="author-details">classRollNo = 4818;</p>
        <p class="author-details">semester = 5<sup>th</sup></p>
        <p class="author-details">date = 03/30/2023</p>
      </div>
      <div class="container author author-avatar">
        <img class="avatar" src="lib/assets/images/avatar.png" width="200" height="200" alt="avatar" />
      </div>
    </div>
  </body>
  <script type="text/javascript" src="lib/scripts/script.js" defer></script>
</html>
