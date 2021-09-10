provider "aws" {
  shared_credentials_file = "~/.aws/credentials"
  profile                 = "vbendig"
  region                  = var.region
}

provider "google" {
  project = "my-project-id"
  region  = "us-central1"
}