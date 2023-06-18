<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="com.esmizdream.futurejobs.admin.servlet.AdminBean"%>

<jsp:include page="/WEB-INF/fragments/dashbord.jsp" />
<%  
List<AdminBean> adminlist = (ArrayList<AdminBean>)request.getAttribute("adminuser");
AdminBean admin=adminlist.get(0);
%>
<div class="content-wrapper justify-center" style="min-height: 600.4px;">
    <div class="card mx-auto" style="width: 60%">
        <div class="card-header">
            <h3 class="card-title">Edit Administrator Information</h3>
        </div>
        <h1>  </h1>  
        <form action="EditAdmin" method="POST" enctype="multipart/form-data">
            <div class="card-body">
                <input type="hidden" name="id" value="<%=admin.getId() %>" />
                <div class="form-group">
                    <label for="nameinput">Name</label> <input type="text"
                                                               class="form-control" id="nameinput" name="name"
                                                               placeholder="Enter name" value="<%=admin.getName()%>" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errName}</span>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label> <input
                        type="text" class="form-control" id="exampleInputEmail1"
                        name="email" placeholder="Enter email" value="<%=admin.getEmail()%>" >
                    <span id="erremail" style="color:red; padding-left:20px;"> ${errEmail}</span>
                </div>

                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label> <input
                        type="password" class="form-control" name="password"
                        id="exampleInputPassword1" placeholder="Password" data-bv-identical="true"
                        data-bv-identical-field="confirmPassword"
                        data-bv-identical-message="The password and its confirm are not the same"  />
                    <span id="errpassword" style="color:red; padding-left:20px;"> ${errPassword}</span>
                </div>

                <div class="form-group">
                    <label for="exampleInputPassword1">Confirm Password</label> <input
                        type="password" class="form-control" name="confirmPassword"
                        id="exampleInputPassword1" placeholder="Confirm Password" data-bv-identical="true"
                        data-bv-identical-field="password"
                        data-bv-identical-message="The password and its confirm are not the same" />
                    <span id="errConfpassword" style="color:red; padding-left:20px;"> ${errConfPassword}</span>
                </div>

                <div class="form-group">
                    <img src="attachment/<%=admin.getPhotoUrl()%>" class="image"  width="200" height="180" >
                </div>

                <div class="form-group">
                    <label for="exampleInputFile">Photo</label>
                    <div class="input-group">
                        <div class="custom-file">
                            <input type="file" class="custom-file-input"
                                   id="exampleInputFile" name="photo" accept="image/*" > <label
                                   class="custom-file-label" for="exampleInputFile">Upload
                                Photo</label>
                        </div>
                        <br>
                        <span id="errphoto" style="color:red; padding-left:20px;"> ${errPhoto}</span>
                    </div>
                </div>

            </div>
            <!-- /.card-body -->

            <div class="card-footer">
                <button type="submit" class="btn btn-primary" value="EditAdmin">Submit</button>
            </div>
          
        </form> 
    </div>
</div>

<script>

    $(function () {
        bsCustomFileInput.init();
        $('#identicalForm').bootstrapValidator();

        $('.toastrDefaultSuccess').click(function () {
            toastr.success('Lorem ipsum dolor sit amet, consetetur sadipscing elitr.')
        });


    });
</script>