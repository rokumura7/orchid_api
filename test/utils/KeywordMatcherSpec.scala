package utils

import org.scalatestplus.play.PlaySpec

class KeywordMatcherSpec extends PlaySpec {
  "KeywordMatcher" must {
    "Matches two Fullwidth characters" in {
      val line = "焼きナス"
      val keyword = "ナス"
      KeywordMatcher.isMatch(line, keyword) mustBe true
    }

    "Matches Halfwidth to Fullwidth characters" in {
      val line = "焼きナス"
      val keyword = "ﾅｽ"
      KeywordMatcher.isMatch(line, keyword) mustBe true
    }

    "Matches Fullwidth to Halfwidth characters" in {
      val line = "焼きﾅｽ"
      val keyword = "ナス"
      KeywordMatcher.isMatch(line, keyword) mustBe true
    }

    "Matches characters with any symbols" in {
      val line = "焼きナス(日本産/1.5kg)"
      val keyword = "ナス"
      KeywordMatcher.isMatch(line, keyword) mustBe true
    }

    "Not match different words" in {
      val line = "焼きナス"
      val keyword = "トマト"
      KeywordMatcher.isMatch(line, keyword) mustBe false
    }
  }
}
