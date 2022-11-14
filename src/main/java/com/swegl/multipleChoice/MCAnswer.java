package com.swegl.multipleChoice;

public class MCAnswer {
  private final String text;
  private final boolean correct;

  public MCAnswer(String text) {
    this(text, false);
  }

  public MCAnswer(String text, boolean correct) {
    this.text = text;
    this.correct = correct;
  }

  public String getText() {
    return text;
  }

  public boolean isCorrect() {
    return correct;
  }
}
