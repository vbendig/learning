module "db" {
  source = "./db"
  ec2names = ["Server1", "Server2", "Server3"]
}

output "private_ips" {
    value = module.db.private_ip
}

output "instance_ids" {
    value = module.db.InstanceID
}