
import static org.junit.jupiter.api.Assertions.assertEquals;

import assignments.AlphabeticalSchedulingStrategy;
import assignments.AssignedSchedulingStrategy;
import assignments.Assignment;
import assignments.AssignmentList;
import assignments.DeadlineSchedulingStrategy;
import assignments.DifficultySchedulingStrategy;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Test Class for testing the implementation.
 *
 */
public class AssignmentTest {

  @Test
  public void testAssignedSchedulingStrategy() {
    Assignment t1 = new Assignment("task 1");
    Assignment t2 = new Assignment("task 2");
    Assignment t3 = new Assignment("task 3");

    AssignmentList assignmentList = new AssignmentList();
    assignmentList.add(t1);
    assignmentList.add(t2);
    assignmentList.add(t3);

    assignmentList.scheduleAssignments(new AssignedSchedulingStrategy());

    assertEquals(
        "Ordered by assigned\n" + "1 -- task 1, starting 2022-04-16, ending 2022-04-16\n"
            + "2 -- task 2, starting 2022-04-16, ending 2022-04-16\n"
            + "3 -- task 3, starting 2022-04-16, ending 2022-04-16\n" + "",
        assignmentList.toString());

  }

  @Test
  public void testAssignedSchedulingStrategyOrderPreservance() {
    Assignment t1 = new Assignment("sask 1");
    t1.setDeadline(3, 12, 2023);
    Assignment t2 = new Assignment("pask 2");
    t2.setDeadline(3, 13, 2023);
    Assignment t3 = new Assignment("qask 3");
    t3.setDeadline(3, 14, 2023);

    AssignmentList assignmentList = new AssignmentList();
    assignmentList.add(t1);
    assignmentList.add(t2);
    assignmentList.add(t3);

    assignmentList.scheduleAssignments(new AssignedSchedulingStrategy());

    String expected = assignmentList.toString();

    assignmentList.scheduleAssignments(new DeadlineSchedulingStrategy());

    assignmentList.scheduleAssignments(new AssignedSchedulingStrategy());

    assertEquals(expected, assignmentList.toString());

  }

  @Test
  public void testAlphabeticalSchedulingStrategy() {
    Assignment t1 = new Assignment("sask 1");
    Assignment t2 = new Assignment("pask 2");
    Assignment t3 = new Assignment("qask 3");

    AssignmentList assignmentList = new AssignmentList();
    assignmentList.add(t1);
    assignmentList.add(t2);
    assignmentList.add(t3);

    assignmentList.scheduleAssignments(new AlphabeticalSchedulingStrategy());

    assertEquals(
        "Ordered by alphabetical\n" + "1 -- pask 2, starting 2022-04-16, ending 2022-04-16\n"
            + "2 -- qask 3, starting 2022-04-16, ending 2022-04-16\n"
            + "3 -- sask 1, starting 2022-04-16, ending 2022-04-16\n" + "",
        assignmentList.toString());

  }

  @Test
  public void testAlphabeticalSchedulingStrategyWithOrderPreservance() {
    Assignment t1 = new Assignment("sask 1");
    t1.setDeadline(3, 12, 2023);
    Assignment t2 = new Assignment("pask 2");
    t2.setDeadline(3, 13, 2023);
    Assignment t3 = new Assignment("qask 3");
    t3.setDeadline(3, 14, 2023);

    AssignmentList assignmentList = new AssignmentList();
    assignmentList.add(t1);
    assignmentList.add(t2);
    assignmentList.add(t3);

    assignmentList.scheduleAssignments(new AlphabeticalSchedulingStrategy());

    String expected = assignmentList.toString();

    assignmentList.scheduleAssignments(new DeadlineSchedulingStrategy());

    assignmentList.scheduleAssignments(new AlphabeticalSchedulingStrategy());

    assertEquals(expected, assignmentList.toString());

  }

