def buildFun(){
    echo "Building the application"
    echo "Building version ${NEW_VERSION} ."

    // maven('maven-3.8.4'){
    //     sh 'mvn install'
    // }

    sh 'mvn --help'
    sh 'node --version'

    nodejs('NodeJS'){
        sh 'npm install -g yarn'
        sh 'yarn --help'
    }

}

def testFun(){
    echo "Testing the application"
}

def deployFun(){
    echo "Deploying the application"
    echo "Deploying with ${params.VERSION} ."
    echo "Deploying with "
    sh ('echo $SERVER_CREDENTIALS')
    // withCredentials{[
    //     usernamePassword(credentialsId: 'server-credentials', usernameVariable: 'USER', passwordVariable: 'PSWD')
    // ]}
    // {
    //     //sh 'use $USER $PSWD'
    // }
}

return this
