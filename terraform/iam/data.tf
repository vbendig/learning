data "aws_iam_policy_document" "custom-s3-policy" {
  statement {
    effect = "Allow"
    actions = [
      "s3:ListObjects",
      "s3:GetBucketLocation",
      "s3:GetObject",
      "s3:ListBucket",
      "s3:GetObjectAcl",
    ]
    resources = ["*"]
  }
}

