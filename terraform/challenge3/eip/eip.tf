variable "instance_id" {
  type = string
}

resource "aws_eip" "eip" {
  instance = var.instance_id
  vpc = true
}

output "public_ip" {
  value = aws_eip.eip.public_ip
}
