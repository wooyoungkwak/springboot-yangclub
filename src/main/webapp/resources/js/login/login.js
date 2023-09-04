$(function (){


    let moveDashboard = function () {
        location.href = "/dashboard";
    }

    $('#login').on('click', function (){
        let id = $('#id').val();
        let pw = $('#pw').val();

        // $.ajaxJJ();

        moveDashboard();
    }) ;
})();