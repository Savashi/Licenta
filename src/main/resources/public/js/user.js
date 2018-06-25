var entities;
$(document).ready(function(){
    entities = $("#filter-placeholder option");
    if ($('#example-filter-placeholder').length != 0) {
        $('[data-toggle="tooltip"]').tooltip();
        $('#example-filter-placeholder').multiselect({
            enableFiltering: true,
            filterPlaceholder: 'Select a friend',
            enableCaseInsensitiveFiltering: true
        });
        $(".glyphicon-pencil").click(maketable);
        filterEntities();
        $("#domain").change(filterEntities);
    }
});
function maketable() {
    var data = {};
    $("#table tbody tr").each(function(){
        var id = $(this).attr("id");
        id=id.substring(0, id.indexOf("--"))
        var rating = $(this).find("input").val();
        data[id] = rating;
    });
    $("#table").remove();
    var table = "<table id='table' class='table'>";
    table += '<thead><tr><th>Title</th><th>Rating</th></tr></thead><tbody>'
        $("#filter-placeholder option:selected").each(function() {
           var value = $(this).val();
           value = value.split("--");
           var id = value[0];
           var classname = value[1];
           var title = value[2];
           var type = value[3];
           var rating = value[4];
           var result=id + "--" + classname +  "--" + title + "--" + type;
           if (typeof data[id] != "undefined") {
               rating = data[id];
           }
           table += "<tr id='" + result + "'><td>" + title + "</td><td><input min='1' max='10' type='number' value='" + rating + "'/></td></tr>";
        });
    table += "</tbody></table>";
    $(".modal-body").append(table);
    $('#exampleModal').modal("show");
}

function deleteUser(id){
    $.ajax({
        type: 'POST',
        url: '/removeuser?' + $.param({"id":id}),
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

function submitme() {
    var result="";
    $("#table tbody tr").each(function(){
        var id= $(this).attr("id");
        var rating = $(this).find("input").val();
        result+= id + "--" + rating+ ",";
    });
    if(result.length>0){
        result=result.substring(0,result.length-1);
    }
    $("#ratings").val(result);
    $("#form").submit();
}
function filterEntities() {
    var domain = $("#domain option:selected").val();
    $("#filter-placeholder option").remove();
    for (var i = 0; i <entities.length;i++) {
        var entity = $(entities[i]).val();
        var entityS = entity.split("--");
        if (entityS[1]==domain){
            var selected = $(entities[i]).is(":selected") ? "selected" : "";
            $("#filter-placeholder").append("<option value=" + entity + " " + selected + ">" + entityS[2] + "</option>>");
        }
    }
    $('#filter-placeholder').multiselect('destroy');
    createMulti();
}
function createMulti() {
    if ($('#example-filter-placeholder').length != 0) {
        $('#filter-placeholder').multiselect({
            enableFiltering: true,
            filterPlaceholder: 'Select an entity',
            enableCaseInsensitiveFiltering: true
        });
    }
}