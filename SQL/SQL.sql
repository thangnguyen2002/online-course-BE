use course_saling_web;

ALTER TABLE app_user MODIFY COLUMN password VARCHAR(255);

insert into app_user value(1,"Ha Nam","https://anhcuoiviet.vn/wp-content/uploads/2023/02/avatar-ngau-nu-3.jpg","2003-03-03","Dep trai","nghiep1409@gmail.com","Nguyen Cong Nghiep","123456","0967870785",1,"congnghiep");
insert into app_user value(2,"Hai Phong","https://anhcuoiviet.vn/wp-content/uploads/2023/02/avatar-ngau-nu-3.jpg","1996-06-06","Xinh gai","hoithu96@gmail.com","Nguyen Thu Hoi","123456","0987654321",1,"thuhoi");
insert into app_user value(3,"Ha Noi","https://anhcuoiviet.vn/wp-content/uploads/2023/02/avatar-ngau-nu-3.jpg","1997-06-06","Dep trai","conganh97@gmail.com","Bui Cong Anh","123456","0912345678",1,"conganh");
insert into app_user value(4,"Ha Noi","https://anhcuoiviet.vn/wp-content/uploads/2023/02/avatar-ngau-nu-3.jpg","1999-06-06","Dep trai","minhduong99@gmail.com","Tran Minh Duong","123456","0923456789",1,"minhduong");
insert into app_user value(5,"Nam Dinh","https://anhcuoiviet.vn/wp-content/uploads/2023/02/avatar-ngau-nu-3.jpg","1999-06-06","Dep trai","duylong99@gmail.com","Hoang Tran Duy Long","123456","0923456788",1,"duylong");
insert into app_user value(6,"Nam Dinh","https://anhcuoiviet.vn/wp-content/uploads/2023/02/avatar-ngau-nu-3.jpg","1999-06-06","Dep trai","admin@gmail.com","ADMIN","123456","0923456788",1,"adminnhom5");

insert into role value(1, "ROLE_ADMIN");
insert into role value(2, "ROLE_USER");



insert into app_user_roles value(6,1);
insert into app_user_roles value(5,2);
insert into app_user_roles value(4,2);
insert into app_user_roles value(3,2);
insert into app_user_roles value(2,2);
insert into app_user_roles value(1,2);


insert into quiz value(1,"Test N5",5,20);
insert into quiz value(2,"Test N4",5,20);
insert into quiz value(3,"Test N3",5,20);
insert into quiz value(4,"Test N2",5,20);
insert into quiz value(5,"Test N1",5,20);

insert into question value(1,"あおい","くろい","あかい","しろい","しろい","あの　（　白い　）　たてものはレストランです。",1);
insert into question value(2,"いえ","みち","みせ","えき","えき","（　駅　）　まえでともだちにあいました",1);
insert into question value(3,"けん","ほん","はん","にん","ほん","きのう、　（　本　）　をかいました",1);
insert into question value(4,"あい","はは","ちち","あね","はは","（　母　）　とかいものにいきます",1);
insert into question value(5,"ごひゃく","ごぴゃく","ごひゃっく","ごしゃく","ごひゃく","きっぷはいちまい ( 五百 ) 円です",1);

insert into question value(6,"ひこき","ひこきい","ひっこき","ひこうき","ひこうき","台風のために ( 飛行機 ) はおくれて出発しました",2);
insert into question value(7,"ちょぐせつ","ちょくせつ","ちょぐぜつ","ちょくぜつ","ちょくせつ","電話てなく　（　直接　）　お会いしてお話したいのですが。。。",2);
insert into question value(8,"びじゅつ","びじぇつ","びっじゅつ","びしゅつ","びじゅつ","今町の　（　美術　）　館に子どもたちの作品がかざられています",2);
insert into question value(9,"りょうこう","りょこお","りょこう","りょごう","りょこう","弟は今ヨーロッパを　（　旅行　）　しています。",2);
insert into question value(10,"はっおん","はつおん","はちおん","ばつおん","はつおん","日本語の　（　発音　）　は英語よりやさしいです。",2);

