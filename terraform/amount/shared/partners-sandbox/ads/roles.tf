resource "aws_iam_role" "OrganizationAccountAccessRole" {
  name = "organization_role"
  assume_role_policy = data.aws_iam_policy_document.ads-worker-s3-policy.json
  managed_policy_arns = [aws_iam_policy.policy_one.arn, aws_iam_policy.policy_two.arn]
}

resource "aws_iam_role" "ads_worker_role" {
  name = "worker-role"
  assume_role_policy = data.aws_iam_policy_document.ads-worker-service-account-trust-policy-document.json
  tags = {
    name = "Worker Role"
  }
}

resource "aws_iam_policy" "policy_one" {
  name = "policy-618033"

  policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action   = ["ec2:Describe*"]
        Effect   = "Allow"
        Resource = "*"
      },
    ]
  })
}

resource "aws_iam_policy" "policy_two" {
  name = "policy-381966"

  policy = jsonencode({
    Version = "2012-10-17"
    Statement = [
      {
        Action   = ["s3:ListAllMyBuckets", "s3:ListBucket", "s3:HeadBucket"]
        Effect   = "Allow"
        Resource = "*"
      },
    ]
  })
}

resource "aws_iam_policy" "ads_worker_policy" {
  name        = "worker-policy"
  description = "Worker policy"

  policy = data.aws_iam_policy_document.ads-worker-s3-policy.json
}

resource "aws_iam_role_policy_attachment" "ads_worker_policy_attachment" {
  role       = aws_iam_role.ads_worker_role.id
  policy_arn = aws_iam_policy.ads_worker_policy.arn
}

# FIXME: These need to change in the same was as worker
# resource "aws_iam_role" "loader" {
#   name = "loader_role"

#   # Terraform's "jsonencode" function converts a
#   # Terraform expression result to valid JSON syntax.
#   assume_role_policy = data.aws_iam_policy_document.ads-loader-s3-policy.json
#   tags = {
#     name = "Loader Role"
#   }
# }

# resource "aws_iam_role" "validator" {
#   name = "validator_role"

#   # Terraform's "jsonencode" function converts a
#   # Terraform expression result to valid JSON syntax.
#   assume_role_policy = data.aws_iam_policy_document.ads-validator-s3-policy.json
#   tags = {
#     name = "Validator Role"
#   }
# }
