package aws

import java.io.File
import java.net.URI

import conf.OrchidConf
import software.amazon.awssdk.auth.credentials.{AwsBasicCredentials, StaticCredentialsProvider}
import software.amazon.awssdk.core.ResponseInputStream
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.{S3Client, S3Configuration}
import software.amazon.awssdk.services.s3.model._

object OrchidS3 {

  private val credential =
    AwsBasicCredentials.create(
      OrchidConf.aws.s3.accessKey,
      OrchidConf.aws.s3.secretKey
    )

  private val s3Config =
    S3Configuration.builder()
      .pathStyleAccessEnabled(true)
      .build()

  private val client =
    S3Client.builder()
      .region(Region.AP_NORTHEAST_1)
      .credentialsProvider(StaticCredentialsProvider.create(credential))
      .endpointOverride(URI.create(OrchidConf.aws.s3.endPoint))
      .serviceConfiguration(s3Config)
      .build()

  def get(objKey: String): ResponseInputStream[GetObjectResponse] =
    client.getObject(OrchidS3RequestBuilder.getReq(objKey))

  def put(objKey: String, file: File): PutObjectResponse =
    client.putObject(OrchidS3RequestBuilder.putReq(objKey), file.toPath)

  private object OrchidS3RequestBuilder {

    def getReq(objKey: String): GetObjectRequest =
      GetObjectRequest.builder()
        .bucket(OrchidConf.aws.s3.bucket)
        .key(objKey)
        .build()

    def putReq(objKey: String): PutObjectRequest =
      PutObjectRequest.builder()
        .bucket(OrchidConf.aws.s3.bucket)
        .key(objKey)
        .build()
  }
}
