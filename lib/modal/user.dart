import 'package:firebase_auth/firebase_auth.dart';
class User_{
  String uid = '';
  String get uid1 {
    return uid;
  }


  User_();

  factory User_.fromFirebase(User? user) {
    if (user != null) {
      return User_()..uid = user.uid;
    } else {
      return User_();
    }
  }





}