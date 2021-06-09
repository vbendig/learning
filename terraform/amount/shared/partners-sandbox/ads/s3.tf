resource "aws_s3_bucket" "ads_validating_datasets" {
  bucket = local.ads_validating_datasets_bucket_name
  acl    = "private"

  server_side_encryption_configuration {
    rule {
      apply_server_side_encryption_by_default {
        sse_algorithm = "AES256"
      }
    }
  }

  versioning {
    enabled = true
  }

  tags = merge(
    map(
      "Name",
      local.ads_validating_datasets_bucket_name
    ),
    var.tags
  )
}

resource "aws_s3_bucket" "shared_ads_validated_datasets" {
  bucket = local.ads_validated_datasets_bucket_name
  acl    = "private"

  server_side_encryption_configuration {
    rule {
      apply_server_side_encryption_by_default {
        sse_algorithm = "AES256"
      }
    }
  }

  versioning {
    enabled = true
  }

  tags = merge(
    map(
      "Name",
      local.ads_validated_datasets_bucket_name
    ),
    var.tags
  )
}