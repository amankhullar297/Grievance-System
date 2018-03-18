<%@page import="com.team.gs.beans.GrievanceChat"%>
<%@page import="java.util.List"%>
<%@page import="com.team.gs.beans.Grievance"%>
<% Grievance grievance=(Grievance)request.getAttribute("grievance"); 
List<GrievanceChat> list=(List<GrievanceChat>)request.getAttribute("list");

//System.out.println(grievance);
%>
<%@include file="include/header.jsp"%>
<%@include file="include/sidebar.jsp"%>

<section class="content">
	<div class="container-fluid">
		<div class="block-header">
			<h2>GRIEVANCE</h2>
		</div>

		<!-- Basic Alerts -->
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<div class="header">
						<h2>
							<%=grievance.getSubjectName()%>
						</h2>

					</div>
					
					
					<div class="body">

						<div class="row">
							<div class="col-sm-6 pull-right alert alert-success">
								<strong><%=grievance.getDescription() %></strong> 
							</div>
						</div>
																		<div class="row">
							<div class="col-sm-6 pull-left alert alert-success">
								<strong>Well done!</strong> You srtant alert message.
							</div>
						</div>

						<div class="alert alert-danger">
							<strong>Oh snap!</strong> Change a few things up and try
							submitting again
						</div>
						<form action="ChatServlet" method="post"  enctype="multipart/form-data">
						<input type="hidden" value=<%=grievance.getId()%> name="grievanceId">
						
							<h2 class="card-inside-title">Enter Your Reply</h2>
							<div class="form-group">
								<div class="form-line">
									<textarea required rows="1"
										class="form-control no-resize auto-growth"  name="description"
										placeholder="Please type what you want... And please don't forget the ENTER key press multiple times :)"></textarea>
								</div>
							</div>
							<h2 class="card-inside-title">Attach Your Files Here</h2>
							<div class="form-group">

								<!-- <button type="file" class="btn bg-blue waves-effect">
                                    <i class="material-icons">save</i>
                                    <span>ATTACH FILES</span>
                                </button> -->
								
									<input type="file" class="btn btn-primary" name="file">
					
								

							</div>
							<button  type="submit" class="btn btn-danger waves-effect">
								<i class="material-icons">trending_up</i> <span>Submit
									Reply</span>
							</button>

						</div>
					</form>

						

					</div>
				</div>
			</div>
		</div>
		<!-- #END# Basic Alerts -->



	</div>
</section>

<%@include file="include/footer.jsp"%>