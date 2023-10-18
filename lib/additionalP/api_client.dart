import 'dart:convert';
import 'dart:typed_data';
import 'package:http/http.dart' as http;
import 'package:shuffle1/modal/weather_model.dart';




class ApiClient {
  Future<Uint8List> removeBgApi(String imagePath) async {
    var request = http.MultipartRequest(
        "POST", Uri.parse("https://api.remove.bg/v1.0/removebg"));
    request.files
        .add(await http.MultipartFile.fromPath("image_file", imagePath));
    request.headers.addAll({"X-API-Key": "9o298ocMdVdmgUyKY9HgVqVC"}); //Put Your API key HERE
    final response = await request.send();
    if (response.statusCode == 200) {
      http.Response imgRes = await http.Response.fromStream(response);
      return imgRes.bodyBytes;
    } else {
      print("-----------------------"+ '${response.statusCode}' );
      throw Exception("Error occurred with response ${response.statusCode}");

    }
  }
}

class WeatherApiClient{
  Future<Weather>? getCurrentWeather(String? location) async{
    var endpoint = Uri.parse(
        "http://api.weatherapi.com/v1/forecast.json?key=a89b85b90e9e4d74877122444230206&q=Moscow&days=7&aqi=no&alerts=no");
    var response = await http.get(endpoint);
    var body = jsonDecode(response.body);
    print(Weather.fromJson(body).cityName);
    return Weather.fromJson(body);

  }
}