# module "worker_s3_user" {
#   source      = "git@github.com:amount/terraform-modules.git//migrated/iam/user/?ref=v66"
#   name        = "worker-s3-user"
#   partner     = var.partner
#   env         = var.env
#   policy_json = data.aws_iam_policy_document.ads-worker-s3-policy.json
# }

# module "loader_s3_user" {
#   source      = "git@github.com:amount/terraform-modules.git//migrated/iam/user/?ref=v66"
#   name        = "loader-s3-user"
#   partner     = var.partner
#   env         = var.env
#   policy_json = data.aws_iam_policy_document.ads-loader-s3-policy.json
# }

# module "validator_s3_user" {
#   source      = "git@github.com:amount/terraform-modules.git//migrated/iam/user/?ref=v66"
#   name        = "validator-s3-user"
#   partner     = var.partner
#   env         = var.env
#   policy_json = data.aws_iam_policy_document.ads-validator-s3-policy.json
# }