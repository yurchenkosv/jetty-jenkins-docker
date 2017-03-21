node ('Docker-test') {
    stage ("Preparations"){
        git 'https://github.com/yurchenkosv/jetty-jenkins-docker.git'
        mvnHome = tool 'M339-auto'
        appName = 'jettyweb'
        repo = 'localhost:5000'
    }
    stage ("Build"){
        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
    }
    stage('Results') {
        archive 'target/*.jar'
        junit '**/target/surefire-reports/*.xml'
    }
    stage('Publish'){
        sh "docker build -t '${repo}'/'${appName}' . && docker push '${repo}'/'${appName}'"
    }
}
