new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: ['January', 'february','March'],
        datasets: [{
            lable: 'My First Dataset',
            backgroundColor: ["#3e95cd","#8e5ea2","#3cba9f"],
            borderColor: 'rgb(255,999,132)',
            data: [15,10,5]
        }]
    },
    options: {}
});