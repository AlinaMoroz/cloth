import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'modal/DBcloth.dart';
import 'modal/user.dart';

class CreateStylePhotos extends StatefulWidget {
  final String idCloth;
  final Set<String> imageUrls;
  CreateStylePhotos.empty()
      : idCloth = '',
        imageUrls = Set<String>();


  CreateStylePhotos({required this.idCloth, required this.imageUrls});
  @override
  _CreateStylePhotosState createState() => _CreateStylePhotosState();
}

class _CreateStylePhotosState extends State<CreateStylePhotos> {


  Widget build(BuildContext context) {
    String assets1 = 'assets/images/base.jpg';
    String idCloth = widget.idCloth;
    Set<String> imageUrlss = widget.imageUrls;
    List<String> season = [];
    List<String> selectedPhotos = [];


    var user = Provider.of<User_>(context);


    Widget panelForPhoto() {
      List<String> imageUrlList = imageUrlss?.toList() ?? [];

      return Container(
        height: MediaQuery
            .of(context)
            .size
            .height * 5 / 12,
        width: MediaQuery
            .of(context)
            .size
            .width * 5 / 5,
        decoration: BoxDecoration(
          color: Colors.blueGrey.withOpacity(0.5),
          borderRadius: BorderRadius.circular(0),
          border: Border.all(color: Colors.white.withOpacity(0.5), width: 1),
        ),
        child: GridView.builder(
          gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: imageUrlList.length > 4 ? 3 : 2, // Количество элементов в строке
            mainAxisSpacing: 8, // Отступы между элементами по горизонтали
            crossAxisSpacing: 8, // Отступы между элементами по вертикали
          ),
          itemCount: imageUrlList.length,
          itemBuilder: (context, index) {
            String imageUrl = imageUrlList[index];
            return Container(
              margin: EdgeInsets.all(8),
              child: Image.network(
                imageUrl,
                fit: BoxFit.cover,
              ),
            );
          },
        ),
      );
    }
    void _goBackWithSetData() {
      Navigator.pop(context, imageUrlss);
    }

    Widget back() {
      return Container(
        child: IconButton(
          onPressed: () {
            _goBackWithSetData();
            // Код для обработки нажатия кнопки
          },
          icon: Icon(Icons.backspace_outlined,
              color: Color(0xFF33737D),
          ),
        ),
      );
    }


    Future<List<String>> getImage() async {

      season = await getPhotosByUIDAndSeason(user.uid1, idCloth);

      List<String> allCloth1 = await getPhotosByUIDAndCloth(user.uid1, idCloth);

      return allCloth1;
    }
    Widget buildImageGrid() {
      return FutureBuilder<List<String>>(
        future: getImage(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return CircularProgressIndicator();
          } else if (snapshot.hasError) {
            return Text('Ошибка: ${snapshot.error}');
          } else {
            List<String> all = snapshot.data ?? [];
            Set<String> imageUrls = widget.imageUrls ?? {};

            return Container(
              color: Color.fromRGBO(98, 104, 138, 0.5),
              padding: EdgeInsets.all(16),
              height: MediaQuery
                  .of(context)
                  .size
                  .height * 0.5,
              width: MediaQuery
                  .of(context)
                  .size
                  .width * 5 / 5,
              //width: MediaQuery.of(context).size.width * 0.5,
              child: GridView.builder(
                gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                  crossAxisCount: 3,
                  crossAxisSpacing: 8,
                  mainAxisSpacing: 8,
                  childAspectRatio: 1,
                ),
                itemCount: all.length,
                itemBuilder: (context, index) {
                  String photoUrl = all[index];
                  bool isSelected = imageUrls.contains(photoUrl);


                  return GestureDetector(
                    onTap: () {
                      setState(() {
                        if (isSelected) {
                          imageUrls.remove(photoUrl);
                        } else {
                          imageUrls.add(photoUrl);
                        }
                      });
                    },
                    child: Container(
                      key: ValueKey<String>(photoUrl),
                      child: Stack(
                        children: [
                          Center(
                            child: Container(
                              decoration: BoxDecoration(
                                border: Border.all(
                                  color: season == null ? Colors.white:
                                      season[index]=='0'? Color(0xFFA52A2A):
                                      season[index]=='1'? Colors.pink:
                                      season[index]=='2'? Colors.green:
                                      season[index]=='3'? Colors.blue:
                                      Colors.white,

                                  width: 2.0,
                                ),
                                borderRadius: BorderRadius.circular(8.0),
                              ),
                              child: Image.network(
                                photoUrl,
                                fit: BoxFit.cover,
                              ),
                            ),
                          ),
                          if (isSelected)
                            Positioned.fill(
                              child: Align(
                                alignment: Alignment.topRight,
                                child: Icon(
                                  Icons.check_circle,
                                  color: Colors.green,
                                ),
                              ),
                            ),
                        ],
                      ),
                    ),
                  );
                },
              ),
            );
          }
        },
      );
    }

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: Container(
          decoration: BoxDecoration(
            color: Colors.cyanAccent.withOpacity(0.1),
            image: DecorationImage(
              image: AssetImage(assets1),
              fit: BoxFit.cover,
            ),
          ),
          child: Column(
            children: [
              Expanded(
                child: SingleChildScrollView(
                  child: Column(
                    children: [
                      panelForPhoto(),
                      buildImageGrid(),
                      back(),
                    ],
                  ),
                ),
              ),
            ],
          ),
        ),

      ),
    );
  }

}