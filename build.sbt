import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "example-scalafix-with-fatalwarnings",
    libraryDependencies += scalaTest % Test,
    addCompilerPlugin(scalafixSemanticdb),
    scalacOptions ++= List(
      "-Yrangepos",
      "-Ywarn-unused-import",
      "-Xlint"
    ),
    scalacOptions in compile += "-Xfatal-warnings"
  )

addCommandAlias("fix", "scalafix;test:scalafix")