ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .aggregate(app)

lazy val app = (project in file("app"))
  .enablePlugins(DockerPlugin, JavaAgent, AshScriptPlugin, JavaServerAppPackaging)
  .settings(
    name := "javaagent-bug",
    Compile / run / mainClass := Some("Main"),
    javaAgents := Seq("com.datadoghq" % "dd-java-agent" % "1.21.0"),
    libraryDependencies := Seq(
      "org.typelevel" %% "cats-effect" % "3.5.2",
    )
  )
