object ValidParentheses extends App{

  println(isValid("()"))
  println(isValid("([)]"))

  def isValid(s: String): Boolean = {
    def isParenthese(ch: Char): Boolean = {
      ch match {
        case '(' | ')' | '{' | '}' | '[' | ']' => true
        case _ => false
      }
    }

    val characters: List[Char] = s.toList.filter(isParenthese)

    def helper(chars: List[Char], accumulator: List[Char]): Boolean = {
      chars match {
        case hd :: tail => {
          hd match {
            case '(' | '{' | '[' => helper(tail, accumulator :+ hd)
            case ')' => {
              if (!accumulator.isEmpty && accumulator.last == '(') {
                helper(tail, accumulator.dropRight(1))
              } else {
                return false
              }
            }
            case '}' => {
              if (!accumulator.isEmpty && accumulator.last == '{') {
                helper(tail, accumulator.dropRight(1))
              } else {
                return false
              }
            }
            case ']' => {
              if (!accumulator.isEmpty && accumulator.last == '[') {
                helper(tail, accumulator.dropRight(1))
              } else {
                return false
              }
            }
            case _ => return false
          }
        }
        case Nil => accumulator.isEmpty
      }
    }

    helper(characters, List.empty)
  }

}
