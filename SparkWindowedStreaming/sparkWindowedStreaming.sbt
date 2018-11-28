name := "sparkWindowedStreaming"
 
version := "1.0"
 
scalaVersion := "2.11.12"
// scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % "2.3.0",
    "org.apache.spark" %% "spark-streaming" % "2.3.0",
    "org.apache.spark" %% "spark-sql" % "2.3.0"
)

//    "org.apache.spark" % "spark-sql_2.11" % "2.1.0"
