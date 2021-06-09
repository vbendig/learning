variable "secgroup_name" {
  type = string
}

variable "ingressrules" {
  type = list(number)
}

variable "egressrules" {
  type = list(number)
}

resource "aws_security_group" "securitygroup" {
  name= var.secgroup_name
  dynamic "ingress" {
    iterator = port
    for_each = var.ingressrules
    content {
      cidr_blocks = [ "0.0.0.0/0" ]
      from_port = port.value
      protocol = "TCP"
      to_port = port.value
    }
  }

  dynamic "egress" {
    iterator = port
    for_each = var.egressrules
    content {
      cidr_blocks = [ "0.0.0.0/0" ]
      from_port = port.value
      protocol = "TCP"
      to_port = port.value
    }
  }
}

output "SecurityGroupId" {
  value = aws_security_group.securitygroup.id
}

output "Name" {
  value = aws_security_group.securitygroup.name
}