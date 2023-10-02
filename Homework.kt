fun isPalindrome(num: Int): Boolean {

    return num.toString() == num.toString().reversed()
}

fun palindromeSquares(n: Int, m: Int): List<Int> {
    val result = mutableListOf<Int>()
    for (num in n..m) {

        if (isPalindrome(num) && isPalindrome(num * num)) {
            result.add(num)
        }
    }
    return result
}


fun main() {
    val n = 1
    val m = 1000
    val palindromes = palindromeSquares(n, m)
    println("Palindromic squares between $n and $m are: ${palindromes.joinToString(", ")}")
}


fun subtractKDigits(number: String, k: Int): String {
    val stack = mutableListOf<Char>()
    var removedDigits = 0

    for (digit in number) {

        while (stack.isNotEmpty() && digit > stack.last() && removedDigits < k) {
            stack.removeAt(stack.size - 1)
            removedDigits++
        }

        stack.add(digit)
    }


    while (removedDigits < k) {
        stack.removeAt(stack.size - 1)
        removedDigits++
    }


    val result = StringBuilder()
    for (digit in stack) {
        result.append(digit)
    }

    return result.toString()
}

fun main() {
    val number = "1678812"
    val k = 3
    val result = subtractKDigits(number, k)
    println("The largest number after subtracting $k digits from $number is: $result")
}


fun getPrimeDivisors(n: Int): List<Int> {
    val primeDivisors = mutableListOf<Int>()
    var num = n
    var divisor = 2

    while (num > 1 && divisor * divisor <= n) {
        if (num % divisor == 0) {

            var isPrime = true
            for (i in 2 until divisor) {
                if (divisor % i == 0) {
                    isPrime = false
                    break
                }
            }

            if (isPrime) {
                primeDivisors.add(divisor)
            }
            while (num % divisor == 0) {
                num /= divisor}
        }divisor++}

    if (num > 1) {

        primeDivisors.add(num)
    }return primeDivisors}

fun main() {
    val n = 321
    val primeDivisors = getPrimeDivisors(n)
    println("Prime divisors of $n are: ${primeDivisors.joinToString(", ")}")
}
