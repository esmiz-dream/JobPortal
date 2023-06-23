<%-- 
    Document   : ViewEmployer
    Created on : Jun 18, 2023, 11:01:40 PM
    Author     : hp
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.esmizdream.futurejobs.employer.servlet.EmployerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" %>
<jsp:include page="/WEB-INF/fragments/dashbord.jsp" />

<div class="content-wrapper" style="min-height: 600.4px;">
    <div class="card mx-auto" style="width: 90%">
        <div class="card-header">
            <h3 class="card-title">Administrator</h3><br><br>

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

            <a href="AddEmployer" class="btn btn-success">New Employer </a>           
            <c:out value='<%=request.getAttribute("addemployer")%>' />

        </div> 

        <!-- /.card-header -->
        <div class="card-body p-0">
            <table class="table table-hover table-bordered">
                <thead>
                    <tr>
                        <th style="width: 10px">Id</th>
                        <!--email, password, company_name, tin_number, phone, contact_name, logo, status, created_at-->
                        <th>Company Name</th>
                        <td>Email</td>
                        <td>Phone</td>
                        <td>Tin Number</td>
                        <td>Contact Person</td>
                        <td>Logo</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                    List<EmployerBean> employers = (ArrayList<EmployerBean>)request.getAttribute("employers");
                    int i=1;
                    for (EmployerBean employer : employers ) {
                           
                    %>
                    <tr>
                        <td><%=i%></td>
                        <td><%=employer.getCompany_name()%></td>
                        <td><%=employer.getEmail()%></td>
                        <td><%=employer.getPhone()%></td>
                        <td> <%=employer.getTin_number()%> </td>
                        <td> <%=employer.getContact_name() %> </td>
                        <td> <%=employer.getLogo() %> </td>

                        <td> 
                            <a href="EditEmployer?id=<%=employer.getId()%>"><i
                                    class="fas fa-edit"></i></a>
                                <c:set var="status" value="<%=employer.getStatus()%>" />
                                <c:choose>
                                    <c:when test="${status eq 'active'}" >
                                    <a href="SuspendEmployer?id=<%=employer.getId()%>&action=suspend"  ><span >suspend</span></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="SuspendEmployer?id=<%=employer.getId()%>&action=unsuspend"  ><span style="color:red;">activate</span></a>
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
