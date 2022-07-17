
object IsPalindrome extends App{

  println(isPalindrome("A man, a plan, a canal: Panama"))

  def isPalindrome(s: String): Boolean = {
    val input = s.toLowerCase.replaceAll("[^A-Za-z0-9]", "")
    input equalsIgnoreCase input.reverse
  }

}
