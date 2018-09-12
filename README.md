In one of my previos repos I wrote about the huge timing benefits you can get when using AWS’s Glue and Athena to query a Parquet format 
file over its equivalent text delimited format. The most eye-catching stat was a 95% reduction in run-time (from almost 20 seconds to just
one second) when summing a numeric field in a 360+ million record file. In this article I’ll show how easy it is to convert your text 
delimited files to Parquet format using a few lines of Apache SPARK & Scala code so that you too can benefit from potentially huge data 
query timing improvements that this simple change of file format can deliver. You can either do this within AWS by running your Spark job
on an Elastic Map Reduce (EMR) cluster and reading/writing your input/output files directly on S3 or you can do what I did and set up a
local Spark environment on your PC or Mac, convert your file and then upload it back onto S3. Assuming you’re doing the latter you’ll need
to download Spark and Scala to your local PC or Mac computer. Click on the following link for a Github repo I wrote on how to set up a
local Spark and Scala development environment. Once you’ve done this you can then use the spark code included with this repo to change
your text delimited file format to Parquet.
