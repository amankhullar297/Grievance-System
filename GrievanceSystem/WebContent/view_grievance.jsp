<%@page import="com.team.gs.util.DateConversionUtil"%>
<%@page import="com.team.gs.beans.User"%>
<%@page import="java.util.List"%>
<%@page import="com.team.gs.beans.Grievance"%>
<%
List<Grievance> grievanceList=(List<Grievance>)request.getAttribute("grievanceList");
User loginUser=(User)request.getAttribute("loginUser");
System.out.println("List is"+grievanceList);
if(grievanceList==null)
{
	
	
	RequestDispatcher rd = request.getRequestDispatcher("ViewGrievanceServlet");
	rd.forward(request ,response); 
}else
{
%>
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
                                    <%if(loginUser.getRole()=='a'){  %>
                                    
                                        <tr>
                                            <th>Subject</th>
                                            <th>College ID</th>
                                            <th>Student ID</th>
                                            <th>Date</th>
                                            <th>Description</th>
                                            <th>Attachment</th>
                                            <th>Reply</th>
                                        </tr>
                                    </thead>
                                    
                                        <%for(Grievance g:grievanceList)
                                        	{
                                        	%>
                                        	
                                    <tbody>
                                        <tr>   	  		          
                                            <td><%=g.getSubjectName() %></th>
                                            <td><%=g.getCollegeId() %></th>
                                            <td><%=g.getStudentId() %></th>
                                            <td><%=DateConversionUtil.longTodate(g.getDate()) %>   </th>
                                              <td><%=g.getDescription() %>   </th>
                                            <td><%=g.getFile() %>  </th>
                                            <%System.out.println(g.getId()); %>
                                        
                                         <td><a href="GrievanceChatServlet?grievanceId=<%=g.getId()%>&studentId=<%=g.getStudentId() %>"><button  class="btn btn-success waves-effect">
								<i class="material-icons">trending_up</i> <span> Reply
								</span>
							</button>   </a>
							</tr>
                                        </tbody>>
                                    
                                    <%} %>
                                    <tfoot>
                                        <tr>
                                            <th>Subject</th>
                                            <th>College ID</th>
                                            <th>Student ID</th>
                                            <th>Date</th>
                                            <th>Description</th>
                                            <th>Attachment</th>
                                            <th>Reply</th>
                                        </tr>
                                    </tfoot>
                                                                   </table>
                                                                   <%} else {%>
                                                                   
                                                                   <tr>
                                            <th>Date</th>
                                            <th>Subject</th>
                                            <th>Status</th>
                                            <th>Description</th>
                                              <th>Reply</th>
                                           
                                        </tr>
                                    </thead>
                                    
                                        <%for(Grievance g:grievanceList)
                                        	{
                                        	%>
                                        	
                                    <tbody>
                                        <tr>   	  		          
                                            <td><%=DateConversionUtil.longTodate(g.getDate())  %></th>
                                            <td><%=g.getSubjectName()%></th>
                                            <td><%=g.getStatus() %></th>
                                            <td><%=g.getDescription() %>   </th>
                                           <td><a href="StudentChatServlet?grievanceId=<%=g.getId()%>"><button  class="btn btn-success waves-effect">
								<i class="material-icons">trending_up</i> <span> Reply
								</span>
							</button>   </a>
                                             
                                        </tbody>>
                                    
                                    <%} %>
                                    <tfoot>
                                        <tr>
                                            <th>Date</th>
                                            <th>Subject</th>
                                            <th>Status</th>
                                            <th>Description</th>
                                              <th>Reply</th>
                                        </tr>
                                    </tfoot>
                                                                   </table>
                                                                   <%} %>
                  
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# Basic Examples -->
            
        </div>
    </section>


<%@include file="include/table_footer.jsp"%>
<%}  %>