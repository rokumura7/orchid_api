name := """orchid"""
organization := "com.rokumura"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,

  // AWS SDK
  "software.amazon.awssdk" % "aws-sdk-java" % "2.14.12" pomOnly(),

  // International Components for Unicode
  "com.ibm.icu" % "icu4j" % "67.1"
)
