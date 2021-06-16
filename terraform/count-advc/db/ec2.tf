variable "ec2names" {
  type = list(string)
}

resource "aws_instance" "myec2" {
    ami = "ami-0ee02acd56a52998e"
    instance_type = "t2.micro"
    count = length(var.ec2names)
    tags = {
      "name" = var.ec2names[count.index]
    }
}

output "InstanceID" {
  value = [aws_instance.myec2.*.id]
}

output "private_ip" {
  value = [aws_instance.myec2.*.private_ip]
}