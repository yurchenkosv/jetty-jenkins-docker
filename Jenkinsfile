node ('docker-server') {
    stage ("Preparations"){
        git 'https://github.com/yurchenkosv/jetty-jenkins-docker.git'
        mvnHome = tool 'M339-auto'
        appName = 'jettyweb'
        repo = 'localhost:5000'
        postmanFixturesFile = 'ServerUpAndRunningFixtures.json'
        postmanCollectionFile = 'DockerTestApp.postman_collection.json'
        nodeJSHome = tool 'nodeJS-auto'
        env.PATH = "${nodeJSHome}/bin:${env.PATH}"
    }
    stage ("Build"){
        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
    }
    stage('Results') {
        archive 'target/*.jar'
    }
    stage('Publish'){
        sh "docker build -t '${repo}'/'${appName}' . && docker push '${repo}'/'${appName}' && docker run -d -p 8680:8680 '${repo}'/'${appName}'"
    }
    stage ('IntegrationTests'){
        sh "newman run -d '${postmanFixturesFile}' -n 1 -r junit --reporter-junit-export target/surefire-reports/'${appName}'.xml -x '${postmanCollectionFile}'"
        junit '**/target/surefire-reports/*.xml'
    }
    stage ('Finish'){
        sh "docker stop `docker ps |grep localhost:5000/jettyweb | awk {' print \$1 '}`"
    }
}