insert into question value(11,"ひこき","ひこきい","ひっこき","ひこうき","ひこうき","台風のために ( 飛行機 ) はおくれて出発しました",3);
insert into question value(12,"ちょぐせつ","ちょくせつ","ちょぐぜつ","ちょくぜつ","ちょくせつ","電話てなく　（　直接　）　お会いしてお話したいのですが。。。",3);
insert into question value(13,"びじゅつ","びじぇつ","びっじゅつ","びしゅつ","びじゅつ","今町の　（　美術　）　館に子どもたちの作品がかざられています",3);
insert into question value(14,"りょうこう","りょこお","りょこう","りょごう","りょこう","弟は今ヨーロッパを　（　旅行　）　しています。",3);
insert into question value(15,"はっおん","はつおん","はちおん","ばつおん","はつおん","日本語の　（　発音　）　は英語よりやさしいです。",3);

insert into question value(16,"ひこき","ひこきい","ひっこき","ひこうき","ひこうき","台風のために ( 飛行機 ) はおくれて出発しました",4);
insert into question value(17,"ちょぐせつ","ちょくせつ","ちょぐぜつ","ちょくぜつ","ちょくせつ","電話てなく　（　直接　）　お会いしてお話したいのですが。。。",4);
insert into question value(18,"びじゅつ","びじぇつ","びっじゅつ","びしゅつ","びじゅつ","今町の　（　美術　）　館に子どもたちの作品がかざられています",4);
insert into question value(19,"りょうこう","りょこお","りょこう","りょごう","りょこう","弟は今ヨーロッパを　（　旅行　）　しています。",4);
insert into question value(20,"はっおん","はつおん","はちおん","ばつおん","はつおん","日本語の　（　発音　）　は英語よりやさしいです。",4);

insert into question value(21,"ひこき","ひこきい","ひっこき","ひこうき","ひこうき","台風のために ( 飛行機 ) はおくれて出発しました",5);
insert into question value(22,"ちょぐせつ","ちょくせつ","ちょぐぜつ","ちょくぜつ","ちょくせつ","電話てなく　（　直接　）　お会いしてお話したいのですが。。。",5);
insert into question value(23,"びじゅつ","びじぇつ","びっじゅつ","びしゅつ","びじゅつ","今町の　（　美術　）　館に子どもたちの作品がかざられています",5);
insert into question value(24,"りょうこう","りょこお","りょこう","りょごう","りょこう","弟は今ヨーロッパを　（　旅行　）　しています。",5);
insert into question value(25,"はっおん","はつおん","はちおん","ばつおん","はつおん","日本語の　（　発音　）　は英語よりやさしいです。",5);

insert into question value(26,"ひこき","ひこきい","ひっこき","ひこうき","ひこうき","台風のために ( 飛行機 ) はおくれて出発しました",6);
insert into question value(27,"ちょぐせつ","ちょくせつ","ちょぐぜつ","ちょくぜつ","ちょくせつ","電話てなく　（　直接　）　お会いしてお話したいのですが。。。",6);
insert into question value(28,"びじゅつ","びじぇつ","びっじゅつ","びしゅつ","びじゅつ","今町の　（　美術　）　館に子どもたちの作品がかざられています",6);
insert into question value(29,"りょうこう","りょこお","りょこう","りょごう","りょこう","弟は今ヨーロッパを　（　旅行　）　しています。",6);
insert into question value(30,"はっおん","はつおん","はちおん","ばつおん","はつおん","日本語の　（　発音　）　は英語よりやさしいです。",6);

insert into question value(31,"ひこき","ひこきい","ひっこき","ひこうき","ひこうき","台風のために ( 飛行機 ) はおくれて出発しました",7);
insert into question value(32,"ちょぐせつ","ちょくせつ","ちょぐぜつ","ちょくぜつ","ちょくせつ","電話てなく　（　直接　）　お会いしてお話したいのですが。。。",7);
insert into question value(33,"びじゅつ","びじぇつ","びっじゅつ","びしゅつ","びじゅつ","今町の　（　美術　）　館に子どもたちの作品がかざられています",7);
insert into question value(34,"りょうこう","りょこお","りょこう","りょごう","りょこう","弟は今ヨーロッパを　（　旅行　）　しています。",7);
insert into question value(35,"はっおん","はつおん","はちおん","ばつおん","はつおん","日本語の　（　発音　）　は英語よりやさしいです。",7);

