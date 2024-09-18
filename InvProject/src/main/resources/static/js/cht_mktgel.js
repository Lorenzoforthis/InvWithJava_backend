//股票大盤指數
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
            const chartMarket = document.getElementById('chart_genl');
            new Chart(chartMarket, {
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
