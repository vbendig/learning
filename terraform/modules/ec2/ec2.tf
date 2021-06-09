variable "ec2name" {
  type = string
}

resource "aws_instance" "myec2" {
    ami = "ami-0ee02acd56a52998e"
    instance_type = "t2.micro"
    tags = {
      "name" = var.ec2name
    }
}

output "InstanceID" {
  value = aws_instance.myec2.id
}