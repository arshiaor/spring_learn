var chartDataStr = decodeHtml(chartData); //chartData comes from home.html which comes from model in home controller
var chartJsonArray =JSON.parse(chartDataStr); //parse the decoded string to json

var arrayLength =chartJsonArray.length;

var numericData = [];
var labelData = [];

for (var i=0;i<arrayLength;i++){
    numericData[i] = chartJsonArray[i].value;
    labelData[i] = chartJsonArray[i].label;
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            lable: 'My First Dataset',
            backgroundColor: ["#3e95cd","#8e5ea2","#3cba9f"],
            borderColor: 'rgb(255,999,132)',
            data: numericData
        }]
    },
    options: {
        title: {
            display: true,
            text: 'Project Statuses'
        }
    }
});

//to decode he json file
//[{"value":1, "label": "COMPLETED"},{"value":2, "label": "INPROGRESS"},{"value":1, "label": "NOTSTARTED"}]
function decodeHtml(html) {
   var txt= document.createElement("textarea");
   txt.innerHTML = html;
   return txt.value;
}