terraform {
  required_providers {
    github = {
      source  = "integrations/github"
      version = "~> 4.0"
    }
  }
}

resource "github_repository" "default" {
  name        = var.name
  description = var.description
  auto_init   = true
  visibility  = "private"
}

resource "github_team" "developers" {
  name        = "developers"
  description = "Some cool team"
  privacy     = "closed"
}

resource "github_team_repository" "maintainers" {
  repository = github_repository.default.name
  team_id    = github_team.developers.id
  permission = "maintain"
}

resource "github_branch_protection" "default" {
  repository_id = github_repository.default.name

  pattern          = "main"
  enforce_admins   = true
  allows_deletions = true

  required_status_checks {
    strict   = true
    contexts = ["buildkite/${var.name}"] # this should follow a pattern so we should create a buildkite pipeline in terraform as well?
  }

  required_pull_request_reviews {
    dismiss_stale_reviews = true
    restrict_dismissals   = true
    dismissal_restrictions = [
      github_team.developers.node_id,
    ]
    require_code_owner_reviews      = true
    required_approving_review_count = 2
  }
}


data "github_repositories" "repos" {
  query = "org:vbendig"
}

output "repositories" {
  value = data.github_repositories.repos
}