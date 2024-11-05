enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val matricula: String)

data class ConteudoEducacional(var nomeConteudo: String, var duracao: Int = 60)

class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, var nivel: Nivel) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("\nAlunos matriculados: ${usuario.matricula}")
    }

    fun printFormacao() {
        println("Formações disponíveis: ")
        println(nome)
        printConteudos()
        println(nivel)
    }

    private fun printConteudos() {
        conteudos.forEach { conteudo ->
            println("conteúdo: ${conteudo.nomeConteudo}, duração: ${conteudo.duracao}")
        }
    }
}

fun main() {
    val usuario = Usuario("Incal")
    val usuario2 = Usuario("John Deefool")
    val usuario3 = Usuario("Metabarão")


    val conteudoKotlin =  listOf(
        ConteudoEducacional(nomeConteudo = "Avançando Tecnicamente em Kotlin", duracao = 60),
        ConteudoEducacional(nomeConteudo = "Explorando Mapas Loops e Regras com Kotlin", duracao = 70),
        ConteudoEducacional(nomeConteudo = "Orientação A Objetos Visando Soluções mais idiomaticas", duracao = 80),
    )

    val conteudoAndroid = listOf(
        ConteudoEducacional(nomeConteudo = "Avançando Tecnicamente em Android com Kotlin", duracao = 60),
        ConteudoEducacional(nomeConteudo = "Clean Archtecture Android", duracao = 70),
    )

    val conteudoGitHub = listOf(
        ConteudoEducacional(nomeConteudo = "Criando seu primeiro Repositório no Github", duracao = 20)
    )

    val formacao = Formacao(
        nome = "Kotlin Experience",
        conteudos = conteudoKotlin,
        nivel = Nivel.INTERMEDIARIO
    )

    val formacao2 = Formacao(
        nome = "Android Experience",
        conteudos = conteudoAndroid,
        nivel = Nivel.DIFICIL
    )

    val formacao3 = Formacao(
        nome = "Github",
        conteudos = conteudoGitHub,
        nivel = Nivel.BASICO
    )
    println("\nFormações DIO\n")
    formacao.printFormacao()
    formacao.matricular(usuario)
    println("-------------\n\n")
    formacao2.printFormacao()
    formacao2.matricular(usuario3)
    println("-------------\n\n")
    formacao3.printFormacao()
    formacao3.matricular(usuario2)
    println("-------------\n\n")

}