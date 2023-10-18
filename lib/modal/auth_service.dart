import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/cupertino.dart';
import 'package:shuffle1/modal/user.dart';


class AuthService{
  final FirebaseAuth firebaseAuth = FirebaseAuth.instance;


//Вход
  Future<User_?> signIn(String email,String password) async{

    try{
      UserCredential result = await firebaseAuth.signInWithEmailAndPassword(email: email, password: password);
      User? user = result.user;
      return User_.fromFirebase(user!);
    }
    catch(e){
      print(e);
      return null;
    }
  }
//Регистрация
  Future<User_?> registerIn(String email,String password) async{
    try{
      UserCredential result = await firebaseAuth.createUserWithEmailAndPassword(email: email, password: password);
      User? user = result.user;
      return User_.fromFirebase(user!);
    }
    catch(e){
      print(e);
      return null;
    }

  }


  Future logOut() async{
    await firebaseAuth.signOut();

  }

  Stream<User_> get currentUser {
    return firebaseAuth.authStateChanges().map((User? user) {
      if (user != null) {
        return User_.fromFirebase(user);
      } else {
        return User_(); // Возвращаем пустой экземпляр User_ при отсутствии пользователя
      }
    });
  }

}