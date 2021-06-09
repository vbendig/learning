module "ec2DBmodule" {
  source = "./ec2"
  ec2name = "DB Server"
  security_group_list = [module.dbSecurityGroupModule.Name]
}

module "ec2Webmodule" {
  source = "./ec2"
  ec2name = "Web Server"
  security_group_list = [module.webSecurityGroupModule.Name]
}

module "eipModule" {
  source = "./eip"
  instance_id = module.ec2Webmodule.InstanceID
}

module "webSecurityGroupModule" {
  secgroup_name = "Web Allow TCP"
  source = "./security_group"
  ingressrules = [80,443]
  egressrules = [80,443]
}

module "dbSecurityGroupModule" {
  secgroup_name = "DB Allow TCP"
  source = "./security_group"
  ingressrules = [5471]
  egressrules = [5471]
}

output "moduleEC2DBOutput" {
  value = module.ec2DBmodule.InstanceID
}

output "moduleEC2WebOutput" {
  value = module.ec2Webmodule.InstanceID
}

output "moduleSecGrDBOutput" {
  value = module.dbSecurityGroupModule.SecurityGroupId
}

output "moduleSecGrWebOutput" {
  value = module.webSecurityGroupModule.SecurityGroupId
}

output "webPublicIp" {
  value = module.eipModule.public_ip
}

output "dbPrivateIp" {
  value = module.ec2DBmodule.private_ip
}