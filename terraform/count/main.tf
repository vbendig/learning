resource "aws_instance" "web" {
  ami           = "ami-0ee02acd56a52998e"
  instance_type = "t2.micro"
  count         = var.bastion_private_ip == "test" ? 1 : 0
  depends_on = [
    aws_instance.db
  ]
}

resource "aws_instance" "db" {
  ami           = "ami-0ee02acd56a52998e"
  instance_type = "t2.micro"
}