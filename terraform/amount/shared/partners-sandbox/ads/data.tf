data "aws_iam_policy_document" "ads-worker-s3-policy" {
  statement {
    effect = "Allow"
    actions = [
      "s3:ListObjects",
      "s3:DeleteObject",
      "s3:GetBucketLocation",
      "s3:GetObject",
      "s3:ListBucket",
      "s3:PutObject",
      "s3:GetObjectAcl",
    ]
    resources = [
      "arn:aws:s3:::${aws_s3_bucket.ads_validating_datasets.id}/*",
      "arn:aws:s3:::${aws_s3_bucket.ads_validating_datasets.id}",
      "arn:aws:s3:::${aws_s3_bucket.shared_ads_validated_datasets.id}/*",
      "arn:aws:s3:::${aws_s3_bucket.shared_ads_validated_datasets.id}"
    ]
  }
}

data "aws_iam_policy_document" "ads-validator-s3-policy" {
  statement {
    effect = "Allow"
    actions = [
      "s3:ListObjects",
      "s3:GetBucketLocation",
      "s3:GetObject",
      "s3:ListBucket",
      "s3:GetObjectAcl",
    ]
    resources = [
      "arn:aws:s3:::${aws_s3_bucket.ads_validating_datasets.id}/*",
      "arn:aws:s3:::${aws_s3_bucket.ads_validating_datasets.id}"
    ]
  }
}

data "aws_iam_policy_document" "ads-loader-s3-policy" {
  statement {
    effect = "Allow"
    actions = [
      "s3:ListObjects",
      "s3:GetBucketLocation",
      "s3:GetObject",
      "s3:ListBucket",
      "s3:GetObjectAcl",
    ]
    resources = [
       "arn:aws:s3:::${aws_s3_bucket.shared_ads_validated_datasets.id}/*",
       "arn:aws:s3:::${aws_s3_bucket.shared_ads_validated_datasets.id}"
    ]
  }
}