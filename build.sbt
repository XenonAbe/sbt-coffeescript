// forked from sbt/sbt-coffeescript https://github.com/sbt/sbt-coffeescript
organization := "com.github.xenonabe"
name := "sbt-coffeescript2"
libraryDependencies ++= Seq(
  "org.webjars.npm" % "coffeescript" % "2.3.2",
  "org.webjars" % "mkdirp" % "0.5.0"
)
addSbtJsEngine("1.2.2")
