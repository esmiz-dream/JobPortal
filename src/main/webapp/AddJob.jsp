<%-- 
    Document   : AddJob
    Created on : Jun 20, 2023, 9:44:34 PM
    Author     : hp
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.esmizdream.futurejobs.jobcategory.JobCategoryBean"%>
<jsp:include page="/WEB-INF/fragments/dashbord.jsp" />


<div class="content-wrapper justify-center" style="min-height: 600.4px;">
    <div class="card mx-auto" style="width: 60%">
        <div class="card-header">
            <h3 class="card-title">Post Vacancy</h3>
        </div>
        <!-- /.card-header -->
        <!-- form start -->

        <form action="AddJob" method="POST" enctype="multipart/form-data">
            <div class="card-body">

                <div class="form-group">
                    <label>Job Category</label>
                    <select name="job_category" class="form-control select2 select2-hidden-accessible" style="width: 100%;" data-select2-id="1" tabindex="-1" aria-hidden="true">
                        <%
                          List<JobCategoryBean> categories=(ArrayList<JobCategoryBean>)request.getAttribute("category");
                 int i=0;
                 for(JobCategoryBean cat : categories)
                 {
                 i++;
                        %> 
                        <option data-select2-id="<%=cat.getId()%>" value="<%=cat.getId()%>" >
                            <%=cat.getTitle()%>
                        </option>
                        <% } %>
                    </select>
                </div>

                <div class="form-group">
                    <label for="titleinput">Job Title</label> <input type="text"
                                                                     class="form-control" id="titleinput" name="title"
                                                                     placeholder="Job Title" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errTitle}</span>
                </div>

                <div class="form-group">
                    <label for="vacancyidinput">Vacancy Id</label> <input type="text"
                                                                          class="form-control" id="vacancyidinput" name="vacancy_id"
                                                                          placeholder="Vacancy Id" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errVacancyId}</span>
                </div>
                <div class="form-group">
                    <label>Close Date</label>
                    <div class="input-group date" id="reservationdate" data-target-input="nearest">
                        <input type="text" name="deadline" class="form-control datetimepicker-input" data-target="#reservationdate" />
                        <div class="input-group-append" data-target="#reservationdate" data-toggle="datetimepicker">
                            <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="minExperienceInput">Minimum Experience  </label> <input
                        type="number" class="form-control" id="minExperienceInput"
                        name="min_experience" placeholder="Menimum Experience" >
                    <span id="erremail" style="color:red; padding-left:20px;"> ${errMinExpe}</span>
                </div>

                <div class="form-group">
                    <label for="maxExperienceInput">Maximum Experience</label> <input
                        type="number" class="form-control" id="maxExperienceInput"
                        name="max_experience" placeholder="Maximum Experience" >
                    <span id="erremail" style="color:red; padding-left:20px;"> ${errMaxExper}</span>
                </div>
                <div class="form-group">
                    <label for="salaryInput">Gross Salary</label> <input
                        type="number" class="form-control" id="salaryInput"
                        name="salary" placeholder="Gross Salary" >
                    <span id="erremail" style="color:red; padding-left:20px;"> ${errSalary}</span>
                </div>



                <div class="col-sm-6">
                    <div class="form-group">
                        <label>Description</label>
                        <textarea name="description" class="form-control" rows="12" cols="50" placeholder="description to the new vacancy...." ></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <label for="workPlaceInput">Work Place</label> 
                    <input type="text" class="form-control" id="workPlaceInput" name="work_place" placeholder="Work place" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errWorkPlace}</span>
                </div>

                <div class="form-group">
                    <label for="jobModalityInput">Employment Type</label>
                    <select name="job_modality" class="select2 select2-hidden-accessible" multiple="" data-placeholder="Select Employment Type..." style="width: 100%;" data-select2-id="7" tabindex="-1" aria-hidden="true">
                        <option >Full Time Onsite</option>
                        <option>Part Time Onsite</option>
                        <option>Contract</option>
                        <option>Remote Full TIme</option>
                        <option>Remote Part Time</option>
                        <option>Other Negotiable</option>
                    </select>
                </div>

                <div class="form-group clearfix" style="padding-top: 15px; padding-bottom: 10px">
                    <label for="checkboxPrimary">Application Method
                    </label>
                    <div class="form-group" >
                        <!--<div class="icheck-primary d-inline" style="padding-right: 30px">-->
                            <input name="applied_in" type="checkbox"   value="Future Job">
                            <label >Future Job
                            </label>
                        <!--</div>-->
                        <!--<div class="icheck-primary d-inline">-->
                            <input name="applied_in" type="checkbox" id="checkboxPrimary2"   value="Other">
                            <label > Other
                            </label>
                        <!--</div>-->
                    </div>
                </div>


                <div class="form-group">
                    <label for="exampleInputFile">Attachment</label>
                    <div class="input-group">
                        <div class="custom-file">
                            <input type="file" class="custom-file-input"
                                   id="exampleInputFile" name="attachment" > <label
                                   class="custom-file-label" for="exampleInputFile">Upload
                                File</label>
                        </div>
                        <br>
                        <span id="errphoto" style="color:red; padding-left:20px;"> ${errLogo}</span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="exampleInputFile">Image Attachment</label>
                    <div class="input-group">
                        <div class="custom-file">
                            <input type="file" class="custom-file-input"
                                   id="exampleInputFile" name="image" accept="image/*"> <label
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

