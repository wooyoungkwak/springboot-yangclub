$(function () {

    let getData = function () {
        let id = $('#id').val();
        let password = $('#pw').val();
        let name = $('#name').val();
        let email = $('#email').val();
        let hp = $('#hp').val();
        let fax = $('#fax').val();

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
            hp: hp,
            fax: fax,
        }

        return data;
    };

    $('#register').on('click', function () {
        let data = getData();

        if (data === true) {
            return;
        }

        $.fn.ajaxJJ({
            type: 'post',
            url: '/login/register',
            data: JSON.stringify(data),
            done: function (resultData, status) {
                console.log(JSON.stringify(resultData));
                if (resultData.data == "true" ) {
                    alert("등록되었습니다. ");
                } else {
                    alert(resultData.message);
                }
                // load("/login");
            },
            fail: function (resultData, status) {
                alert("등록 실패하였습니다. (  " + JSON.stringify(resultData) + "  ) :: status = " + status);
            }
        });
    });

});