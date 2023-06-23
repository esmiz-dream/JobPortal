<%-- 
    Document   : AddSubEmployer
    Created on : Jun 23, 2023, 4:11:47 PM
    Author     : hp
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false"%>
<jsp:include page="/WEB-INF/fragments/dashbord.jsp" />

<div class="content-wrapper justify-center" style="min-height: 600.4px;">
    <div class="card mx-auto" style="width: 60%">
        <div class="card-header">
            <h3 class="card-title">Add Sub Account</h3>
        </div>

        <!-- /.card-header -->
        <!-- form start -->
        <!--//    id, employer, name, email, password, account_type, department_name, status, created_at, last_modified-->

        <form action="AddSubEmployer" method="POST" enctype="multipart/form-data">
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
                    <label for="jobModalityInput">Account Role</label>
                    <select name="account_type" class="select2 select2-hidden-accessible" multiple="" data-placeholder="Select Employment Type..." style="width: 100%;" data-select2-id="7" tabindex="-1" aria-hidden="true">
                        <option>CEO</option>
                        <option >Finance</option>
                        <option>Human Resource</option>
                        <option>Other</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="deparmentNameInput">Department Name</label> <input type="text"
                                                               class="form-control" id="deparmentNameInput" name="department_name"
                                                               placeholder="Enter department name" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errDep}</span>
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
       

        //Initialize Select2 Elements
        $('.select2').select2()

        //Initialize Select2 Elements
        $('.select2bs4').select2({
            theme: 'bootstrap4'
        })

        
</script>