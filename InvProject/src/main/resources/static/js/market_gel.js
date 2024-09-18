//股票大盤指數
<<<<<<< HEAD
$.ajax({
    type: "get",
    url: "/json/markert_general.json",
    dataType: "json",
    success: showgolddata,
});

function showgolddata(data) {
    console.log(data);
    console.log(data.length);

    var pricelData = [];
    for (let key = 0; key < data.length; key++) {
        pricelData.push(data[key]["FormosaIndex"]);

    }

    //新增mychart 稍後添加在new Chart (ctd)
    var mychart;

    console.log(pricelData);
    const ctd = document.getElementById('chart_genl');
    mychart = new Chart(ctd, {
        type: 'bar',
        data: {
            labels: ["0701",
                "0702",
                "0703",
                "0704",
                "0705",
                "0708",
                "0709",
                "0710",
                "0711",
                "0712",
                "0715",
                "0716",
                "0717",
                "0718",
                "0719",
                "0722",
                "0723",
                "0726"
            ],
            datasets: [{
                label: '大盤指數',
                backgroundColor: 'rgb(255,99,132)',
                borderColor: 'rgb(122,99,132)',
                data: pricelData,
                borderWidth: 3
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }

    });

};

//更改圖表
mychart.config.type = "bar";
=======
        $.ajax({
            type: "get",
            url: "/json/markert_general.json",
            dataType: "json",
            success: showgolddata,
        });

        function showgolddata(data) {
            console.log(data);
            console.log(data.length);

            var pricelData = [];
            for(let key=0;key<data.length;key++){               
                pricelData.push(data[key]["FormosaIndex"]);

            }

            console.log(pricelData);
            const ctd = document.getElementById('chart_genl');
            new Chart(ctd, {
                type: 'line',
                data: {
                    labels: ["0701",
                             "0702",
                             "0703",
                             "0704",
                             "0705",
                             "0708",
                             "0709",
                             "0710",
                             "0711",
                             "0712",
                             "0715",
                             "0716",
                             "0717",
                             "0718",
                             "0719",
                             "0722",
                             "0723",
                             "0726"
                            ],
                    datasets: [{
                        label: '大盤指數',
                        backgroundColor: 'rgb(255,99,132)',
                        borderColor: 'rgb(122,99,132)',
                        data: pricelData,
                        borderWidth: 2
                    }]
                },

            });

        };
>>>>>>> 18b6bb26b2fd30be86b240a8235a54661ee62544
