<%-- 
    Document   : ViewJob
    Created on : Jun 20, 2023, 9:44:46 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.esmizdream.futurejobs.job.servlet.JobBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" %>
<jsp:include page="/WEB-INF/fragments/dashbord.jsp" />

<div class="content-wrapper" style="min-height: 600.4px;">
    <div class="card mx-auto" style="width: 90%">
        <div class="card-header">
            <h3 class="card-title">Open Vacancy</h3><br><br>

            <div class="card-tools">
                <div class="input-group input-group-sm" style="width: 250px;">
                    <input type="text" name="table_search"
                           class="form-control float-right" placeholder="Search">

                    <div class="input-group-append">
                        <button type="submit" class="btn btn-default">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </div>
            </div>

            <a href="AddJob" class="btn btn-success">Post Vacancy </a>           
            <c:out value='<%=request.getAttribute("addjob")%>' />

        </div> 

        <!-- /.card-header -->
        <div class="card-body p-0">
            <table class="table table-hover table-bordered">
                <thead>
                    <tr>
                        <td style="width: 10px">Id</td>
                        <!--                        id, job, title, vacancy_id, post_date, deadline, min_experiance, max_experiance, salary, description,
                                                attachment, image, work_place, category, job_modality, applied_in, status, created_at, last_modified-->
                        <td>Employer</td>
                        <td>Title</td>
                        <td>Category</td>
                        <td>Post Date</td>
                        <td>Close Date</td>
                        <td>Experience</td>
                        <td>Applied In</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                    List<JobBean> jobs = (ArrayList<JobBean>)request.getAttribute("jobs");
                    int i=1;
                    for (JobBean job : jobs ) {              
                    %>
                    <tr>
                        <td><%=i%></td>
                        <td><%=job.getEmployer_name()%></td>
                        <td><%=job.getTitle()%></td>
                        <td><%=job.getCategory_name()%></td>
                        <td><%=job.getPost_date()%></td>
                        <td> <%=job.getDeadline()%> </td>
                        <td> <%=job.getMin_experiance() %> - <%=job.getMax_experiance() %></td>
                        <td> <%=job.getApplied_in() %> </td>

                        <td> 
                            <a href="DetaileJob?id=<%=job.getId()%>"><i class="fas fa-eye"></i></a>
                            <a href="EditJob?id=<%=job.getId()%>"><i
                                    class="fas fa-edit"></i></a>
                                <c:set var="status" value="<%=job.getStatus()%>" />
                                <c:choose>
                                    <c:when test="${status eq 'active'}" >
                                    <a href="SuspendJob?id=<%=job.getId()%>&action=suspend"  ><span >suspend</span></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="SuspendJob?id=<%=job.getId()%>&action=unsuspend"  ><span style="color:red;">activate</span></a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <%
                        i++;
                    }
                    %>
                </tbody>
            </table>

            <!--            <button type="button" class="btn btn-danger swalDefaultSuccess">
                            Launch Success Toast
                        </button>
            
                        <button type="button" class="btn btn-success toastrDefaultSuccess">
                            Launch Success Toast
                        </button>-->
        </div>
        <!-- /.card-body -->
    </div>
</div>

<div class="modal fade" id="modal-sm">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Small Modal</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>One fine body&hellip;</p>
            </div>

        </div>

    </div>
</div>
<!-- Main Footer -->
<jsp:include page="/WEB-INF/fragments/footer.jsp" />
<script src="adminlte/plugins/toastr/toastr.js"></script>
<script>
    $(function () {
        var Toast = Swal.mixin({
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 3000
        });

        if (${userDeleteStatus}.equals("deleted")) {

            Toast.fire({
                icon: 'success',
                title: 'user Seccessfully Deleted'
            });

        } else if (${userDeleteStatus}.equals("not deleted")) {

            Toast.fire({
                icon: 'error',
                title: 'User Not Deleted Please try again!!'
            });
        }


        $('.toastrDefaultSuccess').click(function () {
            toastr.success('Lorem ipsum dolor sit amet, consetetur sadipscing elitr.')
        });

    });
</script>

