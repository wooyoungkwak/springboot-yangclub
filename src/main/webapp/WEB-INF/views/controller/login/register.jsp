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
        <title>회원가입</title>
        <link href="<%=contextPath%>/resources/css/yang/register.css" rel="stylesheet">
        <link href="<%=contextPath%>/resources/css/yang/base.css" rel="stylesheet">
    </head>
    <body>
        <div class="box">
            <div class="register-box">
                <div class="description-box">
                    <h1 class="p0 m0">회원가입</h1>
                    <h3 class="p0 m0 color-hint">정보를 입력해주세요.</h3>
                </div>

                <div class="label-box">
                    <label class="input-label" for="id"> 아이디 : </label>
                    </br>
                    <input type="text" class="input-text" id="id" placeholder="아이디를 입력하세요.">
                </div>

                <div class="label-box">
                    <label class="input-label" for="pw"> 비밀번호 : </label>
                    </br>
                    <input type="password" class="input-text" id="pw" placeholder="패스워드를 입력하세요.">
                </div>

                <div class="label-box">
                    <label class="input-label" for="pwCheck"> 비밀번호 확인: </label>
                    </br>
                    <input type="password" class="input-text" id="pwCheck" placeholder="패스워드를 입력하세요.">
                </div>

                <div class="label-box">
                    <label class="input-label" for="name"> 이름: </label>
                    </br>
                    <input type="password" class="input-text" id="name" placeholder="이름을 입력하세요.">
                </div>

                <div class="label-box">
                    <label class="input-label" for="email"> e-mail: </label>
                    </br>
                    <input type="password" class="input-text" id="email" placeholder="E-mail 를 입력하세요.">
                </div>

                <div class="label-box">
                    <label class="input-label" for="phone"> 연락처: </label>
                    </br>
                    <input type="password" class="input-text" id="phone" placeholder="연락처를 입력하세요.">
                </div>

                <div class="label-box">
                    <label class="input-label" for="address"> 주소: </label>
                    </br>
                    <input type="password" class="input-text" id="address" placeholder="주소를 입력하세요.">
                </div>

                <div class="spare-box m0 p0"></div>
                <div class="spare-box m0 p0"></div>
                <div class="btn-box">
                    <a class="btn-primary mb-5" id="register">회원가입</a>
                </div>

            </div>
            <div class="image-box"></div>
        </div>
    </body>

</html>
