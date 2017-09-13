
lazy val AutoDiff = project.in(file("."))
  .settings(commonSettings: _*)
  .settings(name := "AutoDiff")
  .settings(testSettings: _*)

lazy val commonSettings = Seq(
  organization            :=  "semanticbeeng",
  name                    := "ScalaDiff",
  version                 :=  "0.0.1-SNAPSHOT",
  scalaVersion            :=  "2.11.8",
  crossScalaVersions      := Seq("2.11.8"),
  scalacOptions           ++= commonScalacOptions,
  resolvers               ++= commonResolvers,
  libraryDependencies     ++= commonLibraryDependencies
)


lazy val commonScalacOptions = Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:postfixOps",
  "-Xlint",
  "-Ywarn-dead-code"
)

lazy val commonResolvers = Seq(
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype release Repository" at "http://oss.sonatype.org/service/local/staging/deploy/maven2/",
  "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository/"
)

lazy val commonLibraryDependencies = Seq(
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

lazy val testSettings = Seq(
  testOptions          += Tests.Argument(TestFrameworks.ScalaCheck, "-verbosity", "2"),
  testOptions          += Tests.Argument(TestFrameworks.ScalaTest, "-oDF")
)
