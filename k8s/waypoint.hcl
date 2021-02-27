project = "kloudnative"

# An application to deploy.
app "kloudnative" {
    labels = {
        "service" = "kloudnative",
        "env"     = "dev"
    }

    build {
        use "pack" {
            builder     = "paketobuildpacks/builder:base"
            disable_entrypoint = false
        }
        registry {
            use "docker" {
                image = "humourmind/kloudnative-cnb"
                tag   = "1.0"
//                local = true
            }
        }
    }

    deploy {
        use "kubernetes" {
//            probe_path = "/actuator/health/readiness"
            replicas = 1
            service_port = 8080
        }
    }

    release {
        use "kubernetes" {
        }
    }
}
