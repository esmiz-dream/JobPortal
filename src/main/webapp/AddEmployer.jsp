<%-- 
    Document   : AddEmployer
    Created on : Jun 19, 2023, 12:24:54 AM
    Author     : hp
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false"%>
<jsp:include page="/WEB-INF/fragments/dashbord.jsp" />

<div class="content-wrapper justify-center" style="min-height: 600.4px;">
    <div class="card mx-auto" style="width: 60%">
        <div class="card-header">
            <h3 class="card-title">Add Employer</h3>
        </div>
        <!-- /.card-header -->
        <!-- form start -->
        <form action="AddEmployer" method="POST" enctype="multipart/form-data">
            <div class="card-body">
                <div class="form-group">
                    <label for="nameinput">Company Name</label> <input type="text"
                                                                       class="form-control" id="nameinput" name="company_name"
                                                                       placeholder="Enter Company name" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errCompanyName}</span>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label> <input
                        type="text" class="form-control" id="exampleInputEmail1"
                        name="email" placeholder="Enter email" >
                    <span id="erremail" style="color:red; padding-left:20px;"> ${errEmail}</span>
                </div>
                <div class="form-group">
                    <label for="tininput">Tin Number</label> <input type="text"
                                                                    class="form-control" id="tininput" name="tin_number"
                                                                    placeholder="Enter Company Tin Number" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errTinNumber}</span>
                </div>
                <div class="form-group">
                    <label for="phoneinput">Phone</label> <input type="text"
                                                                 class="form-control" id="phoneinput" name="phone"
                                                                 placeholder="Enter Company Phone Number" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errPhone}</span>
                </div>
                <div class="form-group">
                    <label for="contactinput">Contact Person</label> <input type="text"
                                                                            class="form-control" id="contactinput" name="contact_name"
                                                                            placeholder="Enter Contact Person name" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errContact}</span>
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
                    <label for="exampleInputFile">Logo</label>
                    <div class="input-group">
                        <div class="custom-file">
                            <input type="file" class="custom-file-input"
                                   id="exampleInputFile" name="logo" accept="image/*"> <label
                                   class="custom-file-label" for="exampleInputFile">Upload
                                Logo</label>
                        </div>
                        <br>
                        <span id="errphoto" style="color:red; padding-left:20px;"> ${errLogo}</span>
                    </div>
                </div>

            </div>
            <!-- /.card-body -->
            <div class="card-footer">
                <button type="submit" class="btn btn-primary" value="AddEmployer">Submit</button>
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
