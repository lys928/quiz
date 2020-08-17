# minitest

1.问题说明：idea在控制台里，编写的junit测试中用了Scanner，键盘按键无法输入
在你的Idea安装目录下的（比如我的安装在以下目录）
D:\JetBrains\IntelliJ IDEA 2019.1.3\bin
里面的文件 idea64.exe.vmoptions追加以下内容
-Deditable.java.test.console=true；
重启IDEA，从新执行单元测试类，Ok!

Eclipse中运行无此问题

测试的步骤:1.idea 直接open项目
2.打开测试类SentenceUtilsTest
3.关注findSentence,testFindSentenceByInputDic ,testFindSentenceByMergeDictionary方法.
4.检查方法是否满足需求.


