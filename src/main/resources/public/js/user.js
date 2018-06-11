$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
    $('#example-filter-placeholder').multiselect({
        enableFiltering: true,
        filterPlaceholder: 'Select a friend',
        enableCaseInsensitiveFiltering: true
    });
    $('#filter-placeholder').multiselect({
        enableFiltering: true,
        filterPlaceholder: 'Select an entity',
        enableCaseInsensitiveFiltering: true
    });
    $(".glyphicon-pencil").click(maketable);
});
function maketable() {
    var data = {};
    $("#table tbody tr").each(function(){
        var id = $(this).find("td:eq(0)").text();
        var rating = $(this).find("input").val();
        data[id] = rating;
    });
    $("#table").remove();
    var table = "<table id='table' class='table'>";
    table += '<tr><th>ID</th><th>Title</th><th>Rating</th></tr>'
        $("#filter-placeholder option:selected").each(function() {
           var value = $(this).val();
           value = value.split("--");
           var id = value[0];
           var title = value[2];
           var rating = value[4];
           if (typeof data[id] != "undefined") {
               rating = data[id];
           }
           table += "<tr><td>" + id + "</td><td>" + title + "</td><td><input min='1' max='10' type='number' value='" + rating + "'/></td></tr>";
        });
    table += "</table>";
    $(".modal-body").append(table);
    $('#exampleModal').modal("show");
}