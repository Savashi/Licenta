function loadGraph() {
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

            network.on("click", function (params) {
                var userid = params.nodes[0];
                if (userid.indexOf("u_") != -1) {
                    $("#results").hide();
                    userid = userid.replace("u_", "");
                    $.ajax({
                        type: "POST",
                        contentType: "application/json",
                        url: "/getresultlist?id=" + userid,
                        async: false,
                        success: function (result) {
                            console.log(result);
                            $("#salut").text("Recommendations for " + result[0].currentUser + ":");
                            var content = "<ul>";
                            for (var i = 0; i< result.length; i++) {
                                var elem = result[i];
                                var recommended = "";
                                for (var k= 0; k< elem.recommended.length; k++) {
                                    var elem2 = elem.recommended[k];
                                    recommended += elem2.name + " AND ";
                                }
                                if (recommended.length >0) {
                                    recommended = recommended.substring(0, recommended.length - 5);
                                }
                                var covered = "";
                                for (var k= 0; k< elem.covered.length; k++) {
                                    var elem2 = elem.covered[k];
                                    covered += elem2.name + " AND ";
                                }
                                if (covered.length >0) {
                                    covered = covered.substring(0, covered.length - 5);
                                }
                                content += "<li>" + recommended + " from " + elem.userDO.surname + " " + elem.userDO.name + " because you watched " + covered +"</li>";
                            }
                            content += "</ul>";
                            $("#ceauo").html("");
                            $("#ceauo").append(content);
                            $("#results").toggle("slow");
                        },
                        error: function (e) {
                            console.log(e);
                            return {};

                        }
                    });
                }
            });

        },
        error: function (e) {

            console.log(e);
            return {};

        }
    });
}