node ('Docker-test') {
    stage ("Preparations"){
        git 'https://github.com/yurchenkosv/jetty-jenkins-docker.git'
        mvnHome = tool 'M339-auto'
    }
    stage ("Build"){
        
        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
    }
    stage('Results') {
        archive 'target/*.jar'
    }
    stage('Publish'){
        sh 'docker build -t localhost:5000/jettyweb . && docker push localhost:5000/jettyweb'
    }
}
