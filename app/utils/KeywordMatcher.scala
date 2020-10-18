package utils

import com.ibm.icu.text.Transliterator

object KeywordMatcher {
  private val trans = Seq(
    Transliterator.getInstance("Halfwidth-Fullwidth"),
    Transliterator.getInstance("Fullwidth-Halfwidth")
  )

  def isMatch(line: String, keyword: String): Boolean =
    trans.exists(isMatch(_, removeWhiteSpace(line), keyword))

  private def isMatch(trans: Transliterator, line: String, keyword: String): Boolean
    = trans.transliterate(line)
      .contains(keyword)

  private def removeWhiteSpace(v: String): String =
    v.replaceAll("　|\\s", "")
}
