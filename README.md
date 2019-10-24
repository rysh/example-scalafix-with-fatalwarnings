# example-scalafix-with-fatalwarnings


```
sbt:example-scalafix-with-fatalwarnings> compile
[info] Compiling 1 Scala source to /Users/rysh/src/example-scalafix-with-fatalwarnings/target/scala-2.12/classes ...
[error] /Users/rysh/src/example-scalafix-with-fatalwarnings/src/main/scala/example/Hello.scala:5:25: Unused import
[error] import scala.concurrent.Future
[error]                         ^
[error] No warnings can be incurred under -Xfatal-warnings.
[error] two errors found
[error] (Compile / compileIncremental) Compilation failed
[error] Total time: 4 s, completed 2019/10/24 10:00:07
sbt:example-scalafix-with-fatalwarnings> fix
[success] Total time: 0 s, completed 2019/10/24 10:00:08
[info] Compiling 1 Scala source to /Users/rysh/src/example-scalafix-with-fatalwarnings/target/scala-2.12/classes ...
[warn] /Users/rysh/src/example-scalafix-with-fatalwarnings/src/main/scala/example/Hello.scala:5:25: Unused import
[warn] import scala.concurrent.Future
[warn]                         ^
[warn] one warning found
[success] Total time: 11 s, completed 2019/10/24 10:00:19
[info] Compiling 1 Scala source to /Users/rysh/src/example-scalafix-with-fatalwarnings/target/scala-2.12/classes ...
[info] Compiling 1 Scala source to /Users/rysh/src/example-scalafix-with-fatalwarnings/target/scala-2.12/test-classes ...
[success] Total time: 9 s, completed 2019/10/24 10:00:28
[success] Total time: 0 s, completed 2019/10/24 10:00:28
```