insert into question value(36,"ひこき","ひこきい","ひっこき","ひこうき","ひこうき","台風のために ( 飛行機 ) はおくれて出発しました",8);
insert into question value(37,"ちょぐせつ","ちょくせつ","ちょぐぜつ","ちょくぜつ","ちょくせつ","電話てなく　（　直接　）　お会いしてお話したいのですが。。。",8);
insert into question value(38,"びじゅつ","びじぇつ","びっじゅつ","びしゅつ","びじゅつ","今町の　（　美術　）　館に子どもたちの作品がかざられています",8);
insert into question value(39,"りょうこう","りょこお","りょこう","りょごう","りょこう","弟は今ヨーロッパを　（　旅行　）　しています。",8);
insert into question value(40,"はっおん","はつおん","はちおん","ばつおん","はつおん","日本語の　（　発音　）　は英語よりやさしいです。",8);

insert into question value(41,"ひこき","ひこきい","ひっこき","ひこうき","ひこうき","台風のために ( 飛行機 ) はおくれて出発しました",9);
insert into question value(42,"ちょぐせつ","ちょくせつ","ちょぐぜつ","ちょくぜつ","ちょくせつ","電話てなく　（　直接　）　お会いしてお話したいのですが。。。",9);
insert into question value(43,"びじゅつ","びじぇつ","びっじゅつ","びしゅつ","びじゅつ","今町の　（　美術　）　館に子どもたちの作品がかざられています",9);
insert into question value(44,"りょうこう","りょこお","りょこう","りょごう","りょこう","弟は今ヨーロッパを　（　旅行　）　しています。",9);
insert into question value(45,"はっおん","はつおん","はちおん","ばつおん","はつおん","日本語の　（　発音　）　は英語よりやさしいです。",9);





