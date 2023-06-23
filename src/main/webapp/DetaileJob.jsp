<%-- 
    Document   : DetaileJob
    Created on : Jun 22, 2023, 9:38:38 AM
    Author     : hp
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.esmizdream.futurejobs.job.servlet.JobBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" %>
<jsp:include page="/WEB-INF/fragments/dashbord.jsp" />
<%
    JobBean job=(JobBean)request.getAttribute("job");
     
%>
<div class="content-wrapper" style="min-height: 600.4px;">
    <div class="card mx-auto" style="width: 90%">
        <div class="card-header" style="padding-top: 20px">
            <h1 class="card-title"><b><%=job.getTitle()%></b></h1><br>
        </div> 

        <!-- /.card-header -->
        <div class="card card-primary">

            <!-- /.card-header -->
            <div class="card-body">
                <table style="width: 70%">
                    <tr>
                        <td> <strong><i class="fas fa-book mr-1"></i> Employer</strong> </td>
                        <td>  <strong><i class="fas fa-book mr-1"></i> Status</strong></td>
                    </tr>
                    <tr style="border-bottom: 1px solid black;">
                        <td> <p class="text-muted"> <%=job.getEmployer_name()%></p></td>
                        <td> <p class="text-muted text-success"> <%=job.getStatus()%></p></td>
                    </tr>


                    <tr >
                        <td> <strong><i class="fas fa-book mr-1"></i> Vacancy Id</strong> </td>
                    </tr>
                    <tr style="border-bottom: 1px solid black;">
                        <td> <p class="text-muted"> <%=job.getVacancy_id()%> </p></td>

                    </tr>


                    <tr>
                        <td> <strong><i class="fas fa-timeline"></i>Opened Date</strong> </td>
                        <td> <strong> Closing Date</strong> </td>

                    </tr>
                    <tr style="border-bottom: 1px solid black;">
                        <td> <p class="text-muted"> <%=job.getPost_date()%> </p></td>
                        <td> <p class="text-muted"> <%=job.getDeadline()%> </p></td>

                    </tr>


                    <tr>
                        <td> <strong><i class="fas fa-timeline"></i>Gross Salary</strong> </td>
                    </tr>
                    <tr style="border-bottom: 1px solid black;">
                        <td> <p class="text-muted"> <%=job.getSalary()%> </p></td>                
                    </tr>



                    <tr>
                        <td> <strong><i class="fas fa-timeline"></i>Min-Experience</strong> </td>
                        <td> <strong> Max-Experience</strong> </td>

                    </tr>
                    <tr style="border-bottom: 1px solid black;">
                        <td> <p class="text-muted"> <%=job.getMin_experiance()%> </p></td>
                        <td> <p class="text-muted"> <%=job.getMax_experiance()%> </p></td>

                    </tr>
                    <tr>
                        <td> <strong><i class="fas fa-timeline"></i>Description</strong> </td>
                    </tr>
                    <tr style="border-bottom: 1px solid black;">
                        <td> <p class="text-muted"> <%=job.getDescription()%> </p></td>                
                    </tr>

                    <tr>
                        <td> <strong><i class="fas fa-timeline"></i>Attachment</strong> </td>
                        <td> <strong>Image Attachment</strong> </td>
                    </tr>
                    <tr style="border-bottom: 1px solid black;">
                        <td> 
                            <c:set var="attachment" value="<%=job.getAttachment()%>"></c:set>                            
                            <c:set var="image" value="<%=job.getImage()%>"></c:set>

                            <c:choose>
                                <c:when test="not attachment eq null" >
                                    <div class="form-group">
                                        <img src="attachment/<%=job.getAttachment()%>" class="image"  width="200" height="180" >
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <p class="text-muted">No Attachment</p>
                                </c:otherwise>
                            </c:choose> 
                        </td>
                        <td> 
                            <c:choose>
                                <c:when test="${image eq 'employer/logo/download.png'} " >
                                    <div class="form-group">
                                        <img src="attachment/<%=job.getImage()%>" class="image"  width="200" height="180" >
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <p class="text-muted">No Image</p>
                                </c:otherwise>
                            </c:choose> 
                        </td>

                    </tr>

                    <tr>
                        <td> <strong><i class="fas fa-timeline"></i>Work Place</strong> </td>
                    </tr>
                    <tr style="border-bottom: 1px solid black;">
                        <td> <p class="text-muted"> <%=job.getWork_place()%> </p></td>                
                    </tr>


                    <tr>
                        <td> <strong><i class="fas fa-timeline"></i>Job Category</strong> </td>
                        <td> <strong> Job Type</strong> </td>
                    </tr>
                    <tr style="border-bottom: 1px solid black;">
                        <td> <p class="text-muted"> <%=job.getCategory_name()%> </p></td>
                        <td> <p class="text-muted"> <%=job.getJob_modality()%> </p></td>
                    </tr>


                </table>
            </div>
            <!-- /.card-body -->
        </div>

    </div>
</div>
