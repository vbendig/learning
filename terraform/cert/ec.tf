resource "aws_instance" "web" {
  ami           = data.aws_ami.ubuntu.id
  instance_type = "t3.micro"

  tags = {
    Name = "HelloWorldWeb"
  }
}

resource "aws_ebs_volume" "firsthd" {
  availability_zone = var.availability_zone
  size              = 8

  tags = {
    Name = "HelloWorld"
  }
}