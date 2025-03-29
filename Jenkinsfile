@Library('threepoints-sharedlib') _

pipeline {
    agent any

    stages {
        stage('Análisis Estático') {
            steps {
                staticAnalysis(abortPipeline: false)
            }
        }
    }
}

