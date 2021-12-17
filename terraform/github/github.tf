provider "github" {
  owner = "ibsacr"
}

module "github" {
  source   = "./module/"
  name     = "testName"
  owner    = "ibsacr"
  dev_team = "developers"
}