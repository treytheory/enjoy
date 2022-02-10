/*Spring MVC web application that takes latitude and longitude as inputs, makes a REST API call to National Weather Service API 
Web Service (https://api.weather.gov/points/{latitude},{longitude}) to retrieve the grid end points*/
 $(document).ready(function() {
          $.ajax({
           url:"https://api.weather.gov/points/42.3586,-71.0567"
           }).then(function(data){
           $('.location-city').append(data.properties.relativeLocation.properties.city);
           $('.location-state').append(data.properties.relativeLocation.properties.state);
          });
        });