sbtPlugin := true

organization := "temp.cdelargy.hack"

name := "sbt-autoprefixer"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.4"

resolvers ++= Seq(
  "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/",
  Resolver.url("sbt snapshot plugins", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns),
  Resolver.sonatypeRepo("snapshots"),
  "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
)

addSbtPlugin("com.typesafe.sbt" %% "sbt-js-engine" % "1.0.0")

publishMavenStyle := false

publishTo := {
  if (isSnapshot.value) Some(Classpaths.sbtPluginSnapshots)
  else Some(Classpaths.sbtPluginReleases)
}

scriptedSettings

scriptedBufferLog := false

scriptedLaunchOpts <+= version apply { v => s"-Dproject.version=$v" }
