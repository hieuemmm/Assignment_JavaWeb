const onClickViewContents = () => {
    $.ajax({
        type: "get", //Get, Post, put
        url: "./view-contents.html",
        dataType: "html", //HTML, Json, xml
        success: function (data, textStatus, jqXHR) {
            //Function
            let LoadData = (data) => {
                document.getElementById("body-content").innerHTML = data;
            }
            let timerInit = 4;
            //Repeat every one second, max 5
            let downloadTimer = setInterval(() => {
                if (timerInit <= 0) {
                    LoadData(data);
                    clearInterval(downloadTimer);
                } else {
                    LoadData(`<h3>Loading ${timerInit--}s</h3>`);
                }
            }, 1000);
        },
        error: function (xhr) { },
        statusCode: {
            404: function () {
                alert("Page not found");
            }
        },
    });



}