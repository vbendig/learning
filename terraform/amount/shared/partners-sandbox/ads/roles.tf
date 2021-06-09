resource "aws_iam_role" "worker" {
  name = "worker_role"

  # Terraform's "jsonencode" function converts a
  # Terraform expression result to valid JSON syntax.
  assume_role_policy = data.aws_iam_policy_document.ads-worker-s3-policy.json
  tags = {
    name = "Worker Role"
  }
}

resource "aws_iam_role" "loader" {
  name = "loader_role"

  # Terraform's "jsonencode" function converts a
  # Terraform expression result to valid JSON syntax.
  assume_role_policy = data.aws_iam_policy_document.ads-loader-s3-policy.json
  tags = {
    name = "Loader Role"
  }
}

resource "aws_iam_role" "validator" {
  name = "validator_role"

  # Terraform's "jsonencode" function converts a
  # Terraform expression result to valid JSON syntax.
  assume_role_policy = data.aws_iam_policy_document.ads-validator-s3-policy.json
  tags = {
    name = "Validator Role"
  }
}