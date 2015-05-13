import ScalaxbKeys._

lazy val dispatchV = "0.11.2"

lazy val p = (project in file("."))
  .settings(scalaxbSettings : _*)
  .settings(
    paramPrefix in (Compile, scalaxb) := Some("x"),
    classPrefix in (Compile, scalaxb) := Some("y"),
    attributePrefix in (Compile, scalaxb) := Some("z"),
    sourceGenerators in Compile += (scalaxb in Compile).taskValue,
    dispatchVersion in (Compile, scalaxb) := dispatchV,
    async in (Compile, scalaxb) := true,
    packageName in (Compile, scalaxb) := "generated",
    libraryDependencies ++= Seq(
      "net.databinder.dispatch" %% "dispatch-core" % dispatchV
    )
  )
