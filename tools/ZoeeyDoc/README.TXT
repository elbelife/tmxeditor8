ZoeeyDoc ����

ZoeeyDoc?��һ��docbook�ĵ��������ߣ�֧�� single-html��html��chm��pdf �ȸ�ʽ������������֧�����á�
�ŵ�

http://code.google.com/p/zoeeydoc/

========================
ZoeeyDoc help:
========================
-h/--help :
         ��ӡ���ĵ���

-c/--clean :
         ���������ļ���

-t/--type :
         ת��Ŀ�����ͣ�chm,html,single/singlehtml����Ĭ��Ϊ html��

-b/--book :
         �ĵ�Ŀ¼�� �ļ������ļ�Ϊ�ļ�·��+"/config.kv"

��ȡ����
java -jar ZoeeyDoc.jar -h

���� html
java -jar ZoeeyDoc.jar -b docs/books/zoeeydoc -t html

���� single html
java -jar ZoeeyDoc.jar -b docs/books/zoeeydoc -t single

���� chm ����Ҫָ��hhcĿ¼��
java -jar ZoeeyDoc.jar -b docs/books/zoeeydoc -t chm


========================
BUILD OUTPUT DESCRIPTION
========================

When you build an Java application project that has a main class, the IDE
automatically copies all of the JAR
files on the projects classpath to your projects dist/lib folder. The IDE
also adds each of the JAR files to the Class-Path element in the application
JAR files manifest file (MANIFEST.MF).

To run the project from the command line, go to the dist folder and
type the following:

java -jar "ZoeeyDoc.jar"

To distribute this project, zip up the dist folder (including the lib folder)
and distribute the ZIP file.

Notes:

* If two JAR files on the project classpath have the same name, only the first
JAR file is copied to the lib folder.
* Only JAR files are copied to the lib folder.
If the classpath contains other types of files or folders, none of the
classpath elements are copied to the lib folder. In such a case,
you need to copy the classpath elements to the lib folder manually after the build.
* If a library on the projects classpath also has a Class-Path element
specified in the manifest,the content of the Class-Path element has to be on
the projects runtime path.
* To set a main class in a standard Java project, right-click the project node
in the Projects window and choose Properties. Then click Run and enter the
class name in the Main Class field. Alternatively, you can manually type the
class name in the manifest Main-Class element.