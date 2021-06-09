# Shared
variable "region" {
  type = string
}

variable "tags" {
  type        = map(any)
  description = "default tags to apply to things"
}

variable "partner" {
  type        = string
  description = "partner this is for"
}

variable "env" {
  type        = string
  description = "environment"
}

variable "ssh_key_name" {
  type        = string
  description = "ssh key to attach to the servers"
}