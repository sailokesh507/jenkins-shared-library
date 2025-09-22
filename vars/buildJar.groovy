#!/user/bin/env groovy
def call() {
    echo "building the application from $GIT_BRANCH"
    sh 'mvn package'
}
