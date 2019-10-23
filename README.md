# example-scalafix-with-fatalwarnings


現在の動き
```
sbt:example-scalafix-with-fatalwarnings> clean
[success] Total time: 0 s, completed 2019/10/23 16:31:23
sbt:example-scalafix-with-fatalwarnings> show compile / scalacOptions
[info] * -Yrangepos
[info] * -Ywarn-unused-import
[info] * -Xlint
[info] * -Xfatal-warnings
[success] Total time: 0 s, completed 2019/10/23 16:31:34
sbt:example-scalafix-with-fatalwarnings> compile
[info] Compiling 1 Scala source to /Users/rysh/src/example-scalafix-with-fatalwarnings/target/scala-2.12/classes ...
[warn] /Users/rysh/src/example-scalafix-with-fatalwarnings/src/main/scala/example/Hello.scala:3:25: Unused import
[warn] import scala.concurrent.Future
[warn]                         ^
[warn] one warning found
[success] Total time: 2 s, completed 2019/10/23 16:31:44
```
-Xfatal-warningsが指定されてるように見えるが、warnでコンパイルエラーになってくれない
