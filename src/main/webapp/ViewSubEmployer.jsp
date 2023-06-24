<%-- 
    Document   : ViewSubEmployer
    Created on : Jun 23, 2023, 4:09:23 PM
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
                        <td>Email</td>  
                        <td>Account Type</td>  
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
                        <td><%=accounts.getEmail()%></td>      
                        <td><%=accounts.getAccount_type()%></td>      
                        <td><%=accounts.getAccount_type()%></td>      
                        <td><%=accounts.getName()%></td>      

                        <td style="display: flex; column-gap: 5px;">

<!--                            <a href="DetaileSubEmployer.jsp"  ><i
                                    class="fas fa-eye"></i></a>-->
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

<div class="modal fade" id="modal-lg">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Account Detaile</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h1 id = "modal_body"> </h1>
                <div class="col-12">
                    <h4></h4>
                    <div class="post">
                        <div class="user-block">
                            <img class="img-circle img-bordered-sm" src="../../dist/img/user1-128x128.jpg" alt="user image">
                            <span class="username">
                                <a href="#">Jonathan Burke Jr.</a>
                            </span>
                            <span class="description">Shared publicly - 7:45 PM today</span>
                        </div>

                        <p>
                            Lorem ipsum represents a long-held tradition for designers,
                            typographers and the like. Some people hate it and argue for
                            its demise, but others ignore.
                        </p>
                        <p>
                            <a href="#" class="link-black text-sm"><i class="fas fa-link mr-1"></i> Demo File 1 v2</a>
                        </p>
                    </div>
                    <div class="post clearfix">
                        <div class="user-block">
                            <img class="img-circle img-bordered-sm" src="../../dist/img/user7-128x128.jpg" alt="User Image">
                            <span class="username">
                                <a href="#">Sarah Ross</a>
                            </span>
                            <span class="description">Sent you a message - 3 days ago</span>
                        </div>

                        <p>
                            Lorem ipsum represents a long-held tradition for designers,
                            typographers and the like. Some people hate it and argue for
                            its demise, but others ignore.
                        </p>
                        <p>
                            <a href="#" class="link-black text-sm"><i class="fas fa-link mr-1"></i> Demo File 2</a>
                        </p>
                    </div>
                    <div class="post">
                        <div class="user-block">
                            <img class="img-circle img-bordered-sm" src="../../dist/img/user1-128x128.jpg" alt="user image">
                            <span class="username">
                                <a href="#">Jonathan Burke Jr.</a>
                            </span>
                            <span class="description">Shared publicly - 5 days ago</span>
                        </div>

                        <p>
                            Lorem ipsum represents a long-held tradition for designers,
                            typographers and the like. Some people hate it and argue for
                            its demise, but others ignore.
                        </p>
                        <p>
                            <a href="#" class="link-black text-sm"><i class="fas fa-link mr-1"></i> Demo File 1 v1</a>
                        </p>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
<!-- Main Footer -->
<jsp:include page="/WEB-INF/fragments/footer.jsp" />
<script src="adminlte/plugins/toastr/toastr.js"></script>
<script type = "text/javascript">
    $("#submit").click(function () {

        var str = "You Have Entered "
                + "Name: "
                + "Cass: "
                + " and Marks: ";
        $("#modal_body").html(str);
    });
</script> 
<script>

    $("#submit").click(function () {
        var name = $("#name").val();
        var cass = $("#cass").val();
        var marks = $("#marks").val();
        var str = "You Have Entered "
                + "Name: "
                + "Cass: "
                + " and Marks: ";
        $("#modal_body").html(str);
    });
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

