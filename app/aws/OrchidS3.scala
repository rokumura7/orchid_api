package aws

import java.net.URI

import conf.OrchidConf
import software.amazon.awssdk.auth.credentials.{AwsBasicCredentials, StaticCredentialsProvider}
import software.amazon.awssdk.core.ResponseInputStream
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.{S3Client, S3Configuration}
import software.amazon.awssdk.services.s3.model._

object OrchidS3 {
  def get(objKey: String): ResponseInputStream[GetObjectResponse] =
    getClient.getObject(OrchidS3RequestBuilder.getReq(objKey))

  private def getClient: S3Client = {
    val credential = AwsBasicCredentials.create(
      OrchidConf.aws.s3.accessKey,
      OrchidConf.aws.s3.secretKey
    )
    val config = S3Configuration.builder()
      .pathStyleAccessEnabled(true)
      .build()
    S3Client.builder()
      .region(Region.AP_NORTHEAST_1)
      .credentialsProvider(StaticCredentialsProvider.create(credential))
      .endpointOverride(URI.create(OrchidConf.aws.s3.endPoint))
      .serviceConfiguration(config)
      .build()
  }

  private object OrchidS3RequestBuilder {
    def getReq(objKey: String): GetObjectRequest =
      GetObjectRequest.builder()
        .bucket(OrchidConf.aws.s3.bucket)
        .key(objKey)
        .build()
  }
}
