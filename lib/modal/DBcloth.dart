import 'dart:io';
import 'dart:typed_data';
import 'package:firebase_storage/firebase_storage.dart' as firebase_storage;
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:path/path.dart';





Future<void> uploadDataToFirebase(
    File imageFile, String
    season, String cloth, String uid) async {
  String fileName = basename(imageFile.path);

  // Сохранение изображения в Firebase Storage
  firebase_storage.Reference firebaseStorageRef =
  firebase_storage.FirebaseStorage.instance.ref().child(
      'images/$uid/$fileName');
  firebase_storage.UploadTask uploadTask = firebaseStorageRef.putFile(
      imageFile);
  firebase_storage.TaskSnapshot taskSnapshot = await uploadTask
      .whenComplete(() => null);
  String imageUrl = await taskSnapshot.ref.getDownloadURL();

  // Сохранение данных в Firebase Firestore
  CollectionReference collectionRef =
  FirebaseFirestore.instance.collection('your_collection_name');
  DocumentReference docRef = collectionRef.doc(uid).collection('all_cloth').doc();
  await docRef.set({
    'image_url': imageUrl,
    'season': season,
    'cloth': cloth,
  });
}

Future<File> convertUint8ListToFile(Uint8List data) async {
  final tempDir = await Directory.systemTemp.create();
  final tempFile = File('${tempDir.path}/${DateTime.now().millisecondsSinceEpoch}.jpg');
  await tempFile.writeAsBytes(data);
  return tempFile;
}

Future<List<String>> getPhotosByUIDAndSeason(String uid, String cloth) async {
  List<String> photoUrls = [];

  QuerySnapshot querySnapshot = await FirebaseFirestore.instance
      .collection('your_collection_name')
      .doc(uid)
      .collection('all_cloth')
      .where('cloth', isEqualTo: cloth)
      .get();

  querySnapshot.docs.forEach((doc) {
    Map<String, dynamic>? data = doc.data() as Map<String, dynamic>?;

    if (data != null && data.containsKey('season')) {
      String photoUrl = data['season'];
      photoUrls.add(photoUrl);
    }
  });

  return photoUrls;
}



Future<List<String>> getPhotosByUIDAndCloth(String uid, String cloth) async {
  List<String> photoUrls = [];

  QuerySnapshot querySnapshot = await FirebaseFirestore.instance
      .collection('your_collection_name')
      .doc(uid)
      .collection('all_cloth')
      .where('cloth', isEqualTo: cloth)
      .get();

  querySnapshot.docs.forEach((doc) {
    Map<String, dynamic>? data = doc.data() as Map<String, dynamic>?;

    if (data != null && data.containsKey('image_url')) {
      String photoUrl = data['image_url'];
      photoUrls.add(photoUrl);
    }
  });

  return photoUrls;
}
void addDocument(String uid, String nameCollection, Set<String> links) async {
  final String collectionName = 'your_collection_name';

  try {
    // Получите ссылку на коллекцию 'your_collection_name'
    final CollectionReference collectionRef =
    FirebaseFirestore.instance.collection(collectionName);

    // Получите ссылку на документ в коллекции 'your_collection_name/uid/all_Collection'
    final DocumentReference docRef =
    collectionRef.doc(uid).collection('all_Collection').doc();

    // Создайте новый документ с данными
    await docRef.set({
      'nameCollection': nameCollection,
      'links': links.toList(),
    });

    print('Документ успешно добавлен.');
  } catch (error) {
    print('Ошибка при добавлении документа: $error');
  }
}
Future<List<DocumentSnapshot>> getDocumentsByUid(String uid) async {
  final String collectionName = 'your_collection_name';

  try {
    // Получите ссылку на коллекцию 'your_collection_name/uid/all_Collection'
    final CollectionReference collectionRef =
    FirebaseFirestore.instance.collection(collectionName).doc(uid).collection('all_Collection');

    // Получите все документы с фильтром по полю uid
    final QuerySnapshot snapshot = await collectionRef.get();

    // Верните список всех документов
    return snapshot.docs;
  } catch (error) {
    print('Ошибка при получении документов: $error');
    return [];
  }
}

