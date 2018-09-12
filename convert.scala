package mypackage
import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.sql._
import org.apache.log4j._

object test { 
  /* Our main function where the action happens */
  def main(args: Array[String]) {
     // Set the log level to only print errors
     Logger.getLogger("org").setLevel(Level.ERROR)
     println("Setting up Spark session")
     // Use new SparkSession interface in Spark 2.0
     val spark = SparkSession
        .builder
        .appName("SparkSQL")
        .master("local[*]")
     // below line necessary to work around a Windows bug in Spark 2.0.0
     // omit if you're not on Windows.
     config("spark.sql.warehouse.dir", "file:///C:/temp") 
        .getOrCreate()
     println("Reading in input file")        
     // Assume we have a pipe delimited text file, load it up ...
     val df = spark.read.format("com.databricks.spark.csv")
              .option("header","false")
              .option("inferSchema", "true")
              .option("delimiter","|")
              .load("file:///d:/tmp/iholding/IssueHolding.txt")
     // ... then save it in the new format 
     df.write.parquet("file:///d:/tmp/iholding/newdir")
     // Use the line below if you want just one mega file as output 
    // instead of a bunch of smaller ones
     // df.coalesce(1).write.parquet("file:///d:/tmp/iholding/newdir")

     spark.stop()

  }
}
