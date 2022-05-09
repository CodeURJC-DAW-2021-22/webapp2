
var densityCanvas = document.getElementById("densityChart");

Chart.defaults.global.defaultFontFamily = "Lato";
Chart.defaults.global.defaultFontSize = 18;

var densityData = {
    label: 'Density of Planets (kg/m3)',
    data: [5427, 5243, 5514, 3933, 1326, 687, 1271, 1638]
};

var barChart = new Chart(densityCanvas, {
    type: 'bar',
    data: {
        labels: ["Boxeo", "Moda y acesorios", "Informática", "Imagen y sonido", "Hogar y jardin", "Automóviles", "Libros", "Otros"],
        datasets: [densityData]
    }
});