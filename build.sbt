import Dependencies._
import java.util.concurrent.atomic.AtomicBoolean

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

val isFatalWarningOn = new AtomicBoolean(true)
val fatalWarningOff = taskKey[Unit]("fatalWarningOff")
val fatalWarningOn = taskKey[Unit]("fatalWarningOn")

val silencerVersion = "1.4.4"

lazy val root = (project in file("."))
  .settings(
    name := "example-scalafix-with-fatalwarnings",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      compilerPlugin("com.github.ghik" % "silencer-plugin" % silencerVersion cross CrossVersion.full),
      "com.github.ghik" % "silencer-lib" % silencerVersion % Provided cross CrossVersion.full
    ),
    addCompilerPlugin(scalafixSemanticdb),
    scalacOptions ++= List(
      "-Yrangepos",
      "-Ywarn-unused-import",
      "-Xlint"
    ),
    scalacOptions ++= (if (isFatalWarningOn.get) Seq("-Xfatal-warnings") else Nil),
    scalacOptions --= (if (!isFatalWarningOn.get) Seq("-Xfatal-warnings") else Nil),
    fatalWarningOff := isFatalWarningOn.set(false),
    fatalWarningOn := isFatalWarningOn.set(true)
  )

def ensureSilencerIsLast(options: Seq[String]): Seq[String] = {
  val (Seq(silencer), rest) =
    options.partition(o => o.startsWith("-Xplugin:") && o.contains("silencer"))
  rest :+ silencer
}

scalacOptions in Compile := ensureSilencerIsLast((scalacOptions in Compile).value)
scalacOptions in Test := ensureSilencerIsLast((scalacOptions in Test).value)

addCommandAlias("fix", "fatalWarningOff;scalafix;test:scalafix;fatalWarningOn")
