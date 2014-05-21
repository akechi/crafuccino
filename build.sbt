import AssemblyKeys._

name := "crafuccino"

version := "1.0"

resolvers ++= Seq(
  "org.bukkit" at "http://repo.bukkit.org/service/local/repositories/snapshots/content/")

libraryDependencies ++= Seq(
  "org.bukkit" % "bukkit" % "1.7.9-R0.2-SNAPSHOT",
  "rhino" % "js" % "1.7R2")

assemblySettings

assemblyOption in assembly ~= { _.copy(includeScala = false) }
