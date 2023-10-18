// class Weather{
//   String? cityName;
//   double? temp;
//   double? wind;
//   int? humidity;
//   double? fells_like;
//   int? pressure;
//
//   Weather(
//       {this.cityName,
//       this.temp,
//       this.wind,
//       this.humidity,
//       this.fells_like,
//       this.pressure});
//
//   Weather.fromJson(Map<String, dynamic> json){
//     cityName = json["location"]["name"];
//     temp = json["current"]["temp_c"];
//     wind = json["wind_mph"];
//     // pressure = json["main"]["pressure"];
//     // humidity = json["main"]["humidity"];
//     // fells_like = json["main"]["fells_like"];
//   }
//
// }
// class Weather {
//   String? cityName;
//   double? temp;
//   String? conditionText;
//   String? conditionIcon;
//   double? windSpeed;
//   String? windDirection;
//
//   Weather({
//     this.cityName,
//     this.temp,
//     this.conditionText,
//     this.conditionIcon,
//     this.windSpeed,
//     this.windDirection,
//   });
//
//   factory Weather.fromJson(Map<String, dynamic> json) {
//     return Weather(
//       cityName: json['location']['name'],
//       temp: json['current']['temp_c'],
//       conditionText: json['current']['condition']['text'],
//       conditionIcon: json['current']['condition']['icon'],
//       windSpeed: json['current']['wind_kph'],
//       windDirection: json['current']['wind_dir'],
//     );
//   }
//
//   String getFullConditionIconUrl() {
//     if (conditionIcon != null && conditionIcon!.startsWith('//')) {
//       return 'https:$conditionIcon';
//     }
//     return '';
//   }
// }
// Ваш класс Weather
// class Weather {
//   double? tempC;
//   String? conditionText;
//   String? conditionIcon;
//   double? windMph;
//   double? pressureMb;
//   int? humidity;
//   double? feelsLikeC;
//   Weather({
//     this.tempC,
//     this.conditionText,
//     this.conditionIcon,
//     this.windMph,
//     this.pressureMb,
//     this.humidity,
//     this.feelsLikeC,
//   });
//
//   // Конструктор и другие методы
//
//   // Пример парсинга JSON в объект Weather
//   factory Weather.fromJson(Map<String, dynamic> json) {
//     return Weather(
//       tempC: json['current']['temp_c'],
//       conditionText: json['current']['condition']['text'],
//       conditionIcon: json['current']['condition']['icon'],
//       windMph: json['current']['wind_mph'],
//       pressureMb: json['current']['pressure_mb'],
//       humidity: json['current']['humidity'],
//       feelsLikeC: json['current']['feelslike_c'],
//     );
//   }
//   String getFullConditionIconUrl() {
//     if (conditionIcon != null && conditionIcon!.startsWith('//')) {
//       return 'https:$conditionIcon';
//     }
//     return '';
//   }
// }
class Weather {
  String? cityName;
  double? tempC;
  String? conditionText;
  String? conditionIcon;
  double? windMph;
  double? pressureMb;
  int? humidity;
  double? feelsLikeC;

  Weather({
    this.cityName,
    this.tempC,
    this.conditionText,
    this.conditionIcon,
    this.windMph,
    this.pressureMb,
    this.humidity,
    this.feelsLikeC,
  });

  factory Weather.fromJson(Map<String, dynamic> json) {
    return Weather(
      cityName: json['location']['name'],
      tempC: json['current']['temp_c'],
      conditionText: json['current']['condition']['text'],
      conditionIcon: json['current']['condition']['icon'],
      windMph: json['current']['wind_mph'],
      pressureMb: json['current']['pressure_mb'],
      humidity: json['current']['humidity'],
      feelsLikeC: json['current']['feelslike_c'],
    );
  }
  String getFullConditionIconUrl() {
    if (conditionIcon != null && conditionIcon!.startsWith('//')) {
      return 'https:$conditionIcon';
    }
    return '';
  }
}