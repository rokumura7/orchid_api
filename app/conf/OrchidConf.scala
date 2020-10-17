package conf

import com.typesafe.config.ConfigFactory

object OrchidConf {
  private def get(key: String): String = ConfigFactory.load.getString(key)

  object aws {
    object s3 {
      def bucket: String = get("aws.s3.bucket")
      def endPoint: String = get("aws.s3.end_point")
      def accessKey: String = get("aws.s3.access_key")
      def secretKey: String = get("aws.s3.secret_key")
    }
  }
}
