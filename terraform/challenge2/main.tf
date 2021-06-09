variable "ingressrules" {
  type = list(number)
  default = [80,443]
  
}

variable "egressrules" {
  type = list(number)
  default = [80,443]
  
}

resource "aws_instance" "dbserver" {
    ami = "ami-0ee02acd56a52998e"
    instance_type = "t2.micro"
    tags = {
      "name" = "DB Server"
    }
}

resource "aws_eip" "mywebserverelasticip" {
  instance = aws_instance.webserver.id
  vpc = true
}

resource "aws_instance" "webserver" {
    ami = "ami-0ee02acd56a52998e"
    instance_type = "t2.micro"
    security_groups = [aws_security_group.webtraffic.name]
    user_data = file("server-script.sh")
    tags = {
      "name" = "Web Server"
    }
    # provisioner "file" {
    #   source      = "server-script.sh"
    #   destination = "~/server-script.sh"
    # }
    # provisioner "local-exec" {
    #   command = "~/server-script.sh"
    # }
}

resource "aws_security_group" "webtraffic" {
  name= "Allow HTTPS"
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

output "DBServerPrivateIP" {
  value = aws_instance.dbserver.private_ip
}

output "WebPublicIP" {
  value = aws_instance.webserver.public_ip
}