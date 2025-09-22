#!/user/bin/env groovy
def call(String imageName)
{
    echo "bilding the image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh """
            docker build -t $imageName .
            echo \$PASS | docker login -u \$USER --password-stdin
            docker push $imageName
        """
    }
}
