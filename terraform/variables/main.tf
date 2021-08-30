provider "aws" {
  access_key                  = "mock_access_key"
  region                      = "us-east-2"
  s3_force_path_style         = true
  secret_key                  = "mock_secret_key"
  skip_credentials_validation = true
  skip_metadata_api_check     = true
  skip_requesting_account_id  = true

endpoints {
    apigateway     = "http://localhost:4566"
    cloudformation = "http://localhost:4566"
    cloudwatch     = "http://localhost:4566"
    dynamodb       = "http://localhost:4566"
    ec2            = "http://localhost:4566"
    es             = "http://localhost:4566"
    firehose       = "http://localhost:4566"
    iam            = "http://localhost:4566"
    kinesis        = "http://localhost:4566"
    lambda         = "http://localhost:4566"
    route53        = "http://localhost:4566"
    redshift       = "http://localhost:4566"
    s3             = "http://localhost:4566"
    secretsmanager = "http://localhost:4566"
    ses            = "http://localhost:4566"
    sns            = "http://localhost:4566"
    sqs            = "http://localhost:4566"
    ssm            = "http://localhost:4566"
    stepfunctions  = "http://localhost:4566"
    sts            = "http://localhost:4566"
  }
}

variable "hello" {
  type = string
  default = "Hello World!"
}

variable "mymap1" {
  type = map(string)
  default = {
	mykey = "my value"}
}

variable "vpcname" {
  type = string
  default = "myvpc"
}

variable "sshport" {
  type = number
  default = 22
}

variable "enabled" {
  default = true
}

variable "mylist" {
  type = list(string)
  default = ["val1", "val2"]
}

variable "mytuple" {
    type = tuple([string, number, string])
    default = ["cat", 1, "dog"]
}

variable "mymap" {
  type = map
  default = {
      key1 = "val1", 
      key2 = "val2"
    }
}

variable "myobj" {
  type = object({name = string, port = list(number)})
  default = {
      name = "name",
      port = [123, 456, 789]
  }
}

variable "inputname" {
    type = string
    description = "Set the name of your vpc"
  
}

output "vpc_id" {
    value = aws_vpc.myvpc.id  
}

resource "aws_vpc" "myvpc" {
    cidr_block = "10.0.0.0/16"
    tags = {
        Name = var.vpcname
    }
}
