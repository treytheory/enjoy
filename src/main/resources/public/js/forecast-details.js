/*Makes REST API call to National Weather 
Service API (https://api.weather.gov/gridpoints/{office}/{grid X},{grid Y}/forecast) to retrieve and display the forecast results.*/
 $(document).ready(function() {
          $.ajax({
           url:"https://api.weather.gov/gridpoints/BOX/70,76/forecast/hourly"
           }).then(function(data){
           $('.forecast-temp').append(data.properties.periods[0].temperature);
           $('.forecast-speed').append(data.properties.periods[0].windSpeed);
           $('.forecast-direction').append(data.properties.periods[0].windDirection);
           $('.forecast-short').append(data.properties.periods[0].shortForecast);
           $("<img>").attr("src", data.properties.periods[0].icon).appendTo("#forecast-icon");
          });
        });