insert into instructor value(1,"https://inkythuatso.com/uploads/thumbnails/800/2022/03/hinh-anh-avatar-dep-cho-con-gai-dai-dien-30-14-16-51.jpg","1996-06-06","thuhoi96@gmail.com",5,"There is a saying in Japanese that I like very much that is '継続は力なり', this sentence means that when you persevere continuously with something you will get results, it also implies that success Results do not come overnight, but come from a long process of effort. I find this sentence very true, especially in learning a foreign language in general and Japanese in particular. Learning Japanese well cannot be achieved based on temporary determination and heroic study in a day or two, but I think it must be based on habits, habits of studying Japanese every day. I also apply a lot of ways so that learning Japanese is not boring such as watching movies, watching the news, reading manga, or going out every day, pay attention to the Japanese sentences on signs, advertisements, .. .
 
I hope through the lessons with everyone will help everyone find the right way to learn effectively. See you all in my lessons.","Nguyen Thu Hoi","0987654321");
insert into instructor value(2,"https://inkythuatso.com/uploads/thumbnails/800/2022/03/hinh-anh-avatar-dep-cho-con-gai-dai-dien-30-14-16-51.jpg","1997-06-06","conganh97@gmail.com",3,"There is a saying in Japanese that I like very much that is '継続は力なり', this sentence means that when you persevere continuously with something you will get results, it also implies that success Results do not come overnight, but come from a long process of effort. I find this sentence very true, especially in learning a foreign language in general and Japanese in particular. Learning Japanese well cannot be achieved based on temporary determination and heroic study in a day or two, but I think it must be based on habits, habits of studying Japanese every day. I also apply a lot of ways so that learning Japanese is not boring such as watching movies, watching the news, reading manga, or going out every day, pay attention to the Japanese sentences on signs, advertisements, .. .
 
I hope through the lessons with everyone will help everyone find the right way to learn effectively. See you all in my lessons.","Bui Cong Anh","0912345678");
insert into instructor value(3,"https://inkythuatso.com/uploads/thumbnails/800/2022/03/hinh-anh-avatar-dep-cho-con-gai-dai-dien-30-14-16-51.jpg","1999-09-09","minhduong99@gmail.com",3,"There is a saying in Japanese that I like very much that is '継続は力なり', this sentence means that when you persevere continuously with something you will get results, it also implies that success Results do not come overnight, but come from a long process of effort. I find this sentence very true, especially in learning a foreign language in general and Japanese in particular. Learning Japanese well cannot be achieved based on temporary determination and heroic study in a day or two, but I think it must be based on habits, habits of studying Japanese every day. I also apply a lot of ways so that learning Japanese is not boring such as watching movies, watching the news, reading manga, or going out every day, pay attention to the Japanese sentences on signs, advertisements, .. .
 
I hope through the lessons with everyone will help everyone find the right way to learn effectively. See you all in my lessons.","Tran Minh Duong","0912345678");
insert into instructor value(4,"https://inkythuatso.com/uploads/thumbnails/800/2022/03/hinh-anh-avatar-dep-cho-con-gai-dai-dien-30-14-16-51.jpg","1995-09-09","nghiep1409@gmail.com",3,"There is a saying in Japanese that I like very much that is '継続は力なり', this sentence means that when you persevere continuously with something you will get results, it also implies that success Results do not come overnight, but come from a long process of effort. I find this sentence very true, especially in learning a foreign language in general and Japanese in particular. Learning Japanese well cannot be achieved based on temporary determination and heroic study in a day or two, but I think it must be based on habits, habits of studying Japanese every day. I also apply a lot of ways so that learning Japanese is not boring such as watching movies, watching the news, reading manga, or going out every day, pay attention to the Japanese sentences on signs, advertisements, .. .
 
I hope through the lessons with everyone will help everyone find the right way to learn effectively. See you all in my lessons.","Nguyen Cong Nghiep","0967870785");
insert into instructor value(5,"https://inkythuatso.com/uploads/thumbnails/800/2022/03/hinh-anh-avatar-dep-cho-con-gai-dai-dien-30-14-16-51.jpg","1999-09-09","duylong99@gmail.com",4,"There is a saying in Japanese that I like very much that is '継続は力なり', this sentence means that when you persevere continuously with something you will get results, it also implies that success Results do not come overnight, but come from a long process of effort. I find this sentence very true, especially in learning a foreign language in general and Japanese in particular. Learning Japanese well cannot be achieved based on temporary determination and heroic study in a day or two, but I think it must be based on habits, habits of studying Japanese every day. I also apply a lot of ways so that learning Japanese is not boring such as watching movies, watching the news, reading manga, or going out every day, pay attention to the Japanese sentences on signs, advertisements, .. .
 
I hope through the lessons with everyone will help everyone find the right way to learn effectively. See you all in my lessons.","Hoang Tran Duy Long","0967812345");
insert into instructor value(6,"https://inkythuatso.com/uploads/thumbnails/800/2022/03/hinh-anh-avatar-dep-cho-con-gai-dai-dien-30-14-16-51.jpg","2000-09-09","tinhteng2k@gmail.com",4,"There is a saying in Japanese that I like very much that is '継続は力なり', this sentence means that when you persevere continuously with something you will get results, it also implies that success Results do not come overnight, but come from a long process of effort. I find this sentence very true, especially in learning a foreign language in general and Japanese in particular. Learning Japanese well cannot be achieved based on temporary determination and heroic study in a day or two, but I think it must be based on habits, habits of studying Japanese every day. I also apply a lot of ways so that learning Japanese is not boring such as watching movies, watching the news, reading manga, or going out every day, pay attention to the Japanese sentences on signs, advertisements, .. .
 
I hope through the lessons with everyone will help everyone find the right way to learn effectively. See you all in my lessons.","Chu Thi Tinh","0967812345");



insert into course value(1,"Master the knowledge of N5: the entire vocabulary in 25 Mina no Nihongo lessons and about 800 words, more than 100 Kanji as a solid premise to learn to higher levels.


  Comprehensively learn 05 important skills to help you conquer JLPT with the highest score: Vocabulary, grammar, reading comprehension, Kanji.


  Proficiently apply 2 alphabets Hiragana, Katakana in learning vocabulary and knowledge from basic to advanced of N5.",0,"https://gojapan.vn/wp-content/uploads/2020/05/Japanese-N5.jpg","N5 Vocabulary Course",4,5,50,10,"N5 Vocabulary Course",1,2,1,1);
insert into course value(2,"Mastering the knowledge of N5: the entire grammar in 25 Mina no Nihongo lessons and about 800 words, more than 100 Kanji as a solid premise to learn to higher levels.


  Comprehensively learn 05 important skills to help you conquer JLPT with the highest score: Vocabulary, grammar, reading comprehension, Kanji.


  Proficiently apply 2 alphabets Hiragana, Katakana in learning vocabulary and knowledge from basic to advanced of N5.",0,"https://ichigo.edu.vn/wp-content/uploads/2017/09/5.jpg","N5 Grammar Course",4,5,100,10,"TN5 Grammar Course",1,3,2,1);
insert into course value(3,"Master the knowledge of N4: the entire vocabulary in 25 Mina no Nihongo lessons and about 800 words, more than 100 Kanji as a solid premise to learn to higher levels.


  Comprehensively learn 05 important skills to help you conquer JLPT with the highest score: Vocabulary, grammar, reading comprehension, Kanji.


  Proficiently apply 2 alphabets Hiragana, Katakana in learning vocabulary and knowledge from basic to advanced of N4.",0,"https://riki.edu.vn/library-n4-online/images/n4%20online%20anh-20.png","N4 Vocabulary Course",4,5,150,10,"N4 Vocabulary Course",1,6,3,1);
insert into course value(4,"Master the knowledge of N4: the entire grammar in 25 Mina no Nihongo lessons and about 800 words, more than 100 Kanji as a solid premise to learn to higher levels.


  Comprehensively learn 05 important skills to help you conquer JLPT with the highest score: Vocabulary, grammar, reading comprehension, Kanji.


  Proficiently apply 2 alphabets Hiragana, Katakana in learning vocabulary and knowledge from basic to advanced of N4.",0,"https://riki.edu.vn/wp-content/uploads/2021/09/To%CC%82%CC%89ng-ho%CC%9B%CC%A3p-toa%CC%80n-bo%CC%A3%CC%82-01.png","N4 Grammar Course",4,5,200,10,"N4 Grammar Course",1,4,5,1);
insert into course value(5,"Master the knowledge of N3: the entire vocabulary and about 800 words, more than 100 Kanji as a solid premise to learn to higher levels.


  Comprehensively learn 05 important skills to help you conquer JLPT with the highest score: Vocabulary, grammar, reading comprehension, Kanji.


  Proficiently apply 2 alphabets Hiragana, Katakana to learning vocabulary and knowledge from basic to advanced of N3.",0,"https://riki.edu.vn/wp-content/uploads/2021/08/A%CC%89nh-thumbnail-ba%CC%80i-vie%CC%82%CC%81t-N3-web-02-1-1.png","N3 Vocabulary Course",3,5,300,10,"N3 Vocabulary Course",1,6,6,1);
insert into course value(6,"Master the knowledge of N3: the entire grammar and about 800 words, more than 100 Kanji as a solid premise to learn to higher levels.


  Comprehensively learn 05 important skills to help you conquer JLPT with the highest score: Vocabulary, grammar, reading comprehension, Kanji.


  Proficiently apply 2 alphabets Hiragana, Katakana to learning vocabulary and knowledge from basic to advanced of N3.",0,"https://trungtamnhatngu.edu.vn/uploads/blog/2022_03/ngu-phap-n3-voi-ue.jpg","N3 Grammar Course",4,5,350,10,"N3 Grammar Course",1,7,5,1);
insert into course value(7,"
Master the knowledge of N2: the entire vocabulary and about 800 words, more than 100 Kanji as a solid premise to learn to higher levels.


  Comprehensively learn 05 important skills to help you conquer JLPT with the highest score: Vocabulary, grammar, reading comprehension, Kanji.


  Proficiently apply the 2 alphabets Hiragana, Katakana in learning vocabulary and knowledge from basic to advanced of N2.",0,"https://kosei.vn/uploads/T%E1%BA%A5t_t%E1%BA%A7n_t%E1%BA%ADt_t%E1%BB%AB_v%E1%BB%B1ng_N2_xu%E1%BA%A5t_hi%E1%BB%87n_trong_%C4%91%E1%BB%81_thi_JLPT_N2_12_2020-01.png","N2 Vocabulary Course",3,5,250,10,"N2 Vocabulary Course",1,5,4,1);
insert into course value(8,"Master the knowledge of N2: the entire grammar and about 800 words, more than 100 Kanji as a solid premise to learn to higher levels.


  Comprehensively learn 05 important skills to help you conquer JLPT with the highest score: Vocabulary, grammar, reading comprehension, Kanji.


  Proficiently apply the 2 alphabets Hiragana, Katakana in learning vocabulary and knowledge from basic to advanced of N2.",0,"https://nhatbao24h.net/wp-content/uploads/2020/03/ngu-phap-n2.jpg","N2 Grammar Course",3,5,350,10,"N2 Grammar Course",1,6,1,1);
insert into course value(9,"Master the knowledge of N1: the entire vocabulary, grammar and about 800 words, more than 100 Kanji as a solid premise to learn to higher levels.


  Comprehensively learn 05 important skills to help you conquer JLPT with the highest score: Vocabulary, grammar, reading comprehension, Kanji.


  Proficiently apply the 2 alphabets Hiragana, Katakana in learning vocabulary and knowledge from basic to advanced of N1.",0,"https://i.ytimg.com/vi/EE9NA5j-KDg/maxresdefault.jpg","Summary of all N1 vocabulary and grammar",3,5,100,10,"Summary of all N1 vocabulary and grammar",1,3,3,1);

insert into lesson value(1,"Beginner Japanese vocabulary N5 lesson 1","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai1.mp4?alt=media&token=5af41cc4-3cc3-459a-95a0-e13f2d362e6d","Lesson 1",'3:50',1);
insert into lesson value(2,"Beginner Japanese vocabulary N5 lesson 2","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai2.mp4?alt=media&token=3797f3f8-f65a-42c7-acd7-c1da7e55a4f9","Lesson 2",'4:09',1);
insert into lesson value(3,"Beginner Japanese vocabulary N5 lesson 3","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai3.mp4?alt=media&token=a965f904-3cca-43ad-858e-8c0c64441c0f","Lesson 3","3:47",1);
insert into lesson value(28,"Beginner Japanese vocabulary N5 lesson 4","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/flower.webm?","Lesson 4","0:07",1);
insert into lesson value(4,"Beginner Japanese Grammar N5 lesson 1","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai1.mp4?alt=media&token=5af41cc4-3cc3-459a-95a0-e13f2d362e6d","Lesson 1",'3:50',2);
insert into lesson value(5,"Beginner Japanese Grammar N5 lesson 2","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai2.mp4?alt=media&token=3797f3f8-f65a-42c7-acd7-c1da7e55a4f9","Lesson 2",'4:09',2);
insert into lesson value(6,"Beginner Japanese Grammar N5 lesson 3","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai3.mp4?alt=media&token=a965f904-3cca-43ad-858e-8c0c64441c0f","Lesson 3","3:47",2);
insert into lesson value(29,"Beginner Japanese Grammar N5 lesson 4","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/flower.webm?","Lesson 4","3:47",2);
insert into lesson value(7,"Japanese Vocabulary N4 lesson 1","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai1.mp4?alt=media&token=5af41cc4-3cc3-459a-95a0-e13f2d362e6d","Lesson 1",'3:50',3);
insert into lesson value(8,"Japanese Vocabulary N4 lesson 2","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai2.mp4?alt=media&token=3797f3f8-f65a-42c7-acd7-c1da7e55a4f9","Lesson 2",'4:09',3);
insert into lesson value(9,"Japanese Vocabulary N4 lesson 3","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai3.mp4?alt=media&token=a965f904-3cca-43ad-858e-8c0c64441c0f","Lesson 3","3:47",3);
insert into lesson value(30,"Japanese Vocabulary N4 lesson 4","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/flower.webm?","Lesson 4","0:05",3);
insert into lesson value(10,"Japanese Grammar N4 lesson 1","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai1.mp4?alt=media&token=5af41cc4-3cc3-459a-95a0-e13f2d362e6d","Lesson 1",'3:50',4);
insert into lesson value(11,"Japanese Grammar N4 lesson 2","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai2.mp4?alt=media&token=3797f3f8-f65a-42c7-acd7-c1da7e55a4f9","Lesson 2",'4:09',4);
insert into lesson value(12,"Japanese Grammar N4 lesson 3","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai3.mp4?alt=media&token=a965f904-3cca-43ad-858e-8c0c64441c0f","Lesson 3","3:47",4);
insert into lesson value(31,"Japanese Grammar N4 lesson 4","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/flower.webm?","Lesson 4","0:05",4);
insert into lesson value(13,"Japanese Vocabulary N3 lesson 1","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai1.mp4?alt=media&token=5af41cc4-3cc3-459a-95a0-e13f2d362e6d","Lesson 1",'3:50',5);
insert into lesson value(14,"Japanese Vocabulary N3 lesson 2","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai2.mp4?alt=media&token=3797f3f8-f65a-42c7-acd7-c1da7e55a4f9","Lesson 2",'4:09',5);
insert into lesson value(15,"Japanese Vocabulary N3 lesson 3","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai3.mp4?alt=media&token=a965f904-3cca-43ad-858e-8c0c64441c0f","Lesson 3","3:47",5);
insert into lesson value(32,"Japanese Vocabulary N3 lesson 4","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/flower.webm?","Lesson 4","0:05",5);
insert into lesson value(16,"Japanese Grammar N3 lesson 1","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai1.mp4?alt=media&token=5af41cc4-3cc3-459a-95a0-e13f2d362e6d","Lesson 1",'3:50',6);
insert into lesson value(17,"Japanese Grammar N3 lesson 2","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai2.mp4?alt=media&token=3797f3f8-f65a-42c7-acd7-c1da7e55a4f9","Lesson 2",'4:09',6);
insert into lesson value(18,"Japanese Grammar N3 lesson 3","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai3.mp4?alt=media&token=a965f904-3cca-43ad-858e-8c0c64441c0f","Lesson 3","3:47",6);
insert into lesson value(19,"Japanese Vocabulary N2 lesson 1","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai1.mp4?alt=media&token=5af41cc4-3cc3-459a-95a0-e13f2d362e6d","Lesson 1",'3:50',7);
insert into lesson value(20,"Japanese Vocabulary N2 lesson 2","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai2.mp4?alt=media&token=3797f3f8-f65a-42c7-acd7-c1da7e55a4f9","Lesson 2",'4:09',7);
insert into lesson value(21,"Japanese Vocabulary N2 lesson 3","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai3.mp4?alt=media&token=a965f904-3cca-43ad-858e-8c0c64441c0f","Lesson 3","3:47",7);
insert into lesson value(22,"Japanese Grammar N2 lesson 1","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai1.mp4?alt=media&token=5af41cc4-3cc3-459a-95a0-e13f2d362e6d","Lesson 1",'3:50',8);
insert into lesson value(23,"Japanese Grammar N2 lesson 2","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai2.mp4?alt=media&token=3797f3f8-f65a-42c7-acd7-c1da7e55a4f9","Lesson 2",'4:09',8);
insert into lesson value(24,"Japanese Grammar N2 lesson 3","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai3.mp4?alt=media&token=a965f904-3cca-43ad-858e-8c0c64441c0f","Lesson 3","3:47",8);
insert into lesson value(25,"Japanese Vocabulary and Grammar N1 lesson 1","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai1.mp4?alt=media&token=5af41cc4-3cc3-459a-95a0-e13f2d362e6d","Lesson 1",'3:50',9);
insert into lesson value(26,"Japanese Vocabulary and Grammar N1 lesson 2","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai2.mp4?alt=media&token=3797f3f8-f65a-42c7-acd7-c1da7e55a4f9","Lesson 2",'4:09',9);
insert into lesson value(27,"Japanese Vocabulary and Grammar N1 lesson 3","https://firebasestorage.googleapis.com/v0/b/coursesalingweb.appspot.com/o/bai3.mp4?alt=media&token=a965f904-3cca-43ad-858e-8c0c64441c0f","Lesson 3","3:47",9);

insert into wallet value(1,0,1);
insert into wallet value(2,0,2);
insert into wallet value(3,0,3);
insert into wallet value(4,0,4);
insert into wallet value(5,0,5);








