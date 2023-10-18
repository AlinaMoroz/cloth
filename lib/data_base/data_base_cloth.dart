import 'dart:io';
import 'package:firebase_storage/firebase_storage.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:path/path.dart';

Future<void> uploadDataToFirebase(
    File imageFile, String season, String typeCloth, String uid) async {
  String fileName = basename(imageFile.path);

  // Сохранение изображения в Firebase Storage
  Reference firebaseStorageRef =
  FirebaseStorage.instance.ref().child('images/$uid/$fileName');
  UploadTask uploadTask = firebaseStorageRef.putFile(imageFile);
  TaskSnapshot taskSnapshot = await uploadTask.whenComplete(() => null);
  String imageUrl = await taskSnapshot.ref.getDownloadURL();

  // Сохранение данных в Firebase Firestore
  CollectionReference collectionRef =
  FirebaseFirestore.instance.collection('your_collection_name');
  await collectionRef.doc(uid).set({
    'image_url': imageUrl,
    'season': season,
    'typeCloth': typeCloth,
  });



}
