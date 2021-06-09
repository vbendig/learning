variable "ec2name" {
  type = string
}

variable "security_group_list" {
  type = list(string)
}

resource "aws_instance" "myec2" {
    ami = "ami-0ee02acd56a52998e"
    instance_type = "t2.micro"
    security_groups = var.security_group_list
    tags = {
      "name" = var.ec2name
    }
}

output "InstanceID" {
  value = aws_instance.myec2.id
}

output "private_ip" {
  value = aws_instance.myec2.private_ip
}