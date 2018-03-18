<%@page import="com.team.gs.beans.Branch"%>
<%@page import="com.team.gs.beans.College"%>
<%@page import="java.util.List"%>
<%
List<College> collegeList =(List<College>)request.getAttribute("collegeList"); 
List<Branch> branchList =(List<Branch>)request.getAttribute("branchList"); 
if(collegeList.size()!=0||branchList.size()!=0)
{
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Sign Up | Bootstrap Based Admin Template - Material Design</title>
    <!-- Favicon-->
    <link rel="icon" href="favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body class="signup-page">
    <div class="signup-box">
        <div class="logo">
            <a href="#">Grievance Redressal System</a>
           <!--  <small>Admin BootStrap Based - Material Design</small> -->
        </div>
        <div class="card">
            <div class="body">
                <form id="sign_up" action="RegisterStudentServlet" method="POST">
                    <div class="msg">Register a new membership</div>
                    
                     <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">Enrollment-ID</i>
                        </span>
                        <div class="form-line">
                            <input type="ID" class="form-control" name="Enrollment-ID" placeholder="Enrollment-ID" required>
                        </div>
                    </div>
                    <div class="input-group">
                <span class="input-group-addon">
                         <i class="material-icons">person</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="namesurname" placeholder="Name Surname" required autofocus>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">email</i>
                        </span>
                        <div class="form-line">
                            <input type="email" class="form-control" name="email" placeholder="Email Address" required>
                        </div>
                    </div>
                     <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">Contact</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="contactNo" placeholder="Contact No" required>
                        </div>
                    </div>
                      <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">Parent'sContact</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="s-control" name="parentcontactNO" placeholder="Parent's Contact No" required>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">Address</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="address"  placeholder="Enter Address" required>
                        </div>
                    </div>
             <!--        <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">CollegeId</i>
                        </span>
                        <div class="form-line">
                            <input type="number" class="form-control" name="collegeId"  placeholder="CollegeId" required>
                       
 
  </div>
                    </div> -->
                    
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">College</i>
                        </span>
                   <div class="row clearfix">
                                <div class="col-sm-12">
                                    <select name="college" class="form-control show-tick">
                                        <option value="">-- Please selectcollege --</option>
                                        <%for(College c:collegeList){%>
                                        <option value="<%=c.getId()%>"><%=c.getName()%></option>
                                       <%} %>
                                    </select>
                                </div>
                       </div>
                       </div>
               <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">Branch</i>
                        </span>
                   <div class="row clearfix">
                                <div class="col-sm-12">
                                    <select name="branch" class="form-control show-tick">
                                        <option value="">-- Please select Branch --</option>
                                        <%for(Branch c:branchList){%>
                                        <option value="<%=c.getId()%>"><%=c.getName()%></option>
                                       <%} %>
                                    </select>
                                </div>
                       </div>
                       </div>
                           <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">Password</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="Password"  placeholder="Enter Password" required>
                        </div>
                    </div>
            
                    <div class="form-group">
                        <input type="checkbox" name="terms" id="terms" class="filled-in chk-col-pink">
                        <label for="terms">I read and agree to the <a href="javascript:void(0);">terms of usage</a>.</label>
                    </div>

                    <button class="btn btn-block btn-lg bg-pink waves-effect" type="submit">SIGN UP</button>

                    <div class="m-t-25 m-b--5 align-center">
                        <a href="signin.jsp">You already have a membership?</a>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Jquery Core Js -->
    <script src="plugins/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="plugins/node-waves/waves.js"></script>

    <!-- Validation Plugin Js -->
    <script src="plugins/jquery-validation/jquery.validate.js"></script>

    <!-- Custom Js -->
    <script src="js/admin.js"></script>
    <script src="js/pages/examples/sign-up.js"></script>
</body>

</html>
<% }
else
{
	%>
	no data found
	<%
	}
%>
