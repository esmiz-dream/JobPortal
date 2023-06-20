<%-- 
    Document   : AddAdmin
    Created on : Jun 9, 2023, 7:25:34 PM
    Author     : hp
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false"%>
<jsp:include page="/WEB-INF/fragments/dashbord.jsp" />

<div class="content-wrapper justify-center" style="min-height: 600.4px;">
    <div class="card mx-auto" style="width: 60%">
        <div class="card-header">
            <h3 class="card-title">Add Administrator</h3>
        </div>
        
        <!-- /.card-header -->
        <!-- form start -->
        <form action="Admin" method="POST" enctype="multipart/form-data">
            <div class="card-body">
                <div class="form-group">
                    <label for="nameinput">Name</label> <input type="text"
                                                               class="form-control" id="nameinput" name="name"
                                                               placeholder="Enter name" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errName}</span>
                </div>
                
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label> <input
                        type="text" class="form-control" id="exampleInputEmail1"
                        name="email" placeholder="Enter email" >
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
                    <label for="exampleInputFile">Photo</label>
                    <div class="input-group">
                        <div class="custom-file">
                            <input type="file" class="custom-file-input"
                                   id="exampleInputFile" name="photo" accept="image/*"> <label
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
                <button type="submit" class="btn btn-primary" value="Add User">Submit</button>
            </div>
        </form>
    </div>
</div>

<!-- Main Footer -->
<jsp:include page="/WEB-INF/fragments/footer.jsp" />
<script>

    $(function () {
        bsCustomFileInput.init();
        $('#identicalForm').bootstrapValidator();
    });
</script>