package com.swegl.multipleChoice;

public class MCQuestion {
  private String text;
  private String hint;

  private MCAnswer[] answers = new MCAnswer[5];
  private int answersCounter = 0;

  public MCQuestion(String text, String hint) {
    this.text = text;
    this.hint = hint;
  }

  // VARIANTE 1: Als For Loop. Ist nicht performant
  // da es durch JEDE Antwort geht obwohl es eventuel schon
  // früher weiss ob es valid/invalid ist
  //
  // public boolean isValid() {
  //   boolean hasACorrectAnswer = false;
  //   boolean hasAnIncorrectAnswer = false;

  //   for (int j = 0; j < answersCounter; j++) {
  //     if (answers[j].isCorrect()) {
  //       hasACorrectAnswer = true;
  //     } else {
  //       hasAnIncorrectAnswer = true;
  //     }
  // }

  // return hasACorrectAnswer && hasAnIncorrectAnswer;
  // }

  // VARIANTE 2: Als for loop aber effizient. Gibt zurück ob valid/invalid
  // sofort sobald man es weiss.
  // ALLERDINGS: Manche Leute finden es nicht "schön" wenn man eine for-Loop
  // früh terminiert. Man sollte eher eine while-Loop nehmen
  //
  // public boolean isValid() {
  //   boolean hasACorrectAnswer = false;
  //   boolean hasAnIncorrectAnswer = false;

  //   for (int j = 0; j < answersCounter; j++) {
  //     if (answers[j].isCorrect()) {
  //       hasACorrectAnswer = true;
  //     } else {
  //       hasAnIncorrectAnswer = true;
  //     }
  //     if (hasACorrectAnswer && hasAnIncorrectAnswer) {
  //       return true;
  //     }
  //   }

  //   return false;
  // }

  public boolean isValid() {
  boolean hasACorrectAnswer = false;
  boolean hasAnIncorrectAnswer = false;

    int i = 0;

    while (!(hasACorrectAnswer && hasAnIncorrectAnswer) && i < answersCounter) {
      if (answers[i].isCorrect()) {
        hasACorrectAnswer = true;
      } else {
        hasAnIncorrectAnswer = true;
      }
      i++;
    }

    return hasACorrectAnswer && hasAnIncorrectAnswer;
  }

  public int count() {
    return this.answersCounter;
  }

  public boolean add(MCAnswer answer) {
    if (answersCounter >= 5) {
      return false;
    }

    answers[answersCounter] = answer;
    answersCounter++;
    return true;
  }

  public String getText() {
    return text;
  }

  public String getHint() {
    return hint;
  }
}
