data "terraform_remote_state" "infra" {
  backend = "s3"

  config = {
    bucket   = "amount-shared-cicd-tfstate"
    region   = "us-east-2"
    key      = "infra/terraform.tfstate"
    role_arn = aws_iam_role.OrganizationAccountAccessRole.arn
  }
}

data "aws_iam_policy_document" "ads-worker-service-account-trust-policy-document" {
  statement {
    actions = ["sts:AssumeRoleWithWebIdentity"]
    effect  = "Allow"

    condition {
      test     = "StringEquals"
      variable = "${replace(data.terraform_remote_state.infra.outputs.master_info["issuer"], "https://", "")}:sub"
      values   = ["system:serviceaccount:*:ads-worker-service-account"]
    }

    principals {
      identifiers = [data.terraform_remote_state.infra.outputs.master_info["issuer_arn"]]
      type        = "Federated"
    }
  }
}

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