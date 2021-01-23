version = "1.2"

tasks {
  val build by register("build") {
    description = "Builds production compiled code and puts it into a nginx docker container"
    doLast {
      println("Building prodBuild")
      exec {
        commandLine("npm.cmd", "run", "prodBuild")
      }
      println("Building dockerfile with versionnumber $version")
      exec {
        commandLine("docker", "build", ".", "--build-arg", "VERSION=$version", "-t", "joost1808/ledstrip-frontend:latest")
      }
      println("tagging joost1808/ledstrip-frontend:$version")
      exec {
        commandLine("docker", "tag", "joost1808/ledstrip-frontend:latest", "joost1808/ledstrip-frontend:$version")
      }
      println("pushing joost1808/ledstrip-frontend:$version")
      exec {
        commandLine("docker", "push", "joost1808/ledstrip-frontend:$version")
      }
    }
  }
}
