
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Pizza Notifier</title>

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="<c:url value="/resource/js/jquery.label_better.js"/>"></script>
        <style>
            html {
                height: 100%;
            }
            body {
                background: #272D30;
                padding: 0;
                text-align: center;
                font-family: 'open sans';
                position: relative;
                margin: 0;
                height: 100%;
            }

            .wrapper {
                height: auto !important;
                height: 100%;
                margin: 0 auto; 
                overflow: hidden;
            }

            a {
                text-decoration: none;
            }


            h1, h2 {
                width: 100%;
                float: left;
            }
            h1 {
                margin-top: 100px;
                color: #fff;
                text-shadow: 0 1px 5px rgba(0,0,0,0.5);
                margin-bottom: 5px;
                font-size: 70px;
                letter-spacing: -4px;
            }
            h2 {
                color: #5F7591;
                font-weight: bold;
                text-shadow: 0 1px 5px rgba(0,0,0,0.5);
                margin-top: 0;
                margin-bottom: 10px;
            }

            .pointer {
                color: #9b59b6;
                font-family: 'Pacifico', cursive;
                font-size: 30px;
                margin-top: 15px;
            }
            pre {
                margin: 80px auto;
            }
            pre code {
                padding: 35px;
                border-radius: 5px;
                font-size: 15px;
                background: rgba(0,0,0,0.1);
                border: rgba(0,0,0,0.05) 5px solid;
                max-width: 500px;
            }


            .main {
                float: left;
                width: 100%;
                margin: 0 auto;
            }


            .main h1 {
                padding:20px 50px;
                float: left;
                width: 100%;
                font-size: 60px;
                box-sizing: border-box;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                font-weight: 100;
                margin: 0;
                padding-top: 25px;
                font-family: 'Pacifico';
                letter-spacing: 2px;
            }

            .main h1.demo1 {
                background: #1ABC9C;
            }

            .reload.bell {
                font-size: 12px;
                padding: 20px;
                width: 45px;
                text-align: center;
                height: 47px;
                border-radius: 50px;
                -webkit-border-radius: 50px;
                -moz-border-radius: 50px;
            }

            .reload.bell #notification {
                font-size: 25px;
                line-height: 140%;
            }

            .reload, .btn{
                display: inline-block;
                border: 4px solid #A2261E;
                border-radius: 5px;
                -moz-border-radius: 5px;
                -webkit-border-radius: 5px;
                background: #CC3126;
                display: inline-block;
                line-height: 100%;
                padding: 0.7em;
                text-decoration: none;
                color: #fff;
                width: 100px;
                line-height: 140%;
                font-size: 17px;
                font-family: open sans;
                font-weight: bold;
            }
            .reload:hover{
                background: #A2261E;
            }
            .btn {
                width: 200px;
                color: #fff;
                border: none;
                margin-left: 10px;
                background: rgba(255, 255, 255, 0.11);
            }
            .clear {
                width: auto;
            }
            .btn:hover, .btn:hover {
                background: rgba(255,255,255,0.3);
            }
            .btns {
                width: 410px;
                margin: 50px auto;
            }
            .credit {
                font-style: italic;
                text-align: center;
                color: #fff;
                padding: 10px;
                margin: 0 0 40px 0;
                float: left;
                width: 100%;
            }
            .credit a {
                color: #ccc;
                text-decoration: none;
                font-weight: bold;
            }

            .back {
                position: absolute;
                top: 0;
                left: 0;
                text-align: center;
                display: block;
                padding: 7px;
                width: 100%;
                box-sizing: border-box;
                -moz-box-sizing: border-box;
                -webkit-box-sizing: border-box;
                background: rgba(0, 0, 0, 0.65);
                font-weight: bold;
                font-size: 13px;
                color: #fff;
                -webkit-transition: all 200ms ease-out;
                -moz-transition: all 200ms ease-out;
                -o-transition: all 200ms ease-out;
                transition: all 200ms ease-out;
            }
            .back:hover {
                background: rgba(0, 0, 0, 0.85);
            }

            .bl_form {
                margin: 150px 0;
            }

            .bl_form input {
                padding-top: 15px;
                background: rgba(255,255,255,0.10);
                box-shadow: 0 2px 8px rgba(0,0,0,0.2);
                border: none;
                color: white;
                padding: 10px 15px;
                border-radius: 25px;
                font-size: 16px;
                outline: none;
            }


            .lb_wrap .lb_label.top, .lb_wrap .lb_label.bottom {
                left: 15px !important;
            }

            .lb_wrap .lb_label.left {
                left: 0;
            }

            .lb_label {
                font-weight: bold;
                color: #999;
            }

            .lb_label.active {
                color: #FFF;
            }

        </style>
        <script>
            $(document).ready(function() {
                $(".label_better").label_better({
                    easing: "bounce"
                });
            });

        </script>
    </head>
    <body>
        <div class="wrapper">
            <div class="main">
                <div class="header">
                    <h1>Pizza Notifier</h1>
                    <h2>Tired of going to Annapurna to try luck? you can now be notified when they have Pizza in there! </h2>
                    <p class="credit">Created by <a href="https://github.com/lfernandez93">Luis Fernandez</a>
                    <div class="btns">

                    </div>
                </div>
                <div class="page-container">
                    <form:form class="bl_form" method="post">
                        <input name="email" type="email" value=""  class="label_better" data-new-placeholder="Email Address" placeholder="Email Address"> 
                        <input type="submit" class="reload btn" value="Subscribe" style=""/>
                        <c:if test="${error == 'true'}">
                            <label style="color: red">Your email is incorrect.</label>
                        </c:if>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
