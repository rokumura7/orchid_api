package utils

import com.ibm.icu.text.Transliterator

object KeywordMatcher {
  private val h2fTrans: Transliterator = Transliterator.getInstance("Halfwidth-Fullwidth")
  private val f2hTrans: Transliterator = Transliterator.getInstance("Fullwidth-Halfwidth")

  def isMatch(line: String, keyword: String): Boolean = {
    val _line = line.replaceAll("　|\\s", "")
    isMatch(f2hTrans, _line, keyword) || isMatch(h2fTrans, _line, keyword)
  }

  private def isMatch(trans: Transliterator, line: String, keyword: String): Boolean
    = trans.transliterate(line)
      .contains(keyword)
}
