import com.lihaoyi.workbench.Plugin._

// enablePlugins(ScalaJSPlugin)

workbenchSettings

name := "Example"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.1",
  "com.lihaoyi" %%% "scalatags" % "0.5.2"
)

bootSnippet := "example.ScalaJSExample().main(document.getElementById('container'));"

updateBrowsers <<= updateBrowsers.triggeredBy(fastOptJS in Compile)
