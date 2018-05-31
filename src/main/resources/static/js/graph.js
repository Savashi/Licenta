function loadGraph(){
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getGraph",
        async: false,
        success: function (result) {
            console.log(result);
            var nodes = new vis.DataSet(
                result.nodeDTOList
            )

            // create an array with edges
            var edges = new vis.DataSet(
                result.edgeDTOList
            );

            // create a network
            var container = document.getElementById('mynetwork');
            var data = {
                nodes: nodes,
                edges: edges
            };
            var options = {
                nodes: {borderWidth: 2},
                interaction: {hover: true}
            }
            var network = new vis.Network(container, data, options);

        },
        error: function (e) {

          console.log(e);
          return {};

        }
    });
}