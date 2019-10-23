# example-scalafix-with-fatalwarnings


現在の動き
```
sbt:example-scalafix-with-fatalwarnings> fix
removed -Xfatal-warnings
[success] Total time: 0 s, completed 2019/10/23 14:46:03
[info] new client connected: network-11
[info] Compiling 1 Scala source to /Users/rysh/src/example-scalafix-with-fatalwarnings/target/scala-2.12/classes ...
[error] /Users/ryxh/src/example-scalafix-with-fatalwarnings/src/main/scala/example/Hello.scala:3:25: Unused import
[error] import scala.concurrent.Future
[error]                         ^
[error] No warnings can be incurred under -Xfatal-warnings.
[error] two errors found
[error] (Compile / compileIncremental) Compilation failed
[error] Total time: 8 s, completed 2019/10/23 14:46:11
```
これが成功するようにしたい
