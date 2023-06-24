<%-- 
    Document   : DetaileSubEmployer
    Created on : Jun 24, 2023, 6:07:45 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.esmizdream.futurejobs.employer.servlet.SubEmployerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" %>
<jsp:include page="/WEB-INF/fragments/dashbord.jsp" />

<div class="content-wrapper" style="min-height: 600.4px;">
    <div class="card mx-auto" style="width: 90%">
        <div class="card-header">
            <h3 class="card-title">Sub User Accounts</h3><br><br>

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

            <a href="AddSubEmployer.jsp" class="btn btn-success">Add Sub Account </a>           

        </div> 

        <!-- /.card-header -->
        <div class="card-body p-0">
            <table class="table table-hover table-bordered">
                <thead>
                    <tr>
                        <th style="width: 10px">Id</th>
                        <!--email, password, company_name, tin_number, phone, contact_name, logo, status, created_at-->
                        <td>Department</td>  
                        <td>Account Role</td>   
                        <td>Department Head</td>      
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <% 
                 List<SubEmployerBean> sub_accounts=(ArrayList<SubEmployerBean>)request.getAttribute("sub_employer");
                 int i=0;
                 for(SubEmployerBean accounts : sub_accounts)
                 {
                 i++;
                    %>

                    <tr>
                        <td><%=i%></td>        
                        <td><%=accounts.getDepartment_name()%></td>  
                        <td><%=accounts.getAccount_type()%></td>      
                        <td><%=accounts.getName()%></td>      

                        <td style="display: flex; column-gap: 5px;">
                            <a href="DetailSubEmployer?id=<%=accounts.getId()%>"><i
                                    class="fas fa-eye"></i></a>
                            <a href="EditSubEmployer?id=<%=accounts.getId()%>"><i
                                    class="fas fa-edit"></i></a>
                                <c:set var="status" value="<%=accounts.getStatus()%>" />
                                <c:choose>
                                    <c:when test="${status eq 'Active'}" >
                                    <a href="SuspendSubEmployer?id=<%=accounts.getId()%>&action=suspend"  ><span style="color:red;">Suspend</span></a>
                                </c:when>
                                <c:otherwise>
                                    <a href="SuspendSubEmployer?id=<%=accounts.getId()%>&action=unsuspend"  ><span >Activate</span></a>
                                </c:otherwise>
                            </c:choose>
                            <a href="DeleteSubEmployer?id=<%=accounts.getId()%>"><i
                                    class="fas fa-trash" style="color:red;"></i></a>
                        </td>
                    </tr>
                    <%
                     }
                    %>
                </tbody>
            </table>

                        <button type="button" class="btn btn-danger swalDefaultSuccess">
                            Launch Success Toast
                        </button>
            
                        <button type="button" class="btn btn-success toastrDefaultSuccess">
                            Launch Success Toast
                        </button>
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

