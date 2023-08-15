base = {};

base.ajax = function (opt) {
    if ( opt.url === undefined) {
        return 'url 주소를 입력하세요.';
    }

    $.ajax({
        type: opt.type === undefined ? 'post' : opt.type,
        url: opt.url,
        async: opt.async === undefined ? true : opt.async,
        dataType: opt.dataType === undefined ? '' : opt.dataType,
        data: opt.data
    })
    .done(function (data, textStatus, jqXHR) {
        if (opt.done != undefined ) opt.done(data, textStatus);
    })
    .fail(function (data, textStatus, errorThrown) {
        if (opt.fail != undefined ) opt.fail(data, textStatus);
    });
}

