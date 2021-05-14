// forked from sbt/sbt-coffeescript https://github.com/sbt/sbt-coffeescript
name := "sbt-coffeescript2"
ThisBuild / organization := "com.github.xenonabe"
ThisBuild / scalaVersion := "2.12.13"

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    addSbtJsEngine("1.2.3"),
    libraryDependencies ++= Seq(
      "org.webjars.npm" % "coffeescript" % "2.5.1",
      "org.webjars" % "mkdirp" % "0.5.0"
    ),
    scriptedLaunchOpts := { scriptedLaunchOpts.value ++
      Seq("-Dplugin.version=" + version.value)
    },
    publishArtifact in (Compile, packageDoc) := false,
    publishArtifact in (Compile, packageSrc) := false,
    bintrayRepository := "sbt-plugin-releases",
  )