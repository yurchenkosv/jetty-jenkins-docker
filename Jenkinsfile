node (Docker-test) {
    stage ("Preparations"){
        git 'https://github.com/yurchenkosv/jetty-jenkins-docker.git'
    }
    stage ("Build"){
        sh "'${MAVEN_HOME}/bin/mvn' -Dmaven.test.failure.ignore clean package"
    }
    stage('Results') {
        archive 'target/*.jar'
    }
    stage('Publish'){
        sh 'docker build -t localhost:5000/jettyweb .'
    }
}
