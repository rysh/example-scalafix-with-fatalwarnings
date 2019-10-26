package example

import com.github.ghik.silencer.silent
import scala.concurrent.Future

object Hello extends Greeting with App {
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "hello"
}

@silent object Silent {
  import scala.concurrent.Future
}
