name := """play-guice-mybatis"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.mybatis" % "mybatis" % "3.3.0" withSources() withJavadoc(),
  "org.mybatis" % "mybatis-guice" % "3.6" withSources() withJavadoc(),
  javaCore, javaJdbc
)

libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1103-jdbc41" withSources() withJavadoc()

libraryDependencies += "com.google.inject" % "guice" % "4.0" withSources() withJavadoc()

libraryDependencies += "com.google.inject.extensions" % "guice-multibindings" % "4.0" withSources() withJavadoc()



// "Add mapper xml files to classpath" -- blank line necessary for SBT
unmanagedResourceDirectories in Compile <+= baseDirectory( _ / "app" )

// but filter out java and html files that would then also be copied to the classpath
excludeFilter in Compile in unmanagedResources := "*.java" || "*.html"