  @Test
  public void testDeadlineSchedulingStrategy() {
    Assignment t1 = new Assignment("sask 1");
    t1.setDeadline(3, 12, 2023);
    Assignment t2 = new Assignment("pask 2");
    t2.setDeadline(3, 13, 2023);
    Assignment t3 = new Assignment("qask 3");
    t3.setDeadline(3, 14, 2023);

    AssignmentList assignmentList = new AssignmentList();
    assignmentList.add(t1);
    assignmentList.add(t2);
    assignmentList.add(t3);

    assignmentList.scheduleAssignments(new DeadlineSchedulingStrategy());

    assertEquals(
        "Ordered by deadline\n" + "1 -- sask 1, starting 2022-04-16, ending 2023-03-12\n"
            + "2 -- pask 2, starting 2022-04-16, ending 2023-03-13\n"
            + "3 -- qask 3, starting 2022-04-16, ending 2023-03-14\n" + "",
        assignmentList.toString());

  }

  @Test
  public void testDeadlineSchedulingStrategyWithOrderPreservance() {
    Assignment t1 = new Assignment("sask 1");
    t1.setDeadline(3, 12, 2023);
    Assignment t2 = new Assignment("pask 2");
    t2.setDeadline(3, 13, 2023);
    Assignment t3 = new Assignment("qask 3");
    t3.setDeadline(3, 14, 2023);

    AssignmentList assignmentList = new AssignmentList();
    assignmentList.add(t1);
    assignmentList.add(t2);
    assignmentList.add(t3);

    assignmentList.scheduleAssignments(new DeadlineSchedulingStrategy());

    String expected = assignmentList.toString();

    assignmentList.scheduleAssignments(new AssignedSchedulingStrategy());

    assignmentList.scheduleAssignments(new DeadlineSchedulingStrategy());

    assertEquals(expected, assignmentList.toString());

  }

  @Test
  public void testDifficultySchedulingStrategy() {
    Assignment t1 = new Assignment("sask 1");
    t1.setDeadline(3, 12, 2023);

    Assignment t2 = new Assignment("pask 2");
    t2.setDeadline(3, 13, 2023);
    Assignment t3 = new Assignment("qask 3");
    t3.setDeadline(3, 14, 2023);

    AssignmentList assignmentList = new AssignmentList();
    assignmentList.add(t1);
    assignmentList.add(t2);
    assignmentList.add(t3);

    assignmentList.scheduleAssignments(new DifficultySchedulingStrategy());

    assertEquals(
        "Ordered by difficulty\n" + "1 -- qask 3, starting 2022-04-16, ending 2023-03-14\n"
            + "2 -- pask 2, starting 2022-04-16, ending 2023-03-13\n"
            + "3 -- sask 1, starting 2022-04-16, ending 2023-03-12\n" + "",
        assignmentList.toString());

  }

  @Test
  public void testDifficultySchedulingStrategyWithOrderPreservance() {
    Assignment t1 = new Assignment("sask 1");
    t1.setDeadline(3, 12, 2023);
    Assignment t2 = new Assignment("pask 2");
    t2.setDeadline(3, 13, 2023);
    Assignment t3 = new Assignment("qask 3");
    t3.setDeadline(3, 14, 2023);

    AssignmentList assignmentList = new AssignmentList();
    assignmentList.add(t1);
    assignmentList.add(t2);
    assignmentList.add(t3);

    assignmentList.scheduleAssignments(new DifficultySchedulingStrategy());

    String expected = assignmentList.toString();

    assignmentList.scheduleAssignments(new AssignedSchedulingStrategy());

    assignmentList.scheduleAssignments(new DifficultySchedulingStrategy());

    assertEquals(expected, assignmentList.toString());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testStrategyOnInvalidList() {
    Assignment t1 = new Assignment("sask 1");
    t1.setDeadline(3, 12, 2023);

    Assignment t2 = new Assignment("pask 2");
    t2.setDeadline(3, 13, 2023);

    List<Assignment> assignments = new ArrayList<>();
    assignments.add(t1);
    assignments.add(t2);
    assignments.add(null);
    new AlphabeticalSchedulingStrategy().schedule(assignments);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testStrategyOnNullList() {
    new AssignedSchedulingStrategy().schedule(null);

  }

}
