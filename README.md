项目简介：Mybatis的动态sql语句演示
======================
详细内容
---------
 1. if语句  
 	其实就是在写sql写着写着来个if语句，满足条件就可以续一秒。。不对，续一段sql语句
 2.choose语句
 3.foreach-Array语句
 4.foreach-list语句
 5.foreach-Map语句
 5.foreach-Set语句
 6.foreach-trim语句
 7.foreach-where语句
 
 
 意外发现
----------------
1. 必须进行DML语句之后来一个commit，这样的DML语句才回在数据库生效
