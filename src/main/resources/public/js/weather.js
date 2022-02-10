/*Spring MVC web application that makes a REST API call to (api.weatherstack.com) to retrieve the local weather forecast*/
 $(document).ready(function() {
          $.ajax({
           url:"http://api.weatherstack.com/current?access_key=0b3877195ce4032fb14c5106afaceb21&query=Boston"
           }).then(function(data){
           $('.location-country').append(data.location.country);
           $('.location-name').append(data.location.name);
           $('.current-temp').append(data.current.temperature);
           $("<img>").attr("src", data.current.weather_icons[0]).appendTo("#weather-icon");
          });
        });