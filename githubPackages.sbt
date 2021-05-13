githubTokenSource := TokenSource.Environment("GITHUB_TOKEN") || TokenSource.GitConfig("github.token")
ThisBuild / githubOwner := "XenonAbe"
ThisBuild / githubRepository := "sbt-coffeescript2"
ThisBuild / licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
