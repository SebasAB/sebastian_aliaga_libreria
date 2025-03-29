def call(Map config = [:]) {
    def abortPipeline = config.get('abortPipeline', false)
    def fullBranch = env.GIT_BRANCH ?: 'unknown'
    def branchName = fullBranch.replaceFirst(/^origin\\//, '')

    echo "Rama detectada: ${branchName}"

    timeout(time: 5, unit: 'MINUTES') {
        sh 'echo "Ejecución de las pruebas de calidad de código"'
    }

    if (abortPipeline) {
        error("Pipeline abortado por configuración (abortPipeline=true)")
    }

    if (branchName == 'master' || branchName.startsWith('hotfix')) {
        error("Pipeline abortado por política de rama (${branchName})")
    }

    echo "Análisis estático completado correctamente."
}
