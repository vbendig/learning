resource "aws_iam_user" "myUser" {
  name = "worker"
}

resource "aws_iam_policy" "customPolicy" {
  name = "custom-policy"
  policy = data.aws_iam_policy_document.custom-s3-policy.json
}

resource "aws_iam_policy_attachment" "policyBind" {
  name = "attachment"
  users = [ aws_iam_user.myUser.name ]
  policy_arn = aws_iam_policy.customPolicy.arn
}
