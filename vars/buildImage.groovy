#!/user/bin/env groovy
def call()
{
    echo "bilding the image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh """
            docker build -t lokesh537/docker:jma-3.3 .
            echo \$PASS | docker login -u \$USER --password-stdin
            docker push lokesh537/docker:jma-3.3
        """
    }
}