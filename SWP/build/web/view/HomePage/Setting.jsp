<%-- 
    Document   : Setting
    Created on : Jul 15, 2024, 4:14:24 PM
    Author     : Hoàng Sơn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Setting</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
            />
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
        ></script>

        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"
            />
    </head>
    <body class="">
        <div class="row">
            <div class="col-1">
                <jsp:include page="../Homestaff/SideBar.jsp"/>
            </div>
            <div class="col-11">
                <div class="container   mt-5 ">
                    <form method="post">
                        <h2>Logo:</h2>
                        <img src="img/logo/${requestScope.logo}" class="img-thumbnail  " alt=""   width="180"
                             height="150" >
                    </form>
                    <div class="bg-body-tertiary">
                        <div class="my-5 ">
                            <button  type="button" class="btn btn-outline-success float-end  ">Thêm</button>
                            <h2>Slide 1:</h2>
                            <c:forEach items="${requestScope.slide1}" var="slide">
                                <form method="post" >
                                    <img src="img/slide/${slide}" class="img-thumbnail w-75 " alt="">
                                    <input type="hidden" name="slide1" value="${slide}"/>
                                    <button  type="submit" class="btn btn-outline-danger  ">Xóa</button>
                                </form>
                            </c:forEach>

                        </div>

                        <div class="my-5 ">
                            <button  type="button" class="btn btn-outline-success float-end  ">Thêm</button>
                            <h2>Slide 2:</h2>
                            <c:forEach items="${requestScope.slide2}" var="slide">
                                <form method="post" >
                                    <img src="img/slide/${slide}" class=" img-thumbnail w-75 " alt="">
                                    <input type="hidden" name="slide2" value="${slide}"/>
                                    <button  type="submit" class="btn btn-outline-danger  ">Xóa</button>
                                </form>
                            </c:forEach>

                        </div>

                    </div>






                </div>
            </div>
        </div>

    </body>
</html>
