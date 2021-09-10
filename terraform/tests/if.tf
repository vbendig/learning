output "result" {

  value = values(var.account_ids)
}

locals {
  testList = compact(values(var.account_ids))
}

output "test_locals" {
  value = local.testList
}