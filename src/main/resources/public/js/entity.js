function deleteElement(id){
    $.ajax({
        type: 'POST',
        url: '/removentity?' + $.param({"id":id}),
        success: function(result) {
            if (result.indexOf("success") != -1) {
                $("#" + id).remove();
            }
        },
        error: function(e){
            console.log(e);
            return {};
        }
    });
}