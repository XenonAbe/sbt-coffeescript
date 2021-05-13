// forked from sbt/sbt-coffeescript https://github.com/sbt/sbt-coffeescript
ThisBuild / organization := "com.github.xenonabe"
ThisBuild / name := "sbt-coffeescript2"
ThisBuild / scalaVersion := "2.12.13"

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    addSbtJsEngine("1.2.3"),
    libraryDependencies ++= Seq(
      "org.webjars.npm" % "coffeescript" % "2.3.2",
      "org.webjars" % "mkdirp" % "0.5.0"
    )
  )