<%-- 
    Document   : EditSubEmployer
    Created on : Jun 24, 2023, 7:22:50 PM
    Author     : hp
--%>


<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.esmizdream.futurejobs.employer.servlet.SubEmployerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" %>
<jsp:include page="/WEB-INF/fragments/dashbord.jsp" />
<div class="content-wrapper justify-center" style="min-height: 600.4px;">
    <div class="card mx-auto" style="width: 60%">
        <div class="card-header">
            <h3 class="card-title">Edit Account</h3>
        </div>

        <!-- /.card-header -->
        <!-- form start -->
        <!--//    id, employer, name, email, password, account_type, department_name, status, created_at, last_modified-->
        <% 
            List<SubEmployerBean> sub_accounts=(ArrayList<SubEmployerBean>)request.getAttribute("sub_employer");
           SubEmployerBean account=sub_accounts.get(0);
        %>
        <form action="EditSubEmployer" method="POST"  >
            <div class="card-body">
                <div class="form-group">
                    <label for="nameinput">Name</label> <input type="text"
                                                               class="form-control" id="nameinput" name="name"
                                                               placeholder="Enter name" value="<%=account.getName() %>" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errName}</span>
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label> <input
                        type="text" class="form-control" id="exampleInputEmail1"
                        name="email" placeholder="Enter email" value="<%=account.getEmail() %>" >
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
                    <select name="account_type" class="select2 select2-hidden-accessible" data-placeholder="Select Employment Type..." style="width: 100%;" data-select2-id="7" tabindex="-1" aria-hidden="true">
                        <option>CEO</option>
                        <option >Finance</option>
                        <option>Human Resource</option>
                        <option>Other</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="deparmentNameInput">Department Name</label> <input type="text"
                                                                                   class="form-control" id="deparmentNameInput" name="department_name"
                                                                                   placeholder="Enter department name" value="<%=account.getDepartment_name() %>" >
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
        // Summernote
        $('#summernote').summernote()


        //Initialize Select2 Elements
        $('.select2').select2()

        //Initialize Select2 Elements
        $('.select2bs4').select2({
            theme: 'bootstrap4'
        })

        //Datemask dd/mm/yyyy
        $('#datemask').inputmask('dd/mm/yyyy', {'placeholder': 'dd/mm/yyyy'})
        //Datemask2 mm/dd/yyyy
        $('#datemask2').inputmask('mm/dd/yyyy', {'placeholder': 'mm/dd/yyyy'})
        //Money Euro
        $('[data-mask]').inputmask()

        //Date picker
        $('#reservationdate').datetimepicker({
            format: 'L'
        });

        //Date and time picker
        $('#reservationdatetime').datetimepicker({icons: {time: 'far fa-clock'}});

        //Date range picker
        $('#reservation').daterangepicker()
        //Date range picker with time picker
        $('#reservationtime').daterangepicker({
            timePicker: true,
            timePickerIncrement: 30,
            locale: {
                format: 'MM/DD/YYYY hh:mm A'
            }
        })
        //Date range as a button
        $('#daterange-btn').daterangepicker(
                {
                    ranges: {
                        'Today': [moment(), moment()],
                        'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                        'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                        'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                        'This Month': [moment().startOf('month'), moment().endOf('month')],
                        'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                    },
                    startDate: moment().subtract(29, 'days'),
                    endDate: moment()
                },
                function (start, end) {
                    $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
                }
        )

        //Timepicker
        $('#timepicker').datetimepicker({
            format: 'LT'
        })

        //Bootstrap Duallistbox
        $('.duallistbox').bootstrapDualListbox()

        //Colorpicker
        $('.my-colorpicker1').colorpicker()
        //color picker with addon
        $('.my-colorpicker2').colorpicker()

        $('.my-colorpicker2').on('colorpickerChange', function (event) {
            $('.my-colorpicker2 .fa-square').css('color', event.color.toString());
        })

        $("input[data-bootstrap-switch]").each(function () {
            $(this).bootstrapSwitch('state', $(this).prop('checked'));
        })

    })
    // BS-Stepper Init
    document.addEventListener('DOMContentLoaded', function () {
        window.stepper = new Stepper(document.querySelector('.bs-stepper'))
    })

    // DropzoneJS Demo Code Start
    Dropzone.autoDiscover = false

    // Get the template HTML and remove it from the doumenthe template HTML and remove it from the doument
    var previewNode = document.querySelector("#template")
    previewNode.id = ""
    var previewTemplate = previewNode.parentNode.innerHTML
    previewNode.parentNode.removeChild(previewNode)

    var myDropzone = new Dropzone(document.body, {// Make the whole body a dropzone
        url: "/target-url", // Set the url
        thumbnailWidth: 80,
        thumbnailHeight: 80,
        parallelUploads: 20,
        previewTemplate: previewTemplate,
        autoQueue: false, // Make sure the files aren't queued until manually added
        previewsContainer: "#previews", // Define the container to display the previews
        clickable: ".fileinput-button" // Define the element that should be used as click trigger to select files.
    })

    myDropzone.on("addedfile", function (file) {
        // Hookup the start button
        file.previewElement.querySelector(".start").onclick = function () {
            myDropzone.enqueueFile(file)
        }
    })

    // Update the total progress bar
    myDropzone.on("totaluploadprogress", function (progress) {
        document.querySelector("#total-progress .progress-bar").style.width = progress + "%"
    })

    myDropzone.on("sending", function (file) {
        // Show the total progress bar when upload starts
        document.querySelector("#total-progress").style.opacity = "1"
        // And disable the start button
        file.previewElement.querySelector(".start").setAttribute("disabled", "disabled")
    })

    // Hide the total progress bar when nothing's uploading anymore
    myDropzone.on("queuecomplete", function (progress) {
        document.querySelector("#total-progress").style.opacity = "0"
    })

    // Setup the buttons for all transfers
    // The "add files" button doesn't need to be setup because the config
    // `clickable` has already been specified.
    document.querySelector("#actions .start").onclick = function () {
        myDropzone.enqueueFiles(myDropzone.getFilesWithStatus(Dropzone.ADDED))
    }
    document.querySelector("#actions .cancel").onclick = function () {
        myDropzone.removeAllFiles(true)
    }
    // DropzoneJS Demo Code End
</script>



