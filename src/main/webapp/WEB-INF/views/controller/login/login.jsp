<%--
  Created by IntelliJ IDEA.
  User: zilet
  Date: 2023-05-01
  Time: 오후 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath(); %> <%--ContextPath 선언 --%>

<html>
    <head>
        <title>로그인</title>
        <link href="<%=contextPath%>/resources/css/yang/login.css" rel="stylesheet">
        <link href="<%=contextPath%>/resources/css/yang/base.css" rel="stylesheet">

        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    </head>
    <body>
        <div class="box">

            <div class="image-box"></div>

            <div class="spare-box m0 p0"></div>

            <div class="description-box">
                <h1 class="p0 m0">로그인</h1>
                <h3 class="p0 m0 color-hint">로그인 정보를 입력해주세요.</h3>
            </div>

            <div class="id-box">
                <label class="input-label" for="id"> 아이디 : </label>
                </br>
                <input type="text" class="input-text" id="id" placeholder="아이디를 입력하세요.">
            </div>

            <div class="pw-box">
                <label class="input-label" for="pw"> 비밀번호 : </label>
                </br>
                <input type="password" class="input-text" id="pw" placeholder="패스워드를 입력하세요.">
            </div>

            <div class="spare-box m0 p0"></div>
            <div class="spare-box m0 p0"></div>
            <div class="btn-box">
                <a class="btn-primary mb-5" id="login">로그인</a>
                <div class="spare-box m0 p0"></div>
                <a class="btn-second mb-5" id="register" href="/login/register">회원가입</a>
            </div>

        </div>
    </body>

    <script type="application/javascript">

    </script>
</html>
