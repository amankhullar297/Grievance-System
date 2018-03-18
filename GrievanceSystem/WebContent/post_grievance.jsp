<%@page import="com.team.gs.beans.GrievanceSubject"%>
<%@page import="java.util.List"%>
<%
List<GrievanceSubject> subjectList= (List<GrievanceSubject>)request.getAttribute("subjectList"); 
System.out.println("list of sub ----->>"+subjectList);
if(subjectList == null)
{
	RequestDispatcher rd = request.getRequestDispatcher("LoadPostGrievance");
	rd.forward(request, response);
	}
%>

<%@include file="include/header.jsp"%>
<%@include file="include/sidebar.jsp"%>

f<section class="content">
	<div class="container-fluid">
		<div class="block-header">
			<h2>POST YOUR GRIEVANCE HERE</h2>
		</div>

		<!-- Select -->
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<form action="PostGrievanceServlet" method="post"  enctype="multipart/form-data">
						<div class="body">
							<h2 class="card-inside-title">Select Your Grievance Category</h2>
							<div class="row clearfix">
								<div class="col-sm-12">
									<select name="subject" class="form-control show-tick" required>
										<option value="" >-- Please select --</option>
										<%for(GrievanceSubject gs : subjectList){ %>
										<option value="<%=gs.getId()%>"><%=gs.getName()%></option>
										
										<%} %>
										
									</select>
								</div>
							</div>
							<h2 class="card-inside-title">Report Your Grievance Here</h2>
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
							<button type="submit" class="btn btn-danger waves-effect">
								<i class="material-icons">trending_up</i> <span>SUBMIT
									GRIEVANCE</span>
							</button>

						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- #END# Textarea -->




	</div>
</section>
<%@include file="include/form_footer.jsp"%>