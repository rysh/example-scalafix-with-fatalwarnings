import Dependencies._
import java.util.concurrent.atomic.AtomicBoolean

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

val isFatalWarningOn = new AtomicBoolean(true)
val fatalWarningOff = taskKey[Unit]("fatalWarningOff")
val fatalWarningOn = taskKey[Unit]("fatalWarningOn")

lazy val root = (project in file("."))
  .settings(
    name := "example-scalafix-with-fatalwarnings",
    libraryDependencies += scalaTest % Test,
    addCompilerPlugin(scalafixSemanticdb),
    scalacOptions := {
      List(
        "-Yrangepos",
        "-Ywarn-unused-import",
        "-Xlint"
      ) ++ (if (isFatalWarningOn.get()) Seq("-Xfatal-warnings") else Nil)
    },
    fatalWarningOff := {
      isFatalWarningOn.set(false)
    },
    fatalWarningOn := {
      isFatalWarningOn.set(true)
    }
  )

addCommandAlias("fix", "fatalWarningOff;scalafix;test:scalafix;fatalWarningOn")
