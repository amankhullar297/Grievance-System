<%@page import="com.team.gs.beans.Student"%>
<%@page import="java.util.List"%>
<%@include file="include/header.jsp"%>
<%@include file="include/sidebar.jsp"%>

<section class="content">
        <div class="container-fluid">
            <div class="block-header">
                <h2>
                    VIEW GRIEVANCES
                </h2>
            </div>
            <!-- Basic Examples -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                       
                        <div class="body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                    <thead>
                                    <tr>
                                            <th>Enrollment No</th>
                                            <th>Name</th>
                                            <th>email</th>
                                            <th>Branch</th>
                                            <th>Address</th>
                                            <th>verify</th>
                                            <th>delete</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Enrollment No</th>
                                            <th>Name</th>
                                            <th>email</th>
                                            <th>Branch</th>
                                            <th>Address</th>
                                            <th>verify</th>
                                            <th>delete</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                   <% List<Student> studentList=(List<Student>)request.getAttribute("studentList");
                                   for(Student s:studentList){ 
                                	   
                                    %> 
                                        <tr>
                                            <td><%=s.getEnrollmentId() %></td>
                                            <td><%=s.getName() %></td>
                                            <td><%=s.getEmail() %></td>
                                            <td><%=s.getBranchId() %></td>
                                            <td><%=s.getAddress() %></td>
                                       <td><a href="VerifyUnverifyServlet?email=<%=s.getEmail()%>&status=u"><button  class="btn btn-success waves-effect">
								<i class="material-icons">trending_up</i> <span>verfiy
								</span>
							</button>

                                       </td>
                                       <td><a href="VerifyUnverifyServlet?email=<%=s.getEmail()%>&status=d"><button  class="btn btn-danger waves-effect">
								<i class="material-icons">trending_up</i> <span>Delete
								</span>
							</button>

                                       </td>
                                       
                                        
                                        </tr>
                                        <%} %>                                  </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# Basic Examples -->
            
        </div>
    </section>


<%@include file="include/table_footer.jsp"%>