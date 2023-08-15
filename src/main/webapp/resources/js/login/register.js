$(function () {

    let getData = function () {
        let id = $('#id').val();
        let password = $('#pw').val();
        let name = $('#name').val();
        let email = $('#email').val();
        let phone = $('#phone').val();
        let address = $('#address').val();

        if (id.length === 0) {
            alert("ID 를 입력하세요.");
            return true;
        }

        if (password.length === 0) {
            alert("ID 를 입력하세요.");
            return true;
        }

        let data = {
            id: id,
            password: password,
            name: name,
            email: email,
            phone: phone,
            address: address,
        }

        return data;
    };

    $('#register').on('click', function () {
        let data = getData();
        if (data == true) {
            return;
        }

        base.ajax({
            type: 'post',
            url: '/login/register',
            data: data,
            done: function (data, status) {
                alert("등록되었습니다.");
                load("/login");
            },
            fail: function (data, status) {
                alert("등록 실패하였습니다. (" + data + ")");
            }
        });
    });

});