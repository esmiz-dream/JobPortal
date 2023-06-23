<%-- 
    Document   : AddJobCategory
    Created on : Jun 20, 2023, 3:23:34 PM
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
        <form action="AddJobCategory" method="POST">
            <div class="card-body">
                <div class="form-group">
                    <label for="titleinput">Job Category Title</label> <input type="text"
                                                               class="form-control" id="titleinput" name="title"
                                                               placeholder="New Job Category Title" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errTitle}</span>
                </div>

            </div>
            <!-- /.card-body -->

            <div class="card-footer">
                <button type="submit" class="btn btn-primary" >Submit</button>
            </div>
        </form>
    </div>
</div>

<!-- Main Footer -->
<jsp:include page="/WEB-INF/fragments/footer.jsp" />