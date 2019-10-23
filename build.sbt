import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

val fatalWarningOff = taskKey[Unit]("fatalWarningOff")
val fatalWarningOn = taskKey[Unit]("fatalWarningOn")

lazy val root = (project in file("."))
  .settings(
    name := "example-scalafix-with-fatalwarnings",
    libraryDependencies += scalaTest % Test,
    addCompilerPlugin(scalafixSemanticdb),
    scalacOptions ++= List(
      "-Yrangepos",
      "-Ywarn-unused-import",
      "-Xfatal-warnings",
      "-Xlint"
    ),
    fatalWarningOff := {
      scalacOptions -= "-Xfatal-warnings"
      println("removed -Xfatal-warnings")
    },
    fatalWarningOn := {
      scalacOptions += "-Xfatal-warnings"
      println("added  -Xfatal-warnings")
    }
  )


addCommandAlias("fix", "fatalWarningOff;scalafix;test:scalafix;fatalWarningOn")