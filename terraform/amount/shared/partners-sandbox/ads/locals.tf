locals {
  ads_validating_datasets_bucket_name = "amount-${var.partner}-${var.env}-ads-validating-datasets"
  ads_validated_datasets_bucket_name = "amount-shared-${var.env}-ads-validated-datasets"
}