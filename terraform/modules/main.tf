module "ec2module" {
  source = "./ec2"
  ec2name = "Name From module"
}

output "moduleEC2Output" {
  value = module.ec2module.InstanceID
}