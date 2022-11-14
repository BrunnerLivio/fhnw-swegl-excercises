package com.swegl.multipleChoice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MCQuestionTest {
  @Test
  public void shouldCreateAQuestion() {
    MCQuestion question = new MCQuestion("Is the world flat?", "Don't be a flat earther please");

    assertEquals(question.getText(), "Is the world flat?");
    assertEquals(question.getHint(), "Don't be a flat earther please");
    assertFalse(question.isValid());
  }

  @Test
  public void shouldCreateAQuestionWithOneAnswer() {
    MCQuestion question = new MCQuestion("Is the world flat?", "Don't be a flat earther please");
    question.add(new MCAnswer("No", true));
    assertFalse(question.isValid());
  }

  @Test
  public void shouldCreateAQuestionWithTwoInvalidAnswers() {
    MCQuestion question = new MCQuestion("Is the world flat?", "Don't be a flat earther please");
    question.add(new MCAnswer("Yes"));
    question.add(new MCAnswer("Totally"));
    assertFalse(question.isValid());
  }

  @Test
  public void shouldCreateAValidQuestionWithTwoAnswers() {
    MCQuestion question = new MCQuestion("Is the world flat?", "Don't be a flat earther please");
    question.add(new MCAnswer("No", true));
    question.add(new MCAnswer("Yes"));
    assertTrue(question.isValid());
  }

  @Test
  public void shouldCreateAValidQuestionWithFiveAnswers() {
    MCQuestion question = new MCQuestion("Is the world flat?", "Don't be a flat earther please");
    question.add(new MCAnswer("Yes"));
    question.add(new MCAnswer("Maybe"));
    question.add(new MCAnswer("Totally"));
    question.add(new MCAnswer("Abolutely"));
    question.add(new MCAnswer("No", true));
    assertTrue(question.isValid());
  }

  @Test
  public void shouldCreateAnInvalidQuestionWithSixAnswers() {
    MCQuestion question = new MCQuestion("Is the world flat?", "Don't be a flat earther please");
    question.add(new MCAnswer("Yes"));
    question.add(new MCAnswer("Maybe"));
    question.add(new MCAnswer("Totally"));
    question.add(new MCAnswer("Abolutely"));
    question.add(new MCAnswer("YEESSS"));
    assertFalse(question.add(new MCAnswer("No", true)));
    assertFalse(question.isValid());
    assertEquals(question.count(), 5);
  }
}
