def call(Map config = [:]) {
    def abortPipeline = config.get('abortPipeline', false)
    def branchName = env.GIT_BRANCH ?: 'unknown'

    echo "Rama actual: ${branchName}"

    timeout(time: 5, unit: 'MINUTES') {
        sh 'echo "Ejecución de las pruebas de calidad de código"'
    }

    if (abortPipeline) {
        error("Pipeline abortado por configuración")
    } else if (branchName == 'master' || branchName.startsWith('hotfix')) {
        error("Pipeline abortado por política de rama (${branchName})")
    }

    echo "Análisis estático completado correctamente."
}

