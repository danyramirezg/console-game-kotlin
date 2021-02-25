package io

fun main(args: Array<String>) {

    print("Type the word to guess: ")
    val word = readLine()

    if (word == null) {
        println("No given word, the game is over!")
    }
    for (i in 1..100) {
        println()
    }

    val letters = word?.toLowerCase()!!.toCharArray()!!.toHashSet()!!
    // Example: Danny -> dany -> ['D', 'a', 'n', 'n', 'y'] -> {'D', 'a', 'n', 'y'}

    val correctGuesses = mutableSetOf<Char>()
    var fails = 0

    while (letters != correctGuesses) {

        printExploreWord(word, correctGuesses)
        println("\nWrong guesses: # $fails\n")

        print("Guess letter: ")
        val input = readLine()

        if (input == null) {
            continue
        } else if (input.length != 1) {
            println("Type one letter")
            continue
        }

        if (word.toLowerCase().contains(input.toLowerCase())) {
            correctGuesses.add(input[0].toLowerCase())
        } else {
            ++fails
        }
    }
    printExploreWord(word, correctGuesses)
    println("\nTotal wrong guesses: # $fails\n")
    println("Congrats... You got it!")
}

fun printExploreWord(word: String, correctGuesses: Set<Char>) {
    for (i in word.toLowerCase()) {
        if (correctGuesses.contains(i)) {
            print("$i ")
        } else {
            print("_ ")
        }
    }